package com.example.optic;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Toast;

import com.example.optic.apiinterface.Api;
import com.example.optic.apiinterface.ApiClient;
import com.example.optic.apiinterface.responce.pend_responce;
import com.example.optic.apiinterface.responce_get_set.pend_get_set;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class complete extends Fragment {
    RecyclerView recyclerView;
    List<pend_get_set> li;
    SwipeRefreshLayout swipe;
    cmp_adapter ada;
    public complete() {
        loadcmp();
        // Required empty public constructor
    }

    

    @Override
    public void onResume() {
        loadcmp();
        super.onResume();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View root=inflater.inflate(R.layout.fragment_complete, container, false);

        recyclerView=(RecyclerView) root.findViewById(R.id.recy_cmp);
        swipe=(SwipeRefreshLayout) root.findViewById(R.id.swiecmp);
       swipe.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                loadcmp();
                swipe.setRefreshing(false);

            }
        }, 2000);
    }
});
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        loadcmp();

        return root;
    }

    private void loadcmp() {
        Api api= ApiClient.getClient().create(Api.class);
        Call<pend_responce> call=api.cmpbill("cmp");
        call.enqueue(new Callback<pend_responce>() {
            @Override
            public void onResponse(Call<pend_responce> call, Response<pend_responce> response) {
                if (response.body().getSuccess()==200) {

                    li=response.body().getDe();
                    Collections.reverse(li);
                    ada=new cmp_adapter(getContext(),li);
                    recyclerView.setAdapter(ada);

                }
                else {
                    Toast.makeText(getContext(), response.body().getMessage()+"", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<pend_responce> call, Throwable t) {
                Toast.makeText(getContext(), t.getLocalizedMessage()+"", Toast.LENGTH_SHORT).show();

            }
        });
    }

}
