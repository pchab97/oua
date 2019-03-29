package com.example.app1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {

    public void calculate(View view){
        Spinner numbers1 = (Spinner) findViewById(R.id.numbers1);
        Spinner numbers2 = (Spinner) findViewById(R.id.numbers2);
        Spinner operations = (Spinner) findViewById(R.id.operations);

        TextView result = (TextView) findViewById(R.id.result);

        Integer wynik = null;

        Integer number1 = parseInt(String.valueOf(numbers1.getSelectedItem()));
        Integer number2 = parseInt(String.valueOf(numbers2.getSelectedItem()));
        String operation = String.valueOf(operations.getSelectedItem());

            if(operation.equals("+")){
                wynik = number1 + number2;
            } else if (operation.equals("-")){
                wynik = number1 - number2;
            } else if(operation.equals("*")){
                wynik = number1 * number2;
            } else {
                if(number2==0)
                    wynik = null;
                else
                wynik = number1 / number2;
            }
            if(wynik==null){
                result.setText("Nie dziel przez zero");
            }
            else {
                result.setText("Wynik: " + wynik.toString());
            }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
