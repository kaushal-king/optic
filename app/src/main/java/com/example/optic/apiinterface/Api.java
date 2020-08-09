package com.example.optic.apiinterface;



import com.example.optic.apiinterface.responce.pend_responce;
import com.example.optic.apiinterface.responce.responce;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("addbill.php")
    Call<CommanResponse> bill(

            @Field("addord") String addord,
            @Field("name") String name,
            @Field("mob") String mob,
            @Field("l") String l,
            @Field("r") String r,
            @Field("u") String u,
            @Field("ll") String ll,
            @Field("lr") String lr,
            @Field("lu") String lu,
            @Field("fprice") String fprice,
            @Field("gprice") String gprice,
            @Field("tprice") String tprice,
            @Field("apay") String apay,
            @Field("baki") String baki,
            @Field("status") String status,
            @Field("date") String date


    );
    @FormUrlEncoded
    @POST("addbill.php")
    Call<CommanResponse> upd(

            @Field("pentocmp") String pentocmp,
            @Field("id") String id


    );




    @FormUrlEncoded
    @POST("addbill.php")
    Call<pend_responce> pendbill(
            @Field("pend") String pend
    );

    @FormUrlEncoded
    @POST("addbill.php")
    Call<pend_responce> cmpbill(
            @Field("cmp") String cmp
    );

    @FormUrlEncoded
    @POST("addbill.php")
    Call<responce> mon(
            @Field("das") String das,
            @Field("i") String i,
            @Field("y") String y
    );


    @FormUrlEncoded
    @POST("addbill.php")
    Call<responce> full(
            @Field("ful") String ful

    );

}
