package com.example.user.CURIFY;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by User on 1/11/2017.
 */

public class RecipesDataSource {
    private ArrayList<Integer> photoPool;
    private ArrayList<Integer> descriptionPool;
    private ArrayList<Integer> dishesPool;

    public ArrayList<Integer> getDescriptionPool() {
        return descriptionPool;
    }

    public ArrayList<Integer> getPhotoPool() {
        return photoPool;
    }

    public ArrayList<Integer> getDishesPool() {
        return dishesPool;
    }

    public RecipesDataSource() {
        photoPool = new ArrayList<Integer>();
        descriptionPool = new ArrayList<Integer>();
        dishesPool = new ArrayList<Integer>();
        setupPhotoPool();
        setupDescriptionPool();
        setupDishesPool();
    }

    public void setupPhotoPool(){
        photoPool.add(R.drawable.resep1);
        photoPool.add(R.drawable.resep2);
        photoPool.add(R.drawable.resep3);
        photoPool.add(R.drawable.resep4);
        photoPool.add(R.drawable.resep5);
    }

    public void setupDishesPool(){
        dishesPool.add(R.string.resep1);
        dishesPool.add(R.string.resep2);
        dishesPool.add(R.string.resep3);
        dishesPool.add(R.string.resep4);
        dishesPool.add(R.string.resep5);
    }

    public void setupDescriptionPool(){
        descriptionPool.add(R.string.rdesc1);
        descriptionPool.add(R.string.rdesc2);
        descriptionPool.add(R.string.rdesc3);
        descriptionPool.add(R.string.rdesc4);
        descriptionPool.add(R.string.rdesc5);
    }

    public int getDataSourceLength(){
        return photoPool.size();
    }
}
