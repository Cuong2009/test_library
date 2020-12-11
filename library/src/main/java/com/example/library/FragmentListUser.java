package com.example.library;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentListUser extends Fragment {

    private List<User> users ;
    private RecyclerView recyclerView;
    private UserAdapter userAdapter ;
    private List<ListUser.Datum> datumList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragement_list_user, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.list_user);
        users = new ArrayList<>();
        datumList = new ArrayList<>();
        getListUser();
        return rootView;

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
        userAdapter = new UserAdapter(getActivity(), datumList);
        recyclerView.setAdapter(userAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }


}
