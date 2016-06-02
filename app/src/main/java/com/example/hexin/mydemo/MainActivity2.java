package com.example.hexin.mydemo;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.mylibrary.Utils;

public class MainActivity2 extends AppCompatActivity {

    private Menu menu;
    Utils util = new Utils();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //这里调用mylibrary.utils.addmenu 实现效果
               util.addMenu();
            }
        });

        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //这里调用mylibrary.utils.settitltbackgroud 实现效果
                util.setTitleBackground(MainActivity2.this);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * 添加右上角菜单
     *
     * @param title
     * @param r
     */
    public void addMenu(String title, final Runnable r) {
        if (menu != null) {
            menu.clear();
            MenuItem item = menu.add(Menu.NONE, 0, Menu.NONE, title).setIcon(R.mipmap.ic_launcher);
            item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    r.run();
                    return true;
                }
            });
            MenuItemCompat.setShowAsAction(item, MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
        }
    }


    /**
     * 设置标题栏颜色
     *
     * @param color
     */
    public void setTitleBackground(int color) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(color));
        }
    }
}

