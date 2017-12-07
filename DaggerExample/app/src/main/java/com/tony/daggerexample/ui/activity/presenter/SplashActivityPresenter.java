package com.tony.daggerexample.ui.activity.presenter;

import com.tony.daggerexample.data.api.UserManager;
import com.tony.daggerexample.data.model.User;
import com.tony.daggerexample.ui.activity.SplashActivity;
import com.tony.daggerexample.utils.SimpleObserver;
import com.tony.daggerexample.utils.Validator;

/**
 * Created by Administrator on 2017-11-09.
 */

public class SplashActivityPresenter {

    public String username;

    SplashActivity splashActivity;
    Validator validator;
    UserManager userManager;

    public SplashActivityPresenter(SplashActivity splashActivity, Validator validator, UserManager userManager) {
        this.splashActivity = splashActivity;
        this.validator = validator;
        this.userManager = userManager;
    }

    public void onShowRepositoriesClick() {
        if (validator.validUsername(username)) {
            splashActivity.showLoading(true);
            userManager.getUser(username).subscribe(new SimpleObserver<User>() {
                @Override
                public void onError(Throwable e) {
                    splashActivity.showLoading(false);
                    splashActivity.showValidationError();
                }

                @Override
                public void onNext(User user) {
                    splashActivity.showLoading(false);
                    splashActivity.showRepositoriesForUser(user);
                }
            });
        } else {
            splashActivity.showValidationError();
        }
    }
}
