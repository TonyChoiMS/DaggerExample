package com.tony.daggerexample.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.tony.daggerexample.AppComponent;
import com.tony.daggerexample.R;
import com.tony.daggerexample.data.model.User;
import com.tony.daggerexample.ui.activity.component.DaggerSplashActivityComponent;
import com.tony.daggerexample.ui.activity.module.SplashActivityModule;
import com.tony.daggerexample.ui.activity.presenter.SplashActivityPresenter;
import com.tony.daggerexample.utils.AnalyticsManager;
import com.tony.daggerexample.utils.SimpleObserver;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.android.widget.OnTextChangeEvent;
import rx.android.widget.WidgetObservable;

/**
 * Created by Administrator on 2017-11-09.
 */

public class SplashActivity extends BaseActivity {

    @BindView(R.id.etUsername)
    EditText etUsername;
    @BindView(R.id.pbLoading)
    ProgressBar pbLoading;
    @BindView(R.id.btnShowRepositories)
    Button btnShowRepositories;

    @Inject
    SplashActivityPresenter presenter;
    @Inject
    AnalyticsManager analyticsManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        analyticsManager.logScreenView(getClass().getName());

        WidgetObservable.text(etUsername, true).subscribe(new SimpleObserver<OnTextChangeEvent>() {
            @Override
            public void onNext(OnTextChangeEvent onTextChangeEvent) {
                presenter.username = onTextChangeEvent.text().toString();
                etUsername.setError(null);
            }
        });
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerSplashActivityComponent.builder()
                .appComponent(appComponent)
                .splashActivityModule(new SplashActivityModule(this))
                .build().inject(this);
    }

    @OnClick(R.id.btnShowRepositories)
    public void onShowRepositoriesClick() {
        presenter.onShowRepositoriesClick();
    }

    public void showRepositoriesForUser(User user) {
        RepositoriesListActivity.startWithUsername(user, this);
    }

    public void showValidationError() {
        etUsername.setError("Validation error");
    }

    public void showLoading(boolean loading) {
        btnShowRepositories.setVisibility(loading ? View.GONE : View.VISIBLE);
        pbLoading.setVisibility(loading ? View.VISIBLE : View.GONE);
    }
}
