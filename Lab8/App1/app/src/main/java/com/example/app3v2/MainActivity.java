package com.example.app3v2;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout constraintLayout;
    Switch aSwitch;
    Boolean nightMode=false;
    Button next;
    Spinner spinner;

    public static final int NOTIFICATION_ID = 5453;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aSwitch = findViewById(R.id.switch1);
        constraintLayout = findViewById(R.id.mainView);
        next = findViewById(R.id.button);
        spinner = findViewById(R.id.spinner);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(getApplicationContext(),"NightMode ON",Toast.LENGTH_SHORT).show();
                    constraintLayout.setBackgroundColor(Color.GRAY);
                    next.setBackgroundColor(Color.DKGRAY);
                    nightMode = true;
                    showText("NightMode ON");
                } else {
                    Toast.makeText(getApplicationContext(),"NightMode OFF",Toast.LENGTH_SHORT).show();
                    constraintLayout.setBackgroundColor(Color.WHITE);
                    next.setBackgroundColor(Color.LTGRAY);
                    nightMode = false;
                    showText("NightMode OFF");
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Second.class);
                String list = spinner.getSelectedItem().toString();
                intent.putExtra("night",nightMode);
                intent.putExtra("list",list);
                startActivity(intent);
            }
        });


    }
    private void showText(String text) {

        Intent intent = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent =
                stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        Notification notification = new Notification.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(getString(R.string.app_name))
                .setAutoCancel(true)
                .setPriority(Notification.PRIORITY_MAX)
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .setContentIntent(pendingIntent)
                .setContentText(text)
                .build();
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, notification);
    }
}
