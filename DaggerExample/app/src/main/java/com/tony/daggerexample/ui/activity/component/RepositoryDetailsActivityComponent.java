package com.tony.daggerexample.ui.activity.component;

import com.tony.daggerexample.AppComponent;
import com.tony.daggerexample.ui.activity.ActivityScope;
import com.tony.daggerexample.ui.activity.RepositoryDetailsActivity;
import com.tony.daggerexample.ui.activity.module.RepositoryDetailsActivityModule;
import com.tony.daggerexample.ui.activity.presenter.RepositoryDetailsActivityPresenter;

import dagger.Component;

/**
 * Created by Administrator on 2017-11-09.
 */

@ActivityScope
@Component(
        modules = RepositoryDetailsActivityModule.class,
        dependencies = AppComponent.class
)
public interface RepositoryDetailsActivityComponent {

    RepositoryDetailsActivity inject(RepositoryDetailsActivity repositoryDetailsActivity);

    RepositoryDetailsActivityPresenter presenter();
}
