package com.example.lab5v2;

import android.app.Activity;
import android.os.Bundle;

public class DetailActivity extends Activity {
    public static final String EXTRA_ANDROID_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        AndroidDetailFragment androidDetailFragment = (AndroidDetailFragment)
                getFragmentManager().findFragmentById(R.id.detail_frag);
        int androidId = (int) getIntent().getExtras().get(EXTRA_ANDROID_ID);
        androidDetailFragment.setWorkout(androidId);
    }
}
