package com.netgalaxystudios.pdfreader.tree;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.netgalaxystudios.pdfreader.netgalaxypdfreader.R;
import com.netgalaxystudios.pdfreader.tree.TreeNode;


/**
 * Created by admin on 31-03-2016.
 */
public class MyHolder extends TreeNode.BaseNodeViewHolder<MyHolder.IconTreeItem> {
    public static final int DEFAULT = 0;

    ImageView img;
    TextView tvValue;
    boolean toggle;
    int child;
    int leftMargin;

    public MyHolder(Context context, boolean toggle, int child, int leftMargin) {
        super(context);
        this.toggle = toggle;
        this.child = child;
        this.leftMargin = leftMargin;
    }

    @Override
    public View createNodeView(TreeNode node, IconTreeItem value) {
        final LayoutInflater inflater = LayoutInflater.from(context);
        final View view;
        if (child == DEFAULT) {
            view = inflater.inflate(R.layout.parent, null, false);
        } else {
            view = inflater.inflate(child, null, false);
        }

        if (leftMargin == DEFAULT) {
            leftMargin = getDimens(R.dimen.treeview_left_padding);
        }
        view.setPadding(leftMargin, getDimens(R.dimen.treeview_top_padding), getDimens(R.dimen.treeview_right_padding), getDimens(R.dimen.treeview_bottom_padding));

        img = (ImageView) view.findViewById(R.id.image);
        tvValue = (TextView) view.findViewById(R.id.text);
        img.setImageResource(value.icon);
        tvValue.setText(value.text);
        return view;
    }

    public void toggle(boolean active) {
        if (toggle)
            img.setImageResource(active ? R.drawable.ic_arrow_drop_up : R.drawable.ic_arrow_drop_down);
    }

    public static class IconTreeItem {
        public int icon;
        public String text;

        public IconTreeItem(int icon, String text) {
            this.icon = icon;
            this.text = text;
        }
    }

    private int getDimens(int resId) {
        return (int) (context.getResources().getDimension(resId) / context.getResources().getDisplayMetrics().density)
                ;
    }
}
