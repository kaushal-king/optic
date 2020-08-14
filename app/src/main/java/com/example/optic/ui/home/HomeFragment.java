package com.example.optic.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.optic.R;
import com.example.optic.apiinterface.Api;
import com.example.optic.apiinterface.ApiClient;
import com.example.optic.apiinterface.CommanResponse;
import com.example.optic.apiinterface.responce.responce;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
TextView to,tr,lo,lr,tt,rr;
String month="ii",year="ii";
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.dashboard, container, false);
        String s =new SimpleDateFormat("MM-yyyy", Locale.US).format(new Date());
        String s1 =new SimpleDateFormat("MM", Locale.US).format(new Date());
        String s2 =new SimpleDateFormat("yyyy", Locale.US).format(new Date());
        int m=Integer.parseInt(s1);
        int y=Integer.parseInt(s2);



        if(m==1)
        {
            m=12;
            y=y-1;
            month="12";
            year=y+"";

        }
        if (m==2)
        {
            month="01";
            year=s2;

        }
        if (m==3)
        {
            month="02";
            year=s2;

        }
        if (m==4)
        {
            month="03";
            year=s2;

        }
        if (m==5)
        {
            month="04";
            year=s2;

        }
        if (m==6)
        {
            month="05";
            year=s2;

        }
        if (m==7)
        {
            month="06";
            year=s2;

        }
        if (m==8)
        {
            month="07";
            year=s2;

        }
        if (m==9)
        {
            month="08";
            year=s2;

        }
        if (m==10)
        {
            month="09";
            year=s2;

        }
        if (m==11)
        {
            month="10";
            year=s2;

        }
        if (m==12)
        {
            month="11";
            year=s2;

        }

       // Toast.makeText(getContext(),"month:--"+month+"year;--"+year,Toast.LENGTH_LONG).show();


        to=(TextView) root.findViewById(R.id.tm);
        tr=(TextView) root.findViewById(R.id.tr);
        lo=(TextView) root.findViewById(R.id.lm);
        lr=(TextView) root.findViewById(R.id.lr);
        tt=(TextView) root.findViewById(R.id.tmm);
        rr=(TextView) root.findViewById(R.id.trr);


        Api api= ApiClient.getClient().create(Api.class);
        Call<responce> call= api.mon("das",s1,s2);
        call.enqueue(new Callback<responce>() {
            @Override
            public void onResponse(Call<responce> call, Response<responce> response) {
                if (response.body().getSuccess()==200) {
                  to.setText(response.body().getDe().getId());
                    tr.setText(response.body().getDe().getSum());
                }
                else {
                    Toast.makeText(getContext(), response.body().getMessage()+"", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<responce> call, Throwable t) {
                Toast.makeText(getContext(), t.getLocalizedMessage()+"", Toast.LENGTH_SHORT).show();
            }
        });


        Api api2= ApiClient.getClient().create(Api.class);
        Call<responce> call2= api2.full("ful");
        call2.enqueue(new Callback<responce>() {
            @Override
            public void onResponse(Call<responce> call, Response<responce> response) {
                if (response.body().getSuccess()==200) {
                    tt.setText(response.body().getDe().getId());
                    rr.setText(response.body().getDe().getSum());
                }
                else {
                    Toast.makeText(getContext(), response.body().getMessage()+"", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<responce> call, Throwable t) {
                Toast.makeText(getContext(), t.getLocalizedMessage()+"", Toast.LENGTH_SHORT).show();
            }
        });


        Api api3= ApiClient.getClient().create(Api.class);
        Call<responce> call3= api3.mon("das",month,year);
        call3.enqueue(new Callback<responce>() {
            @Override
            public void onResponse(Call<responce> call, Response<responce> response) {
                if (response.body().getSuccess()==200) {

                    lo.setText(response.body().getDe().getId());

                    if(response.body().getDe().getSum()==null)
                    {
                        lr.setText("0");
                    }
                    else {
                        lr.setText(response.body().getDe().getSum());
                    }

                }
                else {
                    Toast.makeText(getContext(), response.body().getMessage()+"", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<responce> call, Throwable t) {
                Toast.makeText(getContext(), t.getLocalizedMessage()+"", Toast.LENGTH_SHORT).show();
            }
        });





        return root;
    }
}