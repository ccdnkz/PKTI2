package com.example.user.CURIFY;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 12/20/2016.
 */

public class IdProfile extends ActionBarActivity //implements View.OnClickListener
{
    RecyclerView recycler_view;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.id_profile);
        List<ParentListItem> parentListItems = new ArrayList<>();
        List<SubcategoryParentListItem> listItems = new ArrayList<>();
        //child
        for (int i = 0; i < 1; i++) {
            SubcategoryParentListItem ob = new SubcategoryParentListItem();
            listItems.add(ob);
        }

        //parent
        for (int i = 0; i < 2; i++) {
            SubcategoryParentListItem ob = new SubcategoryParentListItem();
            ob.setChildItemList(listItems);
            parentListItems.add(ob);
        }
        //set adapter
        recycler_view = (RecyclerView) findViewById(R.id.profile_recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recycler_view.setLayoutManager(mLayoutManager);
        recycler_view.setAdapter(new SubCategoryExpandableRecyclerAdapter(this, parentListItems));
    }
}
