package com.example.yo.a9weekex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by yo on 2017-04-27.
 */

public class SpinnerAdapter extends BaseAdapter{

    String fruit[];
    Context context;

    public SpinnerAdapter(String[] fruit, Context context) {
        this.context = context;
        this.fruit = fruit;
    }
    @Override
    public int getCount() {
        return fruit.length;
    }

    @Override
    public Object getItem(int position){return fruit[position];}
    @Override
    public long getItemId(int position){return position;}
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.spinner_item,null);

        final TextView tvname = (TextView)convertView.findViewById(R.id.tvname);
        final CheckBox c1 = (CheckBox)convertView.findViewById(R.id.c1);
        tvname.setText(fruit[position]);
        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String msg = "선택되었습니다.";
                if(!isChecked) msg = "선택되지 않았습니다.";
                Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }
}
