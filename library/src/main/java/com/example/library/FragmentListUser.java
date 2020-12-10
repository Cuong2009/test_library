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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragement_list_user, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.list_user);
        users = new ArrayList<>();
        getListUser();
        userAdapter = new UserAdapter(getActivity(), users);
        recyclerView.setAdapter(userAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return rootView;

    }
    private void getListUser () {
        DemoService demoService = RetrofitDemo.getRetrofit().create(DemoService.class);
        demoService.getListUser().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                users = response.body();
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(getActivity(), "Login fail ",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

}