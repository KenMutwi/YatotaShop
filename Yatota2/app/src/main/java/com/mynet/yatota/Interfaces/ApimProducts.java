package com.mynet.yatota.Interfaces;

import com.mynet.yatota.Model.ManagerimodelClass;
import com.mynet.yatota.Model.Pmanagerupload1;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApimProducts {

    @FormUrlEncoded
    @POST("mproductsupload.php")
    Call<Pmanagerupload1> issueproducts(@Field("shops") String shops, @Field("dateissued") String dateissued, @Field("timeissued") String timeissued,
                                           @Field("amountpaid") String amountpaid, @Field("mpesacode") String mpesacode, @Field("pumppatrol") String pumppatrol, @Field("vaselinemen") String vaselinemen,
                                           @Field("neckroll") String neckroll, @Field("shavingfoam") String shavingfoam, @Field("massageoil") String massageoil,
                                           @Field("kinghearts") String kinghearts, @Field("freshman") String freshman, @Field("shampoosoap") String shampoosoap, @Field("surgicalspirit") String surgicalspirit,
                                           @Field("adenscrub") String adenscrub, @Field("tonner") String tonner, @Field("masque") String masque, @Field("cleanser") String cleanser,
                                           @Field("cremenature") String cremenature, @Field("blackshampoo") String blackshampoo, @Field("dettol") String dettol, @Field("castoloil") String castoloil,
                                           @Field("olivespray") String olivespray, @Field("vaselinebaby") String vaselinebaby);

}
