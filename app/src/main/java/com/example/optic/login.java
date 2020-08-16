package com.example.optic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.optic.apiinterface.Api;
import com.example.optic.apiinterface.ApiClient;
import com.example.optic.apiinterface.responce.loginresponce;
import com.example.optic.storage.sareprefrencelogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login extends AppCompatActivity {
EditText mo,pa;
Button l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mo=(EditText) findViewById(R.id.mob);
        pa=(EditText) findViewById(R.id.pass);
        l=(Button) findViewById(R.id.lo);



        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n=mo.getText().toString();
                String p=pa.getText().toString();
                Api api = ApiClient.getClient().create(Api.class);
                Call<loginresponce> call=api.login("login",n,p);
                call.enqueue(new Callback<loginresponce>() {
                    @Override
                    public void onResponse(Call<loginresponce> call, Response<loginresponce> response) {
                        if (response.body().getSuccess()==405) {
                            loginresponce loginresponce=response.body();
                            sareprefrencelogin.getInstance(login.this).saveuser(loginresponce.getUser());
                            Intent i = new Intent(login.this, MainActivity.class);
                            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(i);
                            Toast.makeText(login.this, response.body().getMessage()+"", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(login.this, response.body().getMessage()+"", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<loginresponce> call, Throwable t) {
                        Toast.makeText(login.this, t.getLocalizedMessage()+"", Toast.LENGTH_SHORT).show();
                    }
                });






            }
        });
    }



    @Override
    protected void onStart() {
        super.onStart();
        if(sareprefrencelogin.getInstance(this).islogin())
        {
            Intent i = new Intent(login.this, MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        }

    }

}
