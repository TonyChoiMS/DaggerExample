package com.tony.daggerexample;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017-11-08.
 */

@Module
public class AppModule {

    private Application application;

    public AppModule(Application _application) {
        this.application = _application;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return application;
    }
}
