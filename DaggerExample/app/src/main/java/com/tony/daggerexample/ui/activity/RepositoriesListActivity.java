package com.tony.daggerexample.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.google.common.collect.ImmutableList;
import com.tony.daggerexample.AppComponent;
import com.tony.daggerexample.R;
import com.tony.daggerexample.data.api.UserModule;
import com.tony.daggerexample.data.model.Repository;
import com.tony.daggerexample.data.model.User;
import com.tony.daggerexample.ui.activity.component.DaggerRepositoriesListActivityComponent;
import com.tony.daggerexample.ui.activity.module.RepositoriesListActivityModule;
import com.tony.daggerexample.ui.activity.presenter.RepositoriesListActivityPresenter;
import com.tony.daggerexample.ui.adapter.RepositoriesListAdapter;
import com.tony.daggerexample.utils.AnalyticsManager;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

/**
 * Created by Administrator on 2017-11-09.
 */

public class RepositoriesListActivity extends BaseActivity {

    private static final String ARG_USER = "arg_user";

    @BindView(R.id.lvRepositories)
    ListView lvRepositories;
    @BindView(R.id.pbLoading)
    ProgressBar pbLoading;

    @Inject
    RepositoriesListActivityPresenter presenter;
    @Inject
    AnalyticsManager analyticsManager;

    private User user;
    private RepositoriesListAdapter repositoriesListAdapter;

    public static void startWithUsername(User user, Activity startingActivity) {
        Intent intent = new Intent(startingActivity, RepositoriesListActivity.class);
        intent.putExtra(ARG_USER, user);
        startingActivity.startActivity(intent);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repositories_list);
        ButterKnife.bind(this);
        presenter.loadRepositories();

        analyticsManager.logScreenView(getClass().getName());
        repositoriesListAdapter = new RepositoriesListAdapter(this, new ArrayList<Repository>());
        lvRepositories.setAdapter(repositoriesListAdapter);
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        user = getIntent().getParcelableExtra(ARG_USER);

        DaggerRepositoriesListActivityComponent.builder()
                .userComponent(appComponent.plus(new UserModule(user)))
                .repositoriesListActivityModule(new RepositoriesListActivityModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(ARG_USER, user);
    }

    public void showLoading(boolean loading) {
        lvRepositories.setVisibility(loading ? View.GONE : View.VISIBLE);
        pbLoading.setVisibility(loading ? View.VISIBLE : View.GONE);
    }

    public void setRepositories(ImmutableList<Repository> repositories) {
        repositoriesListAdapter.clear();
        repositoriesListAdapter.addAll(repositories);
    }

    @OnItemClick(R.id.lvRepositories)
    public void onRepositoryClick(int position) {
        Repository repository = repositoriesListAdapter.getItem(position);
        RepositoryDetailsActivity.startWithRepository(repository, this);
    }
}
