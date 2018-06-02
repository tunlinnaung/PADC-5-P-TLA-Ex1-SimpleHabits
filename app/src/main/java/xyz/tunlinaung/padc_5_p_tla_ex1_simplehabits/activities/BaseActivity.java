package xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.ss.bottomnavigation.BottomNavigation;
import com.ss.bottomnavigation.events.OnSelectedItemChangeListener;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import xyz.tunlinaung.padc_5_p_tla_ex1_simplehabits.R;

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

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
