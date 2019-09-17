package com.example.practicapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.practicapp.model.Ghibli;

import java.util.ArrayList;

public class GhibliAdapter extends ArrayAdapter<Ghibli> {
    int layoutResourceId;
    Context context;
    ArrayList<Ghibli> data;

    public GhibliAdapter(Context context, int layoutResourceId, ArrayList<Ghibli> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row2;
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        row2 = inflater.inflate(layoutResourceId, parent, false);
        TextView tv_titol;
        tv_titol = row2.findViewById(R.id.tv_titols);

        Ghibli g = data.get(position);

        tv_titol.setText(g.getTitle());

//Altres camps
        return row2;
    }
}
