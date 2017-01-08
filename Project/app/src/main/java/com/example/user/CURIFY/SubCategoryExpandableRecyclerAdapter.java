package com.example.user.CURIFY;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;

import java.util.List;

/**
 * Created by user on 05/01/2017.
 */
public class SubCategoryExpandableRecyclerAdapter extends ExpandableRecyclerAdapter<SubCategoryExpandableRecyclerAdapter.MyParentViewHolder, SubCategoryExpandableRecyclerAdapter.MyChildViewHolder> {
    private LayoutInflater mInflater;

    public SubCategoryExpandableRecyclerAdapter(Context context, List<ParentListItem> itemList) {
        super(itemList);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public MyParentViewHolder onCreateParentViewHolder(ViewGroup viewGroup) {
        View view = mInflater.inflate(R.layout.item_subcategory_fragment_elv_group, viewGroup, false);
        return new MyParentViewHolder(view);
    }

    @Override
    public MyChildViewHolder onCreateChildViewHolder(ViewGroup viewGroup) {
        View view = mInflater.inflate(R.layout.item_subcategory_fragment_elv_child, viewGroup, false);
        return new MyChildViewHolder(view);
    }

    @Override
    public void onBindParentViewHolder(MyParentViewHolder parentViewHolder, int position, ParentListItem parentListItem) {
        SubcategoryParentListItem subcategoryParentListItem = (SubcategoryParentListItem) parentListItem;
        // handler for row parent
        parentViewHolder.lblListHeader.setText(subcategoryParentListItem.mTitle);

    }

    @Override
    public void onBindChildViewHolder(MyChildViewHolder childViewHolder, int position, Object childListItem) {
        SubcategoryParentListItem subcategoryChildListItem = (SubcategoryParentListItem) childListItem;
        // handler for row child
        childViewHolder.txtListChild.setText(subcategoryChildListItem.mTitle);

    }

    public class MyParentViewHolder extends ParentViewHolder {

        public TextView lblListHeader;

        public MyParentViewHolder(View itemView) {
            super(itemView);
            // init view parent
            lblListHeader = (TextView) itemView.findViewById(R.id.lblListHeader);
        }
    }


    public class MyChildViewHolder extends ChildViewHolder {

        public TextView txtListChild;

        public MyChildViewHolder(View itemView) {
            super(itemView);
            // init view child list
            txtListChild = (TextView) itemView.findViewById(R.id.lblListItem);
        }
    }
}
