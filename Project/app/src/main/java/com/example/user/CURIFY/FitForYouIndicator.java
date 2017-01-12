package com.example.user.CURIFY;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
/**
 * Created by user on 13/01/2017.
 */

public class FitForYouIndicator {
    private String title = "";
    private String description = "";

    public void setTitle(String name) {
        this.title = name;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public String getDescription() {
        return description;
    }
}
