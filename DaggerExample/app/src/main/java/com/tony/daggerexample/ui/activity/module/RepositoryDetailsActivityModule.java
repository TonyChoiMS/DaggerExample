package com.tony.daggerexample.ui.activity.module;

import com.tony.daggerexample.ui.activity.ActivityScope;
import com.tony.daggerexample.ui.activity.RepositoryDetailsActivity;
import com.tony.daggerexample.ui.activity.presenter.RepositoryDetailsActivityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017-11-09.
 */

@Module
public class RepositoryDetailsActivityModule {

    RepositoryDetailsActivity repositoryDetailsActivity;

    public RepositoryDetailsActivityModule(RepositoryDetailsActivity repositoryDetailsActivity) {
        this.repositoryDetailsActivity = repositoryDetailsActivity;
    }

    @Provides
    @ActivityScope
    RepositoryDetailsActivity proviedRepositoryDetailsActivity() {
        return repositoryDetailsActivity;
    }

    @Provides
    @ActivityScope
    RepositoryDetailsActivityPresenter provideRepositoryDetailsActivityPresenter() {
        return new RepositoryDetailsActivityPresenter(repositoryDetailsActivity);
    }

}
