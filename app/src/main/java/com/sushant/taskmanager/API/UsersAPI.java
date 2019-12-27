package com.sushant.taskmanager.API;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface UsersAPI {

    @POST("users/login")
    Call<Void> checkUsers(@Field("username") String username, @Field("password") String password);
}
