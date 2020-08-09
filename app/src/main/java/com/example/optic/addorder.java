package com.example.optic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.optic.apiinterface.Api;
import com.example.optic.apiinterface.ApiClient;
import com.example.optic.apiinterface.CommanResponse;
import com.example.optic.ui.gallery.GalleryFragment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class addorder extends AppCompatActivity {
    EditText name,mobile,l,r,u,ll,rr,uu,fprice,gprice,tprice,apay;
    String sname,smobile,sl,sr,su,sll,srr,suu,sfprice,sgprice,stprice,sapay;
    Button s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addorder);


        name=(EditText) findViewById(R.id.name);
        mobile=(EditText) findViewById(R.id.mobile);
        l=(EditText) findViewById(R.id.lhs);
        r=(EditText) findViewById(R.id.rhs);
        u=(EditText) findViewById(R.id.uuu);
        ll=(EditText) findViewById(R.id.llhs);
        rr=(EditText) findViewById(R.id.lrhs);
        uu=(EditText) findViewById(R.id.luuu);
        fprice=(EditText) findViewById(R.id.frame_price);
        gprice=(EditText) findViewById(R.id.glass_price);
        tprice=(EditText) findViewById(R.id.total);
        apay=(EditText) findViewById(R.id.advance);
        fprice.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                sfprice=fprice.getText().toString();
                sgprice=gprice.getText().toString();
                int f,g,pp;
                if(sgprice.length()==0){
                    f=Integer.parseInt(sfprice);
                    pp=f+0;
                    tprice.setText(pp+"");
                }
                else if(sfprice.length()==0){
                    g=Integer.parseInt(sgprice);
                    pp=0+g;
                    tprice.setText(pp+"");
                }
                else {
                    f = Integer.parseInt(sfprice);
                    g = Integer.parseInt(sgprice);

                    pp = f + g;

                    tprice.setText(pp + "");
                }

            }
        });
        gprice.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                sfprice=fprice.getText().toString();
                sgprice=gprice.getText().toString();

                int f,g,pp;
                if(sfprice.length()==0){
                    g=Integer.parseInt(sgprice);
                    pp=0+g;
                    tprice.setText(pp+"");
                }
                else  if(sgprice.length()==0){
                    f=Integer.parseInt(sfprice);
                    pp=f+0;
                    tprice.setText(pp+"");
                }
                else {
                    f = Integer.parseInt(sfprice);
                    g = Integer.parseInt(sgprice);

                    pp = f + g;

                    tprice.setText(pp + "");
                }

            }
        });



        s=(Button) findViewById(R.id.save);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sname=name.getText().toString();
                smobile=mobile.getText().toString();
                sl=l.getText().toString();
                sr=r.getText().toString();
                su=u.getText().toString();
                sll=ll.getText().toString();
                srr=rr.getText().toString();
                suu=uu.getText().toString();
                sfprice=fprice.getText().toString();
                sgprice=gprice.getText().toString();
                stprice=tprice.getText().toString();
                sapay=apay.getText().toString();

                if(!sname.isEmpty()&&!smobile.isEmpty()&&!sl.isEmpty()&&!sr.isEmpty()&&!su.isEmpty()&&!sll.isEmpty()&&
                        !suu.isEmpty()&&!srr.isEmpty()&&!sfprice.isEmpty()&&!sgprice.isEmpty()&&!stprice.isEmpty()&&!sapay.isEmpty())
                {

                    int r,y,t;
                    r=Integer.parseInt(stprice);
                    y=Integer.parseInt(sapay);
                    t=r-y;

                    String s =new SimpleDateFormat("dd-MM-yyyy", Locale.US).format(new Date());
                    Api api= ApiClient.getClient().create(Api.class);
                    Call<CommanResponse> call= api.bill("addord",sname,smobile,sl,sr,su,sll,srr,suu,sfprice,sgprice,stprice,sapay,t+"","0",s);
                    call.enqueue(new Callback<CommanResponse>() {
                        @Override
                        public void onResponse(Call<CommanResponse> call, Response<CommanResponse> response) {
                            if (response.body().getSuccess()==200) {
                                Toast.makeText(getApplicationContext(), response.body().getMessage()+"", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                            else {
                                Toast.makeText(getApplicationContext(), response.body().getMessage()+"", Toast.LENGTH_SHORT).show();

                            }
                        }

                        @Override
                        public void onFailure(Call<CommanResponse> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), t.getLocalizedMessage()+"", Toast.LENGTH_SHORT).show();

                        }
                    });
                }
                else {
                    Toast.makeText(getApplicationContext(),"enter All Field",Toast.LENGTH_SHORT).show();
                }


            }
        });



    }

    public void addordert(View view) {
            }
}
