package com.example.applecatalog;

import android.app.ActionBar;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ComputerActivity extends Activity {

    public static final String EXTRA_COMPUTER0 = "Computer0";

    private ImageView imageView;
    private TextView textView;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        imageView = findViewById(R.id.photo);
        textView = findViewById(R.id.name);
        textView2 = findViewById(R.id.description);

        int computerNo = (Integer)getIntent().getExtras().get(EXTRA_COMPUTER0);
        Computer computer = Computer.computer[computerNo];

        imageView.setImageResource(computer.getImageID());
        imageView.setContentDescription(computer.getModel());

        textView.setText(computer.getModel());
        textView2.setText(computer.getMemory() + System.lineSeparator() + computer.getProccesor());
    }
}
