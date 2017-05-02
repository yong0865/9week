package com.example.yo.a9weekex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    ArrayList<Fruit2> fruit = new ArrayList<Fruit2>();

    GridView gridView;
    GridAdapter adapter;
    AddFruit addFruit;
    CheckBox checkbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        checkbox = (CheckBox)findViewById(R.id.checkbox);
        gridView = (GridView)findViewById(R.id.gridView);

        adapter = new GridAdapter(this, fruit);
        gridView.setAdapter(adapter);

        addFruit = (AddFruit)findViewById(R.id.add);
        addFruit.setOnAddListner(new AddFruit.OnAddListner() {
            @Override
            public void onAdd(String name, String price,int image) {
                adapter.addFruit(new Fruit2(name, price, image));
                adapter.notifyDataSetChanged();
            }
        });

//        addFruit.setOnChangeListner(new AddFruit.OnChangeListner() {
//            @Override
//            public void onChange(String name, String price, int image) {
//                adapter.setFruit(int position , new Fruit2(name, price, image));
//            }
//        });
        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(checkbox.isChecked()) {
                    adapter.showprice(true);
                }
                else{
                    adapter.showprice(false);
                }
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                addFruit.setAddData(new Fruit2(adapter.getName(position),adapter.getImage(position)));

                addFruit.setOnChangeListner(new AddFruit.OnChangeListner() {
                    @Override
                    public void onChange(String name, String price, int image) {
                        adapter.setFruit(position , new Fruit2(name, price, image));
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }
}
