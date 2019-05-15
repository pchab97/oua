package com.example.catalogandroid;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class AndroidDetailFragment extends Fragment {
    private long androidId;

    public AndroidDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            androidId = savedInstanceState.getLong("courseId");
        } else {
            FragmentTransaction ft = getChildFragmentManager().beginTransaction();
            StopWatchFragment stopwatchFragment = new StopWatchFragment();
            ft.replace(R.id.stopwatch_container, stopwatchFragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }
        return inflater.inflate(R.layout.activity_fragment_android_detail, container, false);
    }

    @Override
    public void onStart () {
        super.onStart();
        View view = getView();
        if (view != null) {
            TextView title = (TextView) view.findViewById(R.id.textTitle);
            Android android = Android.androids[(int) androidId];
            title.setText(android.getName());
            TextView description = (TextView) view.findViewById(R.id.textDescription);
            description.setText(android.getDescription());
        }
    }

    @Override
    public void onSaveInstanceState (Bundle savedInstanceState){
        savedInstanceState.putLong("courseId", androidId);
    }

    public void setAndroid ( long id){
        this.androidId = id;
    }
}
