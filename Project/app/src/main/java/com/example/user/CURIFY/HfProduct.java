package com.example.user.CURIFY;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by User on 12/17/2016.
 */

public class HfProduct {
    private int imageId;
    private String title;
    private String description;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HfProduct(int imageId, String title, String description){
        this.imageId = imageId;
        this.title = title;
        this.description = description;
    }

}
