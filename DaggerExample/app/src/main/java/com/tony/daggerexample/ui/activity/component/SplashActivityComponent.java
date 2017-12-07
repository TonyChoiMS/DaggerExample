package com.tony.daggerexample.ui.activity.component;

import com.tony.daggerexample.AppComponent;
import com.tony.daggerexample.ui.activity.ActivityScope;
import com.tony.daggerexample.ui.activity.SplashActivity;
import com.tony.daggerexample.ui.activity.module.SplashActivityModule;
import com.tony.daggerexample.ui.activity.presenter.SplashActivityPresenter;

import dagger.Component;

/**
 * Created by Administrator on 2017-11-09.
 */

@ActivityScope
@Component(
        modules = SplashActivityModule.class,
        dependencies = AppComponent.class
)
public interface SplashActivityComponent {
    SplashActivity inject(SplashActivity splashActivity);

    SplashActivityPresenter presenter();
}
