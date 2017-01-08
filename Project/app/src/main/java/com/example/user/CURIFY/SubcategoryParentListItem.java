package com.example.user.CURIFY;

import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import java.util.List;

/**
 * Created by user on 05/01/2017.
 */
public class SubcategoryParentListItem implements ParentListItem {
    // object
    public String mTitle,mTitle1;
    public List<SubcategoryParentListItem> mChildItemList;

    public SubcategoryParentListItem() {
        //insert strings here
        mTitle = "Description";

    }

    @Override
    public List<SubcategoryParentListItem> getChildItemList() {
        return mChildItemList;
    }

    public void setChildItemList(List<SubcategoryParentListItem> list) {
        mChildItemList = list;
    }

    @Override    public boolean isInitiallyExpanded() {
        return false;
    }
}
