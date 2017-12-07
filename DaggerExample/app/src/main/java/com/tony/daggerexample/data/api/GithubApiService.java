package com.tony.daggerexample.data.api;

import com.tony.daggerexample.data.api.response.RepositoryResponse;
import com.tony.daggerexample.data.api.response.UserResponse;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by Administrator on 2017-11-08.
 */

public interface GithubApiService {

    @GET("/users/{username}")
    Observable<UserResponse> getUser(
            @Path("username") String username
    );

    @GET("/users/{username}/repos")
    Observable<List<RepositoryResponse>> getUsersRepositories(
            @Path("username") String username
    );
}
