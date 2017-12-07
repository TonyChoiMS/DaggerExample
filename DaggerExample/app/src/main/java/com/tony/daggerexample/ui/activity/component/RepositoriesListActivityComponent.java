package com.tony.daggerexample.ui.activity.component;

import com.tony.daggerexample.data.api.UserComponent;
import com.tony.daggerexample.ui.activity.ActivityScope;
import com.tony.daggerexample.ui.activity.RepositoriesListActivity;
import com.tony.daggerexample.ui.activity.module.RepositoriesListActivityModule;
import com.tony.daggerexample.ui.activity.presenter.RepositoriesListActivityPresenter;

import dagger.Component;

/**
 * Created by Administrator on 2017-11-09.
 */

@ActivityScope
@Component(
        modules = RepositoriesListActivityModule.class,
        dependencies = UserComponent.class
)
public interface RepositoriesListActivityComponent {
    RepositoriesListActivity inject(RepositoriesListActivity repositoriesListActivity);

    RepositoriesListActivityPresenter presenter();
}
