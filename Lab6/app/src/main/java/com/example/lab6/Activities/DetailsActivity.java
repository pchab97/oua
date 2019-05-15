package com.example.lab6.Activities;

import android.app.ActionBar;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lab6.DAO.Computer;
import com.example.lab6.OnlineMenuDatabaseHelper;
import com.example.lab6.R;


public class DetailsActivity extends ToolbarCreator {

    private String getCategory;
    private int getId;

    private ImageView imageView_Photo;
    private TextView textView_Name;
    private TextView textView_Description;
    private TextView textView_Price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        setIdMenu(R.menu.submit_menu);
        setThisActivity(DetailsActivity.this);

        getCategory = getIntent().getStringExtra("category");
        getId = getIntent().getIntExtra("id", 0);

        imageView_Photo = findViewById(R.id.photo);
        textView_Name = findViewById(R.id.name);
        textView_Description = findViewById(R.id.description);
        textView_Price = findViewById(R.id.price);

        Computer computer = getComputerFromDB(getCategory, getId+1);
        setContentOfProduct(computer);
    }

    private void setContentOfProduct(Computer computer) {
        imageView_Photo.setImageResource(computer.getImageResourceId());
        imageView_Photo.setContentDescription(computer.getName());
        textView_Name.setText(computer.getName());
        textView_Description.setText(computer.getDescription());
        textView_Price.setText(getString(R.string.AppCurrency) + computer.getPrice());

        setComputerName(computer.getName());
    }

    public Computer getComputerFromDB(String nameTable, int computerId) {
        try {
            SQLiteOpenHelper databaseHelper = new OnlineMenuDatabaseHelper(this);
            SQLiteDatabase db = databaseHelper.getReadableDatabase();

            Cursor cursor = db.query(nameTable,
                    new String[]{"NAME", "DESCRIPTION", "PRICE", "IMAGE_RESOURCE_ID"},
                    "_id = ?", new String[]{Integer.toString(computerId)},
                    null, null, null);

            cursor.moveToFirst();

            return new Computer(cursor.getString(0), cursor.getString(1), cursor.getFloat(2), cursor.getInt(3));

        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "Baza danych jest niedostępna", Toast.LENGTH_SHORT);
            toast.show();
        }

        return new Computer("", "", 0.0f, 0);

    }
}
