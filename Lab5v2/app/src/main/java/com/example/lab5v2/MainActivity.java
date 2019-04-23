package com.example.lab5v2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.app.FragmentTransaction;
import android.view.View;

public class MainActivity extends Activity implements AndroidListFragment.AndroidListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public void itemClicked(long id) {
        View fragmentContainer = findViewById(R.id.fragment_container);
        if (fragmentContainer != null) {
            AndroidDetailFragment details = new AndroidDetailFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            details.setWorkout(id);
            ft.replace(R.id.fragment_container, details);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        } else {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_ANDROID_ID, (int)id);
            startActivity(intent);
        }
    }
}
