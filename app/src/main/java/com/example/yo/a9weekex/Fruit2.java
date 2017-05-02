package com.example.yo.a9weekex;

/**
 * Created by yo on 2017-04-27.
 */

public class Fruit2 {
    final static int[] imagelist= {R.drawable.abocado, R.drawable.banana, R.drawable.cherry, R.drawable.grape, R.drawable.cranberry, R.drawable.kiwi,R.drawable.orange,R.drawable.watermelon};
    final static String[] pricelist = {"100","200","300","400","500","600","700","800"};
    final static String[] fruitlist = {"abocado","banana","cherry","grape","cranberry","kiwi","orange","watermelon"};
    String name;
    String price;
    int image;

    public Fruit2(String name, String price, int image){
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public Fruit2(String name, int image){
        this.name = name;
        this.image = image;
    }
    public String getName(){return name;}
    public int getImage() {return  image;}

}
