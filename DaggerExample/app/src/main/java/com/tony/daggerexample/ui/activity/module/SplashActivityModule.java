package com.tony.daggerexample.ui.activity.module;

import com.tony.daggerexample.data.api.UserManager;
import com.tony.daggerexample.ui.activity.ActivityScope;
import com.tony.daggerexample.ui.activity.SplashActivity;
import com.tony.daggerexample.ui.activity.presenter.SplashActivityPresenter;
import com.tony.daggerexample.utils.Validator;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017-11-09.
 */

@Module
public class SplashActivityModule {

    SplashActivity splashActivity;

    public SplashActivityModule(SplashActivity splashActivity) {
        this.splashActivity = splashActivity;
    }

    @Provides
    @ActivityScope
    SplashActivity provideSplashActivity() {
        return splashActivity;
    }

    @Provides
    @ActivityScope
    SplashActivityPresenter provideSplashActivityPresenter(Validator validator, UserManager userManager) {
        return new SplashActivityPresenter(splashActivity, validator, userManager);
    }
}
