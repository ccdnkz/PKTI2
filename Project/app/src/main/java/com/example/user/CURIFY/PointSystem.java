package com.example.user.CURIFY;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class PointSystem extends AppCompatActivity {
    int e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point_system);
        TextView tv = (TextView)findViewById(R.id.jumlahpoin);
        Intent intent = getIntent();
        e1 = intent.getIntExtra("e1",0);
        tv.setText(Integer.toString(e1));

    }
}
