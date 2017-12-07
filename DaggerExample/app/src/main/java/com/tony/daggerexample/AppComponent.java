package com.tony.daggerexample;

import android.app.Application;

import com.tony.daggerexample.data.api.GithubApiModule;
import com.tony.daggerexample.data.api.UserComponent;
import com.tony.daggerexample.data.api.UserManager;
import com.tony.daggerexample.data.api.UserModule;
import com.tony.daggerexample.utils.AnalyticsManager;
import com.tony.daggerexample.utils.Validator;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2017-11-08.
 */


@Singleton
@Component(
        modules = {
                AppModule.class,
                GithubApiModule.class
        }
)
public interface AppComponent {

    Application getApplication();

    AnalyticsManager getAnalyticsManager();

    Validator getValidator();

    UserManager getUserManager();

    //Here we're constructing subgraph of AppComponent graph

    UserComponent plus(UserModule userModule);
}
