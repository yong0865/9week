package com.example.yo.a9weekex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by yo on 2017-04-27.
 */

public class GrindItem extends LinearLayout {
    ImageView image1;
    TextView tv,tv2;
    public GrindItem(Context context) {
        super(context);
        init(context);

    }
    public void init(Context context){
        View view = LayoutInflater.from(context).inflate(R.layout.fruit,this);
        image1 = (ImageView)findViewById(R.id.image1);
        tv = (TextView)findViewById(R.id.tv);
        tv2 = (TextView)findViewById(R.id.tv2);
    }

    public void setData(Fruit2 one){
        tv.setText(one.name);
        image1.setImageResource(one.image);
    }
}
