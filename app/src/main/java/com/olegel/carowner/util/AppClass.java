package com.olegel.carowner.util;

import android.app.Application;

import com.olegel.carowner.db.HelperFactory;

/**
 * Created by Oleg on 27.08.2017.
 */

public class AppClass extends Application {
    @Override
    public void onCreate() {
        HelperFactory.setHelper(getApplicationContext());
        super.onCreate();
    }
}
