package com.example.mylibrary;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by hexin on 16/6/2.
 */
public class Utils {
    /**
     * 添加右上角菜单
     *
     * @param
     * @param
     */
    public void addMenu() {


    }


    /**
     * 设置标题栏颜色
     *
     * @param
     */
    public void setTitleBackground(Context context) {
        AppCompatActivity aContext = null;
        if(context instanceof AppCompatActivity){
             aContext = (AppCompatActivity)context;
            if (aContext.getSupportActionBar() != null) {
                aContext.getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ff0000")));
            }
        }


    }
}
