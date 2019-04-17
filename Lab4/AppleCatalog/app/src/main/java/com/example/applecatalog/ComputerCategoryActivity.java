package com.example.applecatalog;

import android.app.ActionBar;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ComputerCategoryActivity extends ListActivity {

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intentt = new Intent(ComputerCategoryActivity.this, ComputerActivity.class);
        intentt.putExtra(ComputerActivity.EXTRA_COMPUTER0, (int) id);
        startActivity(intentt) ;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_category);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        ListView listView2 = getListView();
        ArrayAdapter<Computer> listAdapter2 = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Computer.computer);
        listView2.setAdapter(listAdapter2);
    }
}
