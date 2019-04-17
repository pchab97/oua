package com.example.applecatalog;

import android.app.ActionBar;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class TabletsActivity extends Activity {

    public static final String EXTRA_TABLETS0 = "Tablets0";

    private ImageView imageView;
    private TextView textView;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablets);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        imageView = findViewById(R.id.photo);
        textView = findViewById(R.id.name);
        textView2 = findViewById(R.id.description);

        int tabletsNo = (Integer)getIntent().getExtras().get(EXTRA_TABLETS0);
        Tablets tablets = Tablets.tablets[tabletsNo];

        imageView.setImageResource(tablets.getImageID());
        imageView.setContentDescription(tablets.getModel());

        textView.setText(tablets.getModel());
        textView2.setText(tablets.getMemory() + System.lineSeparator() + tablets.getSize());
    }
}
