package com.example.library;

import java.util.List;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface DemoService {

//    @POST("/Demo")
//    Call<ResponseBody> login(@Field("user") String user,
//                             @Field("passWord") String passWord);

//    @GET("/Demo")
//    Call<List<User>> getListUser();

    @GET("/api/users?")
    Call<ListUser> doGetUserList(@Query("page") String page);

    @POST("/api/login")
    Call<Account> login(@Body Account account);

}
