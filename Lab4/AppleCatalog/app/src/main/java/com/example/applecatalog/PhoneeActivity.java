package com.example.applecatalog;

import android.app.ActionBar;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PhoneeActivity extends Activity {

    public static final String EXTRA_PHONE0 = "phoneNo";

    private ImageView imageView;
    private TextView textView;
    private TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phonee);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        imageView = findViewById(R.id.photo);
        textView = findViewById(R.id.name);
        textView2 = findViewById(R.id.description);

        int phoneNo = (Integer)getIntent().getExtras().get(EXTRA_PHONE0);
        Phone phone = Phone.phone[phoneNo];

        imageView.setImageResource(phone.getImageID());
        imageView.setContentDescription(phone.getModel());

        textView.setText(phone.getModel());
        textView2.setText(phone.getMemory() + System.lineSeparator() + phone.getColor());


    }
}
