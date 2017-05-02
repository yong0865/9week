package com.example.yo.a9weekex;

import android.content.Context;
import android.icu.text.StringPrepParseException;
import android.media.Image;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by yo on 2017-04-27.
 */

public class AddFruit extends LinearLayout implements View.OnClickListener{
    int imageno = 0;
    AutoCompleteTextView et;
    ImageView img;
    Button b_next , b_add, b_change;

    public AddFruit(Context context, AttributeSet attrs){
        super(context, attrs);
        init(context);
    }

    public void init(Context context){
        LayoutInflater.from(context).inflate(R.layout.fruitadd,this);
        et = (AutoCompleteTextView) findViewById(R.id.f_name);
        img = (ImageView)findViewById(R.id.image1);
        b_add = (Button)findViewById(R.id.b_add);
        b_next = (Button)findViewById(R.id.b_next);
        b_change =(Button)findViewById(R.id.b_change);
        b_next.setOnClickListener(this);
        b_add.setOnClickListener(this);
        b_change.setOnClickListener(this);
        String[] f = Fruit2.fruitlist;
        et.setAdapter(new ArrayAdapter<String>(context, android.R.layout.simple_dropdown_item_1line, f));

    }

    interface OnAddListner{
        void onAdd(String name, String price ,int image);
    }
    public OnAddListner onAddListner;

    public void setOnAddListner(OnAddListner onAddListner){
        this.onAddListner = onAddListner;
    }

    interface OnChangeListner{
        void onChange(String name, String price, int image);
    }
    public OnChangeListner onChangeListner;

    public void setOnChangeListner(OnChangeListner onChangeListner) { this.onChangeListner = onChangeListner;}

    public void setAddData(Fruit2 one){
        et.setText(one.name);
        img.setImageResource(one.image);
        b_add.setVisibility(GONE);
        b_change.setVisibility(VISIBLE);
    }

    @Override
    public void onClick(View v) {
        if(v == b_add){
            onAddListner.onAdd(et.getText().toString(), Fruit2.pricelist[imageno], Fruit2.imagelist[imageno]);
        }
        if(v == b_change){
            onChangeListner.onChange(et.getText().toString(), Fruit2.pricelist[imageno], Fruit2.imagelist[imageno]);
            b_add.setVisibility(VISIBLE);
            b_change.setVisibility(GONE);
        }
        else{
            if(imageno == Fruit2.imagelist.length-1) {
                imageno = 0;
                img.setImageResource(Fruit2.imagelist[imageno]);
            }
            else{
                imageno++;
                img.setImageResource(Fruit2.imagelist[imageno]);
            }
        }
    }
}
