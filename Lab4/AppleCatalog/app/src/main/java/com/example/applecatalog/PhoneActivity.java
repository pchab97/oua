package com.example.applecatalog;

import android.app.ActionBar;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PhoneActivity extends ListActivity {

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(PhoneActivity.this, PhoneeActivity.class);
        intent.putExtra(PhoneeActivity.EXTRA_PHONE0, (int) id);
        startActivity(intent) ;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        ListView listView = getListView();
        ArrayAdapter<Phone> listAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Phone.phone);
        listView.setAdapter(listAdapter);

    }
}
