package com.mynet.yatota.Interfaces;

import com.mynet.yatota.Model.ManagerimodelClass;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface2 {

    @FormUrlEncoded
    @POST("managerupload.php")
    Call<ManagerimodelClass> manageruploaddata(@Field("timeserved") String timeserved, @Field("attendant") String attendant, @Field("customergender") String customergender,
                                               @Field("customerage") String customerage, @Field("servicetype") String servicetype, @Field("amount") String amount, @Field("mpesacode") String mpesacode);

}
