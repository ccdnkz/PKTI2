package com.example.user.CURIFY;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class OldHealthyFair extends AppCompatActivity {
    Toolbar toolbar;
    private ViewStub stubGrid;
    private GridView gridview;
    private HfGridViewAdapter gridViewAdapter;
    private List<HfProduct> productList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.old_hf);

        Toolbar toolbar = (Toolbar) findViewById(R.id.hf_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        stubGrid = (ViewStub) findViewById(R.id.stub_grid);
        stubGrid.inflate();
        gridview = (GridView) findViewById(R.id.mygridview);
        getProductList();

        gridViewAdapter = new HfGridViewAdapter(this, R.layout.hf_grid_item, productList);
        gridview.setAdapter(gridViewAdapter);
    }
    public List<HfProduct> getProductList(){
        productList = new ArrayList<>();
        String itemdesc = getResources().getString(R.string.item_description);
        productList.add(new HfProduct(R.drawable.food_item, "Title 1", itemdesc));
        productList.add(new HfProduct(R.drawable.food_item, "Title 2", itemdesc));
        productList.add(new HfProduct(R.drawable.food_item, "Title 3", itemdesc));
        productList.add(new HfProduct(R.drawable.food_item, "Title 4", itemdesc));
        productList.add(new HfProduct(R.drawable.food_item, "Title 5", itemdesc));
        productList.add(new HfProduct(R.drawable.food_item, "Title 6", itemdesc));
        productList.add(new HfProduct(R.drawable.food_item, "Title 7", itemdesc));
        productList.add(new HfProduct(R.drawable.food_item, "Title 8", itemdesc));
        productList.add(new HfProduct(R.drawable.food_item, "Title 9", itemdesc));

        return productList;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_navigation, menu);
        return true;
    }

    AdapterView.OnItemClickListener onItemClick = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(getApplicationContext(), productList.get(position).getTitle() + " - " + productList.get(position).getDescription(), Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}