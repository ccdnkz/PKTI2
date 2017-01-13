package com.example.user.CURIFY;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MissionList extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.msnlisttoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ArrayList<MissionListIndicator> missionListIndicator = GetMissionListIndicator();

        final ListView lv = (ListView) findViewById(R.id.srListView);
        lv.setAdapter(new MyCustomBaseAdapter(this, missionListIndicator));


        lv.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = lv.getItemAtPosition(position);
                MissionListIndicator fullObject = (MissionListIndicator)o;
                Toast.makeText(MissionList.this, "You have chosen: " + " " + fullObject.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private ArrayList<MissionListIndicator> GetMissionListIndicator(){
        ArrayList<MissionListIndicator> results = new ArrayList<MissionListIndicator>();

        MissionListIndicator sr = new MissionListIndicator();
        sr.setName("8KFS");
        sr.setDescription("8,000 footsteps");
        sr.setReward("30 points");
        results.add(sr);

        sr = new MissionListIndicator();
        sr.setName("5KFS");
        sr.setDescription("5,000 footsteps");
        sr.setReward("20 points");
        results.add(sr);

        sr = new MissionListIndicator();
        sr.setName("10KFS");
        sr.setDescription("10,000 footsteps");
        sr.setReward("40 points");
        results.add(sr);

        sr = new MissionListIndicator();
        sr.setName("12KFS");
        sr.setDescription("12,000 footsteps");
        sr.setReward("55 points");
        results.add(sr);

        sr = new MissionListIndicator();
        sr.setName("1KFS");
        sr.setDescription("1,000 footsteps");
        sr.setReward("0 points");
        results.add(sr);

        sr = new MissionListIndicator();
        sr.setName("3KFS");
        sr.setDescription("3,000 footsteps");
        sr.setReward("5 points");
        results.add(sr);

        return results;
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