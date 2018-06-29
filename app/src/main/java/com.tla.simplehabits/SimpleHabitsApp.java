package com.tla.simplehabits;

import android.app.Application;

import com.tla.simplehabits.data.models.SimpleHabitsModel;

/**
 * Created by eidoshack on 5/17/18.
 */

public class SimpleHabitsApp extends Application {
    public static final String LOG_TAG = "SimpleHabitsApp";

    @Override
    public void onCreate() {
        super.onCreate();
        SimpleHabitsModel.initAppModel(getApplicationContext());
    }
}
