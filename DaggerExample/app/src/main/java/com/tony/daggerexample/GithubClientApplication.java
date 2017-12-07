package com.tony.daggerexample;

import android.app.Application;
import android.content.Context;

import com.tony.daggerexample.data.api.GithubApiModule;

import timber.log.Timber;

/**
 * Created by Administrator on 2017-11-08.
 */

public class GithubClientApplication extends Application {

    private AppComponent appComponent;

    public static GithubClientApplication get(Context context) {
        return (GithubClientApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .githubApiModule(new GithubApiModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
