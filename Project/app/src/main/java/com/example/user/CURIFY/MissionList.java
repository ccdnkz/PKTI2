package com.example.user.CURIFY;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class MissionList extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_mission_list);

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
        sr.setName("Justin Schultz");
        sr.setCityState("San Francisco, CA");
        sr.setPhone("415-555-1234");
        results.add(sr);

        sr = new MissionListIndicator();
        sr.setName("Jane Doe");
        sr.setCityState("Las Vegas, NV");
        sr.setPhone("702-555-1234");
        results.add(sr);

        sr = new MissionListIndicator();
        sr.setName("Lauren Sherman");
        sr.setCityState("San Francisco, CA");
        sr.setPhone("415-555-1234");
        results.add(sr);

        sr = new MissionListIndicator();
        sr.setName("Fred Jones");
        sr.setCityState("Minneapolis, MN");
        sr.setPhone("612-555-8214");
        results.add(sr);

        sr = new MissionListIndicator();
        sr.setName("Bill Withers");
        sr.setCityState("Los Angeles, CA");
        sr.setPhone("424-555-8214");
        results.add(sr);

        sr = new MissionListIndicator();
        sr.setName("Donald Fagen");
        sr.setCityState("Los Angeles, CA");
        sr.setPhone("424-555-1234");
        results.add(sr);

        sr = new MissionListIndicator();
        sr.setName("Steve Rude");
        sr.setCityState("Oakland, CA");
        sr.setPhone("515-555-2222");
        results.add(sr);

        sr = new MissionListIndicator();
        sr.setName("Roland Bloom");
        sr.setCityState("Chelmsford, MA");
        sr.setPhone("978-555-1111");
        results.add(sr);

        sr = new MissionListIndicator();
        sr.setName("Sandy Baguskas");
        sr.setCityState("Chelmsford, MA");
        sr.setPhone("978-555-2222");
        results.add(sr);

        sr = new MissionListIndicator();
        sr.setName("Scott Taylor");
        sr.setCityState("Austin, TX");
        sr.setPhone("512-555-2222");
        results.add(sr);

        return results;
    }
}