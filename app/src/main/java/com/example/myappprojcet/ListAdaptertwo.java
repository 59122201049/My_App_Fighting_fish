package com.example.myappprojcet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdaptertwo extends BaseAdapter {
    Context context;
    //Dog dogs = new Dog();
    Bettatwo bettatwos;

    ListAdaptertwo(Context context, Bettatwo bettatwos) {
        this.context = context;
        this.bettatwos = bettatwos;
    }

    @Override
    public int getCount() {
        if (bettatwos == null)
            return 0;
        if (bettatwos.getBettatwos() == null)
            return 0;

        return bettatwos.getBettatwos().size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        LayoutInflater mInflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = mInflater.inflate(R.layout.list_itemtwo, parent, false);
//        if(convertView != null){
//            view = convertView;
//        }else {
//            view = mInflater.inflate(R.layout.list_item, parent, false);
//        }

        TextView textView = (TextView) view.findViewById(R.id.title1);
        ImageView imageView = (ImageView) view.findViewById(R.id.image1);
        TextView textDesc = (TextView) view.findViewById(R.id.desc1);


        if (bettatwos != null && bettatwos.getBettatwos() != null){
            textView.setText(bettatwos.getBettatwos().get(position).getBreed1());
            imageView.setImageResource(bettatwos.getBettatwos().get(position).getResId1());
            textDesc.setText(bettatwos.getBettatwos().get(position).getDescription1());
        }


//        if (convertView != null)
//            view = convertView;
        return view;


    }
}
