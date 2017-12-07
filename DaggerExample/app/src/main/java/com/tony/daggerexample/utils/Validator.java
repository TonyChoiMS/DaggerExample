package com.tony.daggerexample.utils;

import android.text.TextUtils;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Administrator on 2017-11-08.
 */

@Singleton
public class Validator {

    @Inject
    public Validator() {

    }

    public boolean validUsername(String username) {
        return !TextUtils.isEmpty(username) && username.length() > 0;
    }
}
