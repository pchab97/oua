package com.example.app2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;

import java.net.URI;
import java.net.URISyntaxException;

public class Third extends AppCompatActivity {

    Button buttonFirst;
    Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        buttonFirst = (Button) findViewById(R.id.button5);
        buttonBack = (Button) findViewById(R.id.button6);

        buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFirst = new Intent(Third.this,MainActivity.class);
                startActivity(intentFirst);
            }
        });
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFirst = new Intent(Third.this,Second.class);
                startActivity(intentFirst);
            }
        });
    }
}
