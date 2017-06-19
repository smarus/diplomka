package com.diplomka.android.diplomka;

import android.app.Application;

import io.vov.vitamio.Vitamio;

/**
 * Created by ruslan on 6/16/17.
 */

public class CinemaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Vitamio.initialize(getApplicationContext());
    }
}
