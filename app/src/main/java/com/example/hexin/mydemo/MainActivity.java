package com.example.hexin.mydemo;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Menu menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            //这里调用本类中的addMenu方法实现,  需求请看activity2
            public void onClick(View view) {
                addMenu("title", new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("click");
                    }
                });
            }
        });

        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            //这里调用本类中的addMenu方法实现,  需求请看activity2(已实现)
            public void onClick(View view) {
                setTitleBackground(Color.parseColor("#ff0000"));
            }
        });

        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MainActivity2.class));
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

