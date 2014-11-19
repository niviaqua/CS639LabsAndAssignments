package com.example.murlidhar.happyhours;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.murlidhar.happyhours.R;

class MyAdapter extends ArrayAdapter<String>{


    public MyAdapter(Context context, String[] values) {
        super(context, R.layout.row_layout_2, values);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater theInflater = LayoutInflater.from(getContext());

        View theView = theInflater.inflate(R.layout.row_layout_2, parent, false);

        String restaurant= getItem(position);

        TextView txtVw= (TextView) theView.findViewById(R.id.txtView);

        txtVw.setText(restaurant);

        ImageView theImgView= (ImageView) theView.findViewById(R.id.imgVw);

        theImgView.setImageResource(R.drawable.happyhouricon);

        return theView;


    }
}
