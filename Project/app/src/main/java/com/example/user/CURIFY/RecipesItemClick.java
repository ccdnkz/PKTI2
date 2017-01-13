package com.example.user.CURIFY;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

/**
 * Created by User on 1/13/2017.
 */

public class RecipesItemClick extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipes_itemclick);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        ImageView img_resep = (ImageView)findViewById(R.id.img_resep);

        /*Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            toolbar.setTitle(bundle.getString(itemname));
            if(toolbar.getTitle().toString().equalsIgnoreCase("Grilled Vegetable Wrap")){
                img_resep.setImageDrawable(ContextCompat.getDrawable(RecipesItemClick.this, R.drawable.resep1));
            } else if(toolbar.getTitle().toString().equalsIgnoreCase("Sweet Oatmeal Bowls")){
                img_resep.setImageDrawable(ContextCompat.getDrawable(RecipesItemClick.this, R.drawable.resep2));
            } else if(toolbar.getTitle().toString().equalsIgnoreCase("Broiled Salmon with Herb Mustard Glaze")){
                img_resep.setImageDrawable(ContextCompat.getDrawable(RecipesItemClick.this, R.drawable.resep3));
            } else if(toolbar.getTitle().toString().equalsIgnoreCase("Florentine Meatballs")){
                img_resep.setImageDrawable(ContextCompat.getDrawable(RecipesItemClick.this, R.drawable.resep4));
            } else if(toolbar.getTitle().toString().equalsIgnoreCase("Savory Oatmeal Bowls")){
                img_resep.setImageDrawable(ContextCompat.getDrawable(RecipesItemClick.this, R.drawable.resep5));
            } else if(toolbar.getTitle().toString().equalsIgnoreCase("French Veggie Loaf")){
                img_resep.setImageDrawable(ContextCompat.getDrawable(RecipesItemClick.this, R.drawable.resep6));
            } else if(toolbar.getTitle().toString().equalsIgnoreCase("Artichoke and Spinach Dip")){
                img_resep.setImageDrawable(ContextCompat.getDrawable(RecipesItemClick.this, R.drawable.resep7));
            }
        }*/
    }
}
