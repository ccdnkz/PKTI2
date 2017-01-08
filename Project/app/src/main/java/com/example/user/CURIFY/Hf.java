package com.example.user.CURIFY;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Reference : https://www.youtube.com/watch?v=gonDFGLY0hU
 */

public class Hf extends AppCompatActivity{
    private ViewStub stubGrid;
    //private ViewStub stubList;
    //private ListView listView;
    private GridView gridview;
    //private HfListViewAdapter listViewAdapter;
    private HfGridViewAdapter gridViewAdapter;
    private List<HfProduct> productList;
    private int currentViewMode = 1;

    //static final int VIEW_MODE_LISTVIEW = 0;
    static final int VIEW_MODE_GRIDVIEW = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hf_main);

        //stubList = (ViewStub) findViewById(R.id.stub_list);
        stubGrid = (ViewStub) findViewById(R.id.stub_grid);

        //stubList.inflate();
        stubGrid.inflate();

        //listView = (ListView) findViewById(R.id.mylistview);
        gridview = (GridView) findViewById(R.id.mygridview);

        getProductList();

        SharedPreferences sharedPreferences = getSharedPreferences("ViewMode", MODE_PRIVATE);
        currentViewMode = sharedPreferences.getInt("currentViewMode", VIEW_MODE_GRIDVIEW);

        //listView.setOnItemClickListener(onItemClick);
        gridview.setOnItemClickListener(onItemClick);

        //switchView();
    }

    /*private void switchView(){
        if (VIEW_MODE_LISTVIEW == currentViewMode){
            stubList.setVisibility(View.VISIBLE);
            stubGrid.setVisibility(View.GONE);
        }
        else{
            stubGrid.setVisibility(View.VISIBLE);
            stubList.setVisibility(View.GONE);
        }
        setAdapters();
    }

    private void setAdapters(){
        if(VIEW_MODE_LISTVIEW == currentViewMode){
            listViewAdapter = new HfListViewAdapter(this, R.layout.hf_list_item, productList);
            listView.setAdapter(listViewAdapter);
        }
        else{
            gridViewAdapter = new HfGridViewAdapter(this, R.layout.hf_grid_item, productList);
            gridview.setAdapter(gridViewAdapter);
        }
    }*/

    public List<HfProduct> getProductList(){
        productList = new ArrayList<>();
        productList.add(new HfProduct(R.drawable.food_item, "Title 1", "This is description 1"));
        productList.add(new HfProduct(R.drawable.food_item, "Title 2", "This is description 1"));
        productList.add(new HfProduct(R.drawable.food_item, "Title 3", "This is description 1"));
        productList.add(new HfProduct(R.drawable.food_item, "Title 4", "This is description 1"));
        productList.add(new HfProduct(R.drawable.food_item, "Title 5", "This is description 1"));
        productList.add(new HfProduct(R.drawable.food_item, "Title 6", "This is description 1"));
        productList.add(new HfProduct(R.drawable.food_item, "Title 7", "This is description 1"));
        productList.add(new HfProduct(R.drawable.food_item, "Title 8", "This is description 1"));
        productList.add(new HfProduct(R.drawable.food_item, "Title 9", "This is description 1"));

        return productList;
    }

    AdapterView.OnItemClickListener onItemClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(getApplicationContext(), productList.get(position).getTitle() + " - " + productList.get(position).getDescription(), Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_hf, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.item_menu_1:
                if(VIEW_MODE_LISTVIEW == currentViewMode){
                    currentViewMode = VIEW_MODE_GRIDVIEW;
                }else{
                    currentViewMode = VIEW_MODE_LISTVIEW;
                }
                switchView();
                SharedPreferences sharedPreferences = getSharedPreferences("ViewMode", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("currentViewMode", currentViewMode);
                editor.commit();

                break;
        }
        return true;*/
    }


