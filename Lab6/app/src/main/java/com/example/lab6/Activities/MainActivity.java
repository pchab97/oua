package com.example.lab6.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.lab6.R;


public class MainActivity extends ToolbarCreator {

    private AdapterView.OnItemClickListener itemClickListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setIdMenu(R.menu.main_menu);
        setThisActivity(MainActivity.this);

        createAdapter(MainActivity.this, CategoryActivity.class);

        ListView listView = findViewById(R.id.listView_main);
        listView.setOnItemClickListener(itemClickListener);

    }

    private void createAdapter(final Context thisActivity, final Class nextActivity) {
        itemClickListener = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> listView, View itemView, int position, long id) {

                switch (position) {
                    case 0:
                        Intent intentComputer = new Intent(thisActivity, nextActivity);
                        intentComputer.putExtra("category", "COMPUTER");
                        startActivity(intentComputer);
                        break;
                    case 1:
                        Intent intentTablet = new Intent(thisActivity, nextActivity);
                        intentTablet.putExtra("category", "TABLET");
                        startActivity(intentTablet);
                        break;
                    case 2:
                        Intent intentPhone = new Intent(thisActivity, nextActivity);
                        intentPhone.putExtra("category", "PHONE");
                        startActivity(intentPhone);
                        break;
                }
            }
        };
    }



}
