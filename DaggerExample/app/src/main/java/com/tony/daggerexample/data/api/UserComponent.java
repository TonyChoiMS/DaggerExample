package com.tony.daggerexample.data.api;

import com.tony.daggerexample.data.UserScope;
import com.tony.daggerexample.utils.AnalyticsManager;
import com.tony.daggerexample.utils.Validator;

import dagger.Subcomponent;

/**
 * Created by Administrator on 2017-11-08.
 */
@UserScope
@Subcomponent(
        modules = {
                UserModule.class
        }
)
public interface UserComponent {
    RepositoriesManager getRepositoriesManager();

    AnalyticsManager getAnalyticsManager();

    Validator getValidator();
}
