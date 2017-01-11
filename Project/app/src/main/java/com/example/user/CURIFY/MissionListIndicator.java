package com.example.user.CURIFY;

import android.widget.Button;

import static android.R.attr.button;

/**
 * Created by user on 11/01/2017.
 */

public class MissionListIndicator {
    private String name = "";
    private String cityState = "";
    private String phone = "";
    Button button;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCityState(String cityState) {
        this.cityState = cityState;
    }

    public String getCityState() {
        return cityState;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }


}
