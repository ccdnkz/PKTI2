package com.example.user.CURIFY;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FELIX on 1/2/2017.
 */

public class DiseaseAdapter extends ArrayAdapter{
    List list = new ArrayList();
    public DiseaseAdapter(Context context, int resource) {
        super(context, resource);
    }
    static class DataHandler
    {
        ImageView Sign;
        TextView title;
        TextView status;
    }
    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row = convertView;
        DataHandler handler;
        if(convertView == null)
        {
            LayoutInflater inflater= (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.row_checkup_layout,parent,false);
            handler = new DataHandler();
            handler.Sign = (ImageView)row.findViewById(R.id.disease_sign);
            handler.title = (TextView)row.findViewById(R.id.disease_title);
            handler.status = (TextView)row.findViewById(R.id.disease_status);
            row.setTag(handler);
        }
        else{
            handler = (DataHandler)row.getTag();
        }
        DiseaseDataProvider dataProvider;
        dataProvider = (DiseaseDataProvider)this.getItem(position);
        handler.Sign.setImageResource(dataProvider.getDisease_sign_resource());
        handler.title.setText(dataProvider.getDisease_title());
        handler.status.setText(dataProvider.getDisease_status());

        return row;
    }
}
