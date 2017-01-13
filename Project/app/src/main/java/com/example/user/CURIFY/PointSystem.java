package com.example.user.CURIFY;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;


public class PointSystem extends AppCompatActivity {
    int SearchQueryTerm=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point_system);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView tv = (TextView)findViewById(R.id.jumlahpoin);
        //Intent intent = getIntent();
        //e2 = intent.getIntExtra("e1",0);
        //tv.setText(Integer.toString(e2));

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            SearchQueryTerm = extras.getInt("e1");
        }
        tv.setText(Integer.toString(SearchQueryTerm));

    }
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
