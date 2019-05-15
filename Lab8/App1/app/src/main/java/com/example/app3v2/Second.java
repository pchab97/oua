package com.example.app3v2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Second extends AppCompatActivity {

    FrameLayout frameLayout;
    TextView textView;
    ImageView imageView;
    Button buttonQ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        frameLayout = findViewById(R.id.second);
        textView = findViewById(R.id.textList);
        imageView = findViewById(R.id.imageView);
        buttonQ = findViewById(R.id.button2);

        final Boolean night = getIntent().getExtras().getBoolean("night");
        final String selectedItem = getIntent().getExtras().getString("list");

        if(night){
            frameLayout.setBackgroundColor(Color.GRAY);
            buttonQ.setBackgroundColor(Color.DKGRAY);
        } else{

        }

        if(selectedItem.equals("Linear Layout (Horizontal)")){
            textView.setText(R.string.variant1);
            imageView.setImageResource(Integer.parseInt(String.valueOf(R.drawable.llhorizontal)));
        } else if(selectedItem.equals("Linear Layout (Vertical)")){
            textView.setText(R.string.variant2);
            imageView.setImageResource(Integer.parseInt(String.valueOf(R.drawable.llvertical)));

        } else if(selectedItem.equals("Relative layout")){
            textView.setText(R.string.variant3);
            imageView.setImageResource(Integer.parseInt(String.valueOf(R.drawable.relativelayout)));
        } else{
            textView.setText(R.string.variant4);
            imageView.setImageResource(Integer.parseInt(String.valueOf(R.drawable.framelayout)));
        }
        buttonQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Second.this, Quiz.class);
                intent2.putExtra("nightMode", night);
                intent2.putExtra("selectedItem", selectedItem);
                //Toast.makeText(getApplicationContext(),night.toString(),Toast.LENGTH_SHORT).show();

                startActivity(intent2);
            }
        });

    }
}
