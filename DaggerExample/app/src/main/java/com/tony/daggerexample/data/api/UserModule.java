package com.tony.daggerexample.data.api;

import com.tony.daggerexample.data.UserScope;
import com.tony.daggerexample.data.model.User;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017-11-08.
 */

@Module
public class UserModule {

    private User user;

    public UserModule(User user) {
        this.user = user;
    }

    @Provides
    @UserScope
    User provideUser() {
        return user;
    }

    @Provides
    @UserScope
    RepositoriesManager proviedRepositoriesManager(User user, GithubApiService githubApiService) {
        return new RepositoriesManager(user, githubApiService);
    }
}
