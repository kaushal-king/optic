package com.example.optic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class display extends AppCompatActivity {
    EditText dname,dmobile,dl,dr,du,dll,drr,duu,dfprice,dgprice,dtprice,dapay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        dname=(EditText) findViewById(R.id.dname);
        dmobile=(EditText) findViewById(R.id.dmobile);
        dl=(EditText) findViewById(R.id.dlhs);
        dr=(EditText) findViewById(R.id.drhs);
        du=(EditText) findViewById(R.id.duuu);
        dll=(EditText) findViewById(R.id.dllhs);
        drr=(EditText) findViewById(R.id.dlrhs);
        duu=(EditText) findViewById(R.id.dluuu);
        dfprice=(EditText) findViewById(R.id.dframe_price);
        dgprice=(EditText) findViewById(R.id.dglass_price);
        dtprice=(EditText) findViewById(R.id.dtotal);
        dapay=(EditText) findViewById(R.id.dadvance);



        dname.setFocusable(false);
        dname.setClickable(false);
        dmobile.setFocusable(false);
        dmobile.setClickable(false);
        dl.setFocusable(false);
        dl.setClickable(false);
        du.setFocusable(false);
        du.setClickable(false);
        dr.setFocusable(false);
        dr.setClickable(false);
        dll.setFocusable(false);
        dll.setClickable(false);
        duu.setFocusable(false);
        duu.setClickable(false);
        drr.setFocusable(false);
        drr.setClickable(false);
        dfprice.setFocusable(false);
        dfprice.setClickable(false);
        dgprice.setFocusable(false);
        dgprice.setClickable(false);
        dtprice.setFocusable(false);
        dtprice.setClickable(false);
        dapay.setFocusable(false);
        dapay.setClickable(false);


        Intent i=getIntent();
        dname.setText(i.getStringExtra("name"));
        dmobile.setText((i.getStringExtra("mob")));
        dl.setText((i.getStringExtra("l")));
        dr.setText((i.getStringExtra("r")));
        du.setText((i.getStringExtra("u")));
        dll.setText((i.getStringExtra("ll")));
        drr.setText((i.getStringExtra("lr")));
        duu.setText((i.getStringExtra("lu")));
        dfprice.setText((i.getStringExtra("gprice")));
        dgprice.setText((i.getStringExtra("total")));
        dtprice.setText((i.getStringExtra("fprice")));
        dapay.setText((i.getStringExtra("advance")));


    }
}
