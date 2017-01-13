package com.example.user.CURIFY;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FitForYou extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fit_for_you);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ArrayList<FitForYouIndicator> fitForYouIndicators = GetFitForYouIndicator();

        final ListView lv = (ListView) findViewById(R.id.fitforyoulistview);
        lv.setAdapter(new FitForYouAdapter(this, fitForYouIndicators));


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = lv.getItemAtPosition(position);
                FitForYouIndicator fullObject = (FitForYouIndicator) o;
                Toast.makeText(FitForYou.this, "You have chosen: " + " " + fullObject.getTitle(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private ArrayList<FitForYouIndicator> GetFitForYouIndicator(){
        ArrayList<FitForYouIndicator> results = new ArrayList<FitForYouIndicator>();

        FitForYouIndicator fr = new FitForYouIndicator();
        fr.setTitle("BMI");
        fr.setDescription("Body Mass Index");
        results.add(fr);

        fr = new FitForYouIndicator();
        fr.setTitle("Heart Drive");
        fr.setDescription("Check your heart beat");
        results.add(fr);

        fr = new FitForYouIndicator();
        fr.setTitle("Stress Indicator");
        fr.setDescription("Indicate your stress percentage");
        results.add(fr);

        return results;
    }
}
