package com.example.app2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Second extends AppCompatActivity {

    Button buttonNext;
    Button buttonBack;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String mess = getIntent().getStringExtra("tekst");
        String mess2 = getIntent().getStringExtra("tekst2");
        String mess3 = mess+" "+mess2;

        buttonNext = (Button) findViewById(R.id.button3);
        buttonBack = (Button) findViewById(R.id.button2);
        textView = (TextView) findViewById(R.id.textView2);

        //Toast.makeText(this,mess,Toast.LENGTH_SHORT).show();
        textView.setText(mess3);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBack = new Intent(Second.this, MainActivity.class);
                startActivity(intentBack);
            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNext = new Intent(Second.this, Third.class);
                startActivity(intentNext);
            }
        });

    }
}
