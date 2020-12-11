package com.example.library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserAdapter userAdapter ;
    private List<ListUser.Datum> datumList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        init();
        getListUser();
    }

    private void init () {
        recyclerView = (RecyclerView) findViewById(R.id.list_user_home);
        datumList = new ArrayList<>();
    }

    public void getListUser () {
        DemoService demoService = RetrofitDemo.getRetrofit().create(DemoService.class);
        demoService.doGetUserList("2").enqueue(new Callback<ListUser>() {
            @Override
            public void onResponse(Call<ListUser> call, Response<ListUser> response) {
                ListUser listUser = response.body();
                datumList = listUser.data;
                DisplayListUser();
            }

            @Override
            public void onFailure(Call<ListUser> call, Throwable t) {
                call.cancel();
            }
        });
    }
    public void DisplayListUser() {
        userAdapter = new UserAdapter(this, datumList);
        recyclerView.setAdapter(userAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}