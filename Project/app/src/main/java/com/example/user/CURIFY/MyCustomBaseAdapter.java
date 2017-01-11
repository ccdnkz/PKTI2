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

public class MyCustomBaseAdapter extends BaseAdapter {
    private static ArrayList<MissionListIndicator> searchArrayList;

    private LayoutInflater mInflater;

    public MyCustomBaseAdapter(Context context, ArrayList<MissionListIndicator> results) {
        searchArrayList = results;
        mInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return searchArrayList.size();
    }

    public Object getItem(int position) {
        return searchArrayList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.row_mission, null);
            holder = new ViewHolder();
            holder.txtName = (TextView) convertView.findViewById(R.id.name);
            holder.txtDescription = (TextView) convertView
                    .findViewById(R.id.description);
            holder.rwdPoint = (TextView) convertView.findViewById(R.id.reward);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtName.setText(searchArrayList.get(position).getName());
        holder.txtDescription.setText(searchArrayList.get(position)
                .getDescription());
        holder.rwdPoint.setText(searchArrayList.get(position).getReward());

        return convertView;
    }

    static class ViewHolder {
        TextView txtName;
        TextView txtDescription;
        TextView rwdPoint;
    }

}
