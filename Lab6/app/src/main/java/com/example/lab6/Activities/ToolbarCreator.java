package com.example.lab6.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

import com.example.lab6.R;


public abstract class ToolbarCreator extends Activity {

    private int idMenu;
    private Context thisActivity;

    private static String computerName;

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public void setThisActivity(Context thisActivity) {
        this.thisActivity = thisActivity;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(idMenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_submit:
                Intent intentOther1 = new Intent(thisActivity, SubmitActivity.class);
                startActivity(intentOther1);
                return true;

            case R.id.action_info:
                Intent intentOther2 = new Intent(thisActivity, InfoActivity.class);
                startActivity(intentOther2);
                return true;

            case R.id.action_orders:
                Intent intentOther3 = new Intent(thisActivity, OrderActivity.class);
                startActivity(intentOther3);
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }

    public static String getComputerName() {
        return computerName;
    }

    public static void setComputerName(String computerName) {
        ToolbarCreator.computerName = computerName;
    }
}
