package com.netgalaxystudios.pdfreader;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.util.FitPolicy;
import com.netgalaxystudios.pdfreader.netgalaxypdfreader.R;

import java.io.File;


public class PDFViewActivity extends AppCompatActivity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_reader);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        try{
            String pdfPath = getIntent().getExtras().getString("pdfPath");
            File file = new File(pdfPath);
            PDFView view = (PDFView) findViewById(R.id.pdfView);
            view.setBackgroundColor(Color.DKGRAY);
            view.fromFile(file)
                .defaultPage(1)
                .enableAnnotationRendering(true)
                .spacing(10) // in dp
                .pageFitPolicy(FitPolicy.BOTH)
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
        return super.onOptionsItemSelected(item);
    }

}
