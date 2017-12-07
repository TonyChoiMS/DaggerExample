package com.tony.daggerexample.ui.activity.presenter;

import com.google.common.collect.ImmutableList;
import com.tony.daggerexample.data.api.RepositoriesManager;
import com.tony.daggerexample.data.model.Repository;
import com.tony.daggerexample.ui.activity.RepositoriesListActivity;
import com.tony.daggerexample.utils.SimpleObserver;

/**
 * Created by Administrator on 2017-11-09.
 */


public class RepositoriesListActivityPresenter {

    private RepositoriesListActivity repositoriesListActivity;
    private RepositoriesManager repositoriesManager;

    public RepositoriesListActivityPresenter(RepositoriesListActivity repositoriesListActivity, RepositoriesManager repositoriesManager) {
        this.repositoriesListActivity = repositoriesListActivity;
        this.repositoriesManager = repositoriesManager;
    }

    public void loadRepositories() {
        repositoriesListActivity.showLoading(true);
        repositoriesManager.getUserRepositories().subscribe(new SimpleObserver<ImmutableList<Repository>>() {
            @Override
            public void onError(Throwable e) {
//                super.onError(e);
                repositoriesListActivity.showLoading(false);
            }

            @Override
            public void onNext(ImmutableList<Repository> repositories) {
                repositoriesListActivity.showLoading(false);
                repositoriesListActivity.setRepositories(repositories);
            }
        });
    }


}
