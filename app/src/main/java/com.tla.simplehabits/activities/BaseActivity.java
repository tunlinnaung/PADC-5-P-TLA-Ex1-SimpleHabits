package com.tla.simplehabits.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.tla.simplehabits.R;

/**
 * Created by eidoshack on 5/23/18.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected void initBottomNavigation() {
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.tab_home:
                                Intent mainIntent = MainActivity.newIntent(getApplicationContext());
                                startActivity(mainIntent);
                            case R.id.tab_me:
                                Intent meIntent = MeActivity.newIntent(getApplicationContext());
                                startActivity(meIntent);

                            case R.id.tab_more:

                        }
                        return true;
                    }
                });
    }
}