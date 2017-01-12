package com.example.user.CURIFY;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by user on 11/01/2017.
 */

public class FitForYouAdapter extends BaseAdapter {
    private static ArrayList<FitForYouIndicator> fitforyouresult;

    private LayoutInflater mInflater;

    public FitForYouAdapter(Context context, ArrayList<FitForYouIndicator> results) {
        fitforyouresult = results;
        mInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return fitforyouresult.size();
    }

    public Object getItem(int position) {
        return fitforyouresult.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.ffulayout, null);
            holder = new ViewHolder();
            holder.txtTitle = (TextView) convertView.findViewById(R.id.titleffu);
            holder.txtDescription = (TextView) convertView
                    .findViewById(R.id.descffu);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtTitle.setText(fitforyouresult.get(position).getTitle());
        holder.txtDescription.setText(fitforyouresult.get(position)
                .getDescription());
        return convertView;
    }

    static class ViewHolder {
        TextView txtTitle;
        TextView txtDescription;
    }

}
