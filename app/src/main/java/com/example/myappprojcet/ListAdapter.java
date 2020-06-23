package com.example.myappprojcet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdapter extends BaseAdapter {
    Context context;
    //Dog dogs = new Dog();
    Betta bettas;

    ListAdapter(Context context, Betta bettas) {
        this.context = context;
        this.bettas = bettas;
    }

    @Override
    public int getCount() {
        if (bettas == null)
            return 0;
        if (bettas.getBettas() == null)
            return 0;

        return bettas.getBettas().size();
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
        view = mInflater.inflate(R.layout.list_item, parent, false);
//        if(convertView != null){
//            view = convertView;
//        }else {
//            view = mInflater.inflate(R.layout.list_item, parent, false);
//        }

        TextView textView = (TextView) view.findViewById(R.id.title);
        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        TextView textDesc = (TextView) view.findViewById(R.id.desc);


        if (bettas != null && bettas.getBettas() != null){
            textView.setText(bettas.getBettas().get(position).getBreed());
            imageView.setImageResource(bettas.getBettas().get(position).getResId());
            textDesc.setText(bettas.getBettas().get(position).getDescription());
        }


//        if (convertView != null)
//            view = convertView;
        return view;


    }
}
