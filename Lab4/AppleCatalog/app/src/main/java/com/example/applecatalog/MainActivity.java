package com.example.applecatalog;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import android.support.v7.widget.Toolbar;
import android.widget.ShareActionProvider;

public class MainActivity extends Activity {

    private ListView listView;
    private Toolbar toolbar;

    private ShareActionProvider shareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.topList);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Intent intent = new Intent(MainActivity.this, PhoneActivity.class);
                    startActivity(intent);
                } else if(position == 1){
                    Intent intent2 = new Intent(MainActivity.this, ComputerCategoryActivity.class);
                    startActivity(intent2);
                } else{
                    Intent intent3 = new Intent(MainActivity.this, TabletsCategoryActivity.class);
                    startActivity(intent3);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.options:
                Intent intent = new Intent(this, InfoActivity.class);
                startActivity(intent);
                return true;
//            case R.id.action_settings:
//                // Kod wykonywany po kliknięciu elementu Settings (ustawienia)
//                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
