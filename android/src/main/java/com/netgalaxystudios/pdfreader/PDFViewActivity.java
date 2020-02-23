package com.netgalaxystudios.pdfreader;


import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.util.FitPolicy;
import com.netgalaxystudios.pdfreader.netgalaxypdfreader.R;
import com.netgalaxystudios.pdfreader.tree.AndroidTreeView;
import com.netgalaxystudios.pdfreader.tree.MyHolder;
import com.netgalaxystudios.pdfreader.tree.TreeNode;

import java.io.File;
import java.util.List;


public class PDFViewActivity extends AppCompatActivity implements OnLoadCompleteListener {

    PDFView pdfView;
    List<com.shockwave.pdfium.PdfDocument.Bookmark> toc = null;
    View treeView = null;
    AlertDialog tocDialog = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_reader);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

		String pdfPath = getIntent().getExtras().getString("pdfPath");
		String title = getIntent().getExtras().getString("title");

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
			getSupportActionBar().setTitle(title);
        }

        try{    
			
            File file = new File(pdfPath);
            pdfView = (PDFView) findViewById(R.id.pdfView);
            pdfView.setBackgroundColor(Color.DKGRAY);
            pdfView.fromFile(file)
                .defaultPage(1)
                .enableAnnotationRendering(true)
                .spacing(10) // in dp
                .pageFitPolicy(FitPolicy.BOTH).onLoad(this)
                .load();

        }catch (NullPointerException ex){
            Log.d("","");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }
        if(item.getItemId() == R.id.open_toc){
            showTOC();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void loadComplete(int nbPages) {

        com.shockwave.pdfium.PdfDocument.Meta meta = pdfView.getDocumentMeta();
        toc = pdfView.getTableOfContents();

        if(toc.size() <= 0){
            toc = null;
            return;
        }

        createTreeView();


    }

    public void createTreeView(){
        TreeNode root = TreeNode.root();
        populateRoot(root,toc,0);
        treeView =  new AndroidTreeView(getApplicationContext(), root).getView();
        treeView.setPadding(16,16,16,16);
    }


    public void populateRoot(TreeNode root, List<com.shockwave.pdfium.PdfDocument.Bookmark> tree, int level){

        if(tree == null || tree.size() == 0)
            return;

        for (final com.shockwave.pdfium.PdfDocument.Bookmark b : tree){

            int icon = R.drawable.ic_folder;
            if(!b.hasChildren()){
                icon = R.drawable.ic_bookmark_white_24dp;
            }

            MyHolder.IconTreeItem childItem = new MyHolder.IconTreeItem( icon, b.getTitle());
            TreeNode child = new TreeNode(childItem).setViewHolder(new MyHolder(getApplicationContext(), b.hasChildren() , R.layout.child, level*40 ));
            child.setExpanded(true);
            child.setSelectable(true);
            if(b.hasChildren()){
                populateRoot(child,b.getChildren(),level+1);
            }else{
                child.setClickListener(new TreeNode.TreeNodeClickListener() {
                    @Override
                    public void onClick(TreeNode node, Object value) {
                        if(pdfView != null){
                            pdfView.jumpTo((int)b.getPageIdx(),true);
                            if(tocDialog != null){
                                tocDialog.hide();
                            }
                        }
                    }
                });
            }
            root.addChild(child);
        }

    }

    void showTOC() {

        if(tocDialog != null){
            tocDialog.show();
            return;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.myDialog));
        builder.setView(treeView);
        builder.setPositiveButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        AlertDialog dialog = builder.create();
        dialog.setTitle("Table Of Content");
        dialog.show();

        tocDialog = dialog;


    }

}
