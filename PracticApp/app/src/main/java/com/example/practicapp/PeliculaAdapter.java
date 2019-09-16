package com.example.practicapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.practicapp.model.Pelicula;

import java.util.ArrayList;

public class PeliculaAdapter extends ArrayAdapter <Pelicula> {

    int layoutResourceId;
    Context context;
    ArrayList<Pelicula> data;
    public PeliculaAdapter(Context context, int layoutResourceId, ArrayList<Pelicula> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        row = inflater.inflate(layoutResourceId, parent, false);

        TextView tv_titol = row.findViewById(R.id.tv_titol);
        TextView tv_puntuacio = row.findViewById(R.id.tv_puntuacio);

        int punts = data.get(position).getPuntuacio();
        String titul = data.get(position).getTitol();

        if(punts<2){
            tv_puntuacio.setTextColor(context.getResources().getColor(R.color.vermell));
        }else if (punts>3){
            tv_puntuacio.setTextColor(context.getResources().getColor(R.color.verd));
        }else{
            tv_puntuacio.setTextColor(context.getResources().getColor(R.color.negre));
        }

        tv_titol.setText(titul);
        tv_puntuacio.setText(String.valueOf(punts));
//Altres camps
        return row;
    }
}
