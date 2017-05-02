package com.example.yo.a9weekex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by yo on 2017-04-27.
 */

public class GridAdapter extends BaseAdapter {
    Context context;
    ArrayList<Fruit2> fruit;
    ArrayList<Fruit2> fruit_price;
    boolean check = false;
    public GridAdapter(Context context, ArrayList<Fruit2> fruit) {
        this.context = context;
        this.fruit = fruit;
    }
    @Override
    public int getCount(){return fruit.size();}

    @Override
    public Object getItem(int position){return fruit.get(position);}
    @Override
    public long getItemId(int position){return position;}
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.fruit,null);

        final ImageView image1 = (ImageView)convertView.findViewById(R.id.image1);
        final TextView tv = (TextView)convertView.findViewById(R.id.tv);
        final TextView tv2 = (TextView)convertView.findViewById(R.id.tv2);

        tv.setText(fruit.get(position).name);
        tv2.setText(fruit.get(position).price);
        image1.setImageResource(fruit.get(position).image);
        if(check){
            tv2.setVisibility(View.VISIBLE);
        }
        else{
            tv2.setVisibility(View.INVISIBLE);
        }
//        if(convertView == null)
//            convertView = new GrindItem(context);
//
//        ((GrindItem)convertView).setData(fruit.get(position));



        return convertView;
    }
    public void addFruit(Fruit2 fruit2){
        fruit.add(fruit2);
    }
    public void setFruit(int position, Fruit2 fruit2){
        fruit.set(position, fruit2);
    }
    public void showprice(boolean checked){
        check = checked;
        notifyDataSetChanged();
    }
    public String getName(int position){
        return fruit.get(position).getName();
    }
    public int getImage(int position){
        return fruit.get(position).getImage();
    }
}
