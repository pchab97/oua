package com.example.app3v2;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Quiz extends AppCompatActivity {

    ConstraintLayout constraintLayout;
    ImageButton imageButton;
    RadioGroup radioGroup;
    Button applyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        constraintLayout = findViewById(R.id.quizLayout);
        imageButton = findViewById(R.id.imageButton);
        radioGroup = findViewById(R.id.myRadioGroup);
        final Boolean night = getIntent().getExtras().getBoolean("nightMode");

        imageButton.setImageResource(R.drawable.answer);

        //Toast.makeText(getApplicationContext(),night.toString(),Toast.LENGTH_SHORT).show();
        if(night){
            constraintLayout.setBackgroundColor(Color.GRAY);
            //.setBackgroundColor(Color.DKGRAY);

        } else{

        }
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = radioGroup.getCheckedRadioButtonId();
                if(id == R.id.odp1){
                    Toast.makeText(getApplicationContext(),"Błędna odpowiedz", Toast.LENGTH_SHORT).show();
                } else if(id == R.id.odp2){
                    Toast.makeText(getApplicationContext(),"Błędna odpowiedz", Toast.LENGTH_SHORT).show();
                } else if(id == R.id.odp3){
                    Toast.makeText(getApplicationContext(),"Poprawna odpowiedz", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(getApplicationContext(),"Błędna odpowiedz", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
