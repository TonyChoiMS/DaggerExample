package com.tony.daggerexample.data;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Administrator on 2017-11-08.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface UserScope {
}
