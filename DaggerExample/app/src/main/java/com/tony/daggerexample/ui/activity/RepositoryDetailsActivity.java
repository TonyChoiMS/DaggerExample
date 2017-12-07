package com.tony.daggerexample.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.tony.daggerexample.AppComponent;
import com.tony.daggerexample.R;
import com.tony.daggerexample.data.model.Repository;
import com.tony.daggerexample.ui.activity.component.DaggerRepositoryDetailsActivityComponent;
import com.tony.daggerexample.ui.activity.module.RepositoryDetailsActivityModule;
import com.tony.daggerexample.ui.activity.presenter.RepositoryDetailsActivityPresenter;
import com.tony.daggerexample.utils.AnalyticsManager;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017-11-09.
 */

public class RepositoryDetailsActivity extends BaseActivity {

    private static final String ARG_REPOSITORY = "arg_repository";

    @BindView(R.id.tvRepoName)
    TextView tvRepoName;
    @BindView(R.id.tvRepoDetails)
    TextView tvRepoDetails;

    @Inject
    RepositoryDetailsActivityPresenter presenter;
    @Inject
    AnalyticsManager analyticsManager;

    private Repository repository;


    public static void startWithRepository(Repository repository, Activity startingActivity) {
        Intent intent = new Intent(startingActivity, RepositoryDetailsActivity.class);
        intent.putExtra(ARG_REPOSITORY, repository);
        startingActivity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository_details);
        ButterKnife.bind(this);
        analyticsManager.logScreenView(getClass().getName());

        repository = getIntent().getParcelableExtra(ARG_REPOSITORY);
        tvRepoName.setText(repository.name);
        tvRepoDetails.setText(repository.url);
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerRepositoryDetailsActivityComponent.builder()
                .appComponent(appComponent)
                .repositoryDetailsActivityModule(new RepositoryDetailsActivityModule(this))
                .build()
                .inject(this);
    }
}
