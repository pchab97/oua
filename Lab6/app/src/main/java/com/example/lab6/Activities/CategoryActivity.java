package com.example.lab6.Activities;

import android.app.ActionBar;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lab6.DAO.Computer;
import com.example.lab6.OnlineMenuDatabaseHelper;

public class CategoryActivity extends ListActivity {

    private String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        category = getIntent().getStringExtra("category");

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        setAdapter();

    }

    private void setAdapter() {

        ListView list = getListView();

        switch (category) {
            case "COMPUTER":
                ArrayAdapter<Computer> listAdapter_Computer = new ArrayAdapter<Computer>(this, android.R.layout.simple_list_item_1, getNamesFromDB("COMPUTER"));
                list.setAdapter(listAdapter_Computer);
                break;
            case "TABLET":
                ArrayAdapter<Computer> listAdapter_Tablet = new ArrayAdapter<Computer>(this, android.R.layout.simple_list_item_1, getNamesFromDB("TABLET"));
                list.setAdapter(listAdapter_Tablet);
                break;
            case "PHONE":
                ArrayAdapter<Computer> listAdapter_Phone = new ArrayAdapter<Computer>(this, android.R.layout.simple_list_item_1, getNamesFromDB("PHONE"));
                list.setAdapter(listAdapter_Phone);
                break;
        }
    }

    @Override
    protected void onListItemClick(ListView listView, View itemView, int position, long id) {
        Intent intent = new Intent(CategoryActivity.this, DetailsActivity.class);
        intent.putExtra("category", category);
        intent.putExtra("id", (int) id);
        startActivity(intent);
    }

    public Computer[] getNamesFromDB(String nameTable) {
        try {
            SQLiteOpenHelper databaseHelper = new OnlineMenuDatabaseHelper(this);
            SQLiteDatabase db = databaseHelper.getReadableDatabase();

            Cursor cursor = db.query(nameTable,
                    new String[]{"NAME"},
                    null, null,
                    null, null, null);

            Computer[] computers = new Computer[cursor.getCount()];
            cursor.moveToFirst();
            for (int i = 0; i < computers.length; i++) {
                computers[i] = new Computer(cursor.getString(0));
                cursor.moveToNext();
            }
            return computers;

        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "Baza danych jest niedostępna", Toast.LENGTH_SHORT);
            toast.show();
        }

        return new Computer[] {new Computer("")};
    }
}
