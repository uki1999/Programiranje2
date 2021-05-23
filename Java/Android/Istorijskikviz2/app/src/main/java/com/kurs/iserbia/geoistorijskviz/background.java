package com.kurs.iserbia.geoistorijskviz;

import com.kurs.iserbia.istorijskikviz.R;

/**
 * Created by Uroš on 24-May-17.
 */

public class background {
    Integer colors [] ={
            R.color.amber,
            R.color.blue,
            R.color.blue_grey,
            R.color.brown,
            R.color.cyan,
            R.color.deep_orange,
            R.color.deep_purple,
            R.color.green,
            R.color.grey,
            R.color.indigo,
            R.color.light_blue,
            R.color.light_green,
            R.color.yellow,
            R.color.red,
            R.color.purple,
            R.color.teal,
            R.color.lime,
            R.color.pink,
            R.color.amber,
            R.color.blue,
            R.color.blue_grey,
            R.color.brown,
            R.color.cyan,
            R.color.deep_orange,
            R.color.deep_purple,
            R.color.green,
            R.color.grey,
            R.color.indigo,
            R.color.light_blue,
            R.color.light_green,
            R.color.yellow,
            R.color.red,
            R.color.purple,
            R.color.teal,
            R.color.lime,
            R.color.pink,
            R.color.amber,
            R.color.blue,
            R.color.blue_grey,
            R.color.brown,
            R.color.cyan,
            R.color.deep_orange,
            R.color.deep_purple,
            R.color.green,
            R.color.grey,
            R.color.indigo,
            R.color.light_blue,
            R.color.light_green,
            R.color.yellow,
            R.color.red,
            R.color.purple,
            R.color.teal,
            R.color.lime,
            R.color.pink,
            R.color.amber,
            R.color.blue,
            R.color.blue_grey,
            R.color.brown,
            R.color.cyan,
            R.color.deep_orange,
            R.color.deep_purple,
            R.color.green,
            R.color.grey,
            R.color.indigo,
            R.color.light_blue
    };
    int i = - 1;

    public int getBackground(){
     i++;
             try{
                 return colors[i];
             }catch (Exception e){
                 i = 0;
                 return colors[i];
             }
        }
}
