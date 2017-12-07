package com.tony.daggerexample.utils;

import android.app.Application;


import javax.inject.Inject;
import javax.inject.Singleton;

import timber.log.Timber;

/**
 * Created by Administrator on 2017-11-08.
 */

@Singleton
public class AnalyticsManager {

    private Application app;

    @Inject
    public AnalyticsManager(Application app) {
        this.app = app;
    }

    public void logScreenView(String screnname) {
        Timber.d("Logged screen name : " + screnname);
    }
}
