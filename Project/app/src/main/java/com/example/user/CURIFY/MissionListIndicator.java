package com.example.user.CURIFY;

import android.widget.Button;

import static android.R.attr.button;

/**
 * Created by user on 11/01/2017.
 */

public class MissionListIndicator {
    private String name = "";
    private String description = "";
    private String reward="";

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public String getDescription() {
        return description;
    }

    public void setReward(String rwd) {
        this.reward = rwd;
    }

    public String getReward() {
        return reward;
    }


}
