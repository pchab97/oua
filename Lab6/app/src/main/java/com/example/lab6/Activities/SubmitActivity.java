package com.example.lab6.Activities;

import android.app.ActionBar;
import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lab6.AsyncTask.MyAsyncTask;
import com.example.lab6.R;


public class SubmitActivity extends ToolbarCreator {

    private TextView textViewName;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        setIdMenu(R.menu.main_menu);
        setThisActivity(SubmitActivity.this);

        textViewName = findViewById(R.id.textView_Submit);
        editText = findViewById(R.id.editText);

        textViewName.setText(getComputerName());
    }

    public void sendResult(View view) {

        new MyAsyncTask(getComputerName(), editText.getText().toString(), this).execute();
    }

    private ContentValues createItem(String name, String amount) {

        ContentValues newItem = new ContentValues();

        newItem.put("NAME", name);
        newItem.put("AMOUNT", amount);

        return newItem;
    }

}
