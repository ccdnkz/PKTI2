package com.example.user.CURIFY;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;


public class CheckUp extends AppCompatActivity {

    ListView listView;
    int[] disease_sign = {R.drawable.curable,R.drawable.curable,
            R.drawable.warning,R.drawable.warning,
            R.drawable.curable,R.drawable.disorder};
    String[] disease_titles;
    String[] disease_statuses;
    DiseaseAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_up);
        listView = (ListView)findViewById(R.id.list_view_checkup);
        disease_statuses = getResources().getStringArray(R.array.disease_statuses);
        disease_titles = getResources().getStringArray(R.array.disease_titles);
        int i=0;
        adapter = new DiseaseAdapter(getApplicationContext(),R.layout.row_checkup_layout);
        listView.setAdapter(adapter);
        for(String titles: disease_titles)
        {
            DiseaseDataProvider diseaseDataProvider = new DiseaseDataProvider(disease_sign[i],titles,disease_statuses[i]);
            adapter.add(diseaseDataProvider);
            i++;

        }
    }

}
