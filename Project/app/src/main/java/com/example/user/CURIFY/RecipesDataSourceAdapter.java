package com.example.user.CURIFY;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by User on 1/11/2017.
 */

public class RecipesDataSourceAdapter extends BaseAdapter {

    private Context myContext;
    private LayoutInflater myInflater;
    private RecipesDataSource myDataSrc;

    public RecipesDataSourceAdapter(Context ctx, RecipesDataSource ds){
        myContext = ctx;
        myDataSrc = ds;
        myInflater = (LayoutInflater)myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int arg0) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView thumbnail;
        TextView name;

        if(convertView==null)
            convertView = myInflater.inflate(R.layout.recipes_list_item, parent);
        thumbnail = (ImageView)convertView.findViewById(R.id.rlist_thumb);
        thumbnail.setImageResource(myDataSrc.getPhotoPool().get(position));
        name = (TextView)convertView.findViewById(R.id.rlist_text);
        name.setText(myDataSrc.getDishesPool().get(position));

        return convertView;
    }
}
