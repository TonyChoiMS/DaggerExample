package com.tony.daggerexample.ui.activity.module;

import com.tony.daggerexample.data.api.RepositoriesManager;
import com.tony.daggerexample.ui.activity.ActivityScope;
import com.tony.daggerexample.ui.activity.RepositoriesListActivity;
import com.tony.daggerexample.ui.activity.presenter.RepositoriesListActivityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017-11-09.
 */

@Module
public class RepositoriesListActivityModule {
    private RepositoriesListActivity repositoriesListActivity;

    public RepositoriesListActivityModule(RepositoriesListActivity repositoriesListActivity) {
        this.repositoriesListActivity = repositoriesListActivity;
    }

    @Provides
    @ActivityScope
    RepositoriesListActivity provideRepositoriesListActivity() {
        return repositoriesListActivity;
    }

    @Provides
    @ActivityScope
    RepositoriesListActivityPresenter provideRepositoriesListActivityPresenter(RepositoriesManager repositoriesManager) {
        return new RepositoriesListActivityPresenter(repositoriesListActivity, repositoriesManager);
    }
}
