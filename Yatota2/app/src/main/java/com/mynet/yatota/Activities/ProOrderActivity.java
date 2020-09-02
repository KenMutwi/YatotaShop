package com.mynet.yatota.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mynet.yatota.Interfaces.ApimProducts;
import com.mynet.yatota.Model.Pmanagerupload1;
import com.mynet.yatota.R;
import com.mynet.yatota.Utilis.ApiClient;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProOrderActivity extends AppCompatActivity {
    Button submitProducts, prodatepress, protimepress;
    CheckBox scrub, blackshampoo, vasilinemen, surgicalspirit, dettol, kinghearts, massageoil, shavingfoam, pumppatrol, castoloil, ospray, bvaseline, neckroll, freshmancool, shampoo, tonner, cremeofnature, masque;
    RadioGroup shopone, shoptwo, shopthree, shopfour, shopfive, allShops;
    EditText protime, prodate, proamount, prompesa;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_order);

        output = findViewById(R.id.output1);
        protime = findViewById(R.id.timeSevice1);
        masque = findViewById(R.id.masque);
        vasilinemen = findViewById(R.id.vaseline);
        submitProducts = findViewById(R.id.submit1);
        prodate = findViewById(R.id.dateSevice);
        proamount = findViewById(R.id.chargeRate1);
        prompesa = findViewById(R.id.mpesacodef);
        prodatepress = findViewById(R.id.clientdate);
        protimepress = findViewById(R.id.clienttime);
        scrub = findViewById(R.id.scrub1);
        blackshampoo = findViewById(R.id.bshampoo);
        dettol = findViewById(R.id.dettol);
        kinghearts = findViewById(R.id.khearts);
        massageoil = findViewById(R.id.msoil);
        shavingfoam = findViewById(R.id.shave);
        pumppatrol = findViewById(R.id.Pump);
        surgicalspirit = findViewById(R.id.spirit);
        castoloil = findViewById(R.id.castoroil);
        ospray = findViewById(R.id.olive);
        bvaseline = findViewById(R.id.bvase);
        neckroll = findViewById(R.id.neckr);
        freshmancool = findViewById(R.id.freshman);
        shampoo = findViewById(R.id.shampoo);
        tonner = findViewById(R.id.tonner);
        cremeofnature = findViewById(R.id.creme);
        allShops = findViewById(R.id.allshops);

        protimepress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settime();
            }
        });
        prodatepress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setdate();
            }
        });
        submitProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                issueproducts();
            }
        });
    }

    private void issueproducts() {
        String Shops = shop_result();
        String DateIssued = prodate.getText().toString();
        String TimeIssued = protime.getText().toString();
        String AmountPaid = proamount.getText().toString();
        String MpesaCode = prompesa.getText().toString();
        String PumpPatrol = pump_patrol_result();
        String VaselineMen = vaseline_men_result();
        String NeckRoll = neckroll_result();
        String ShavingFoam = shaving_foam_result();
        String MassageOil = massage_oil_result();
        String KingHearts = king_hearts_result();
        String FreshMan = fresh_man_result();
        String ShampooSoap = shampoo_soap_result();
        String SurgicalSpirit = surgical_spirit_result();
        String AdenScrub = aden_scrub_result();
        String Tonner = tonner_result();
        String Masque = masque_result();
        String Cleanser = cleanser_result();
        String CremeNature = creme_nature_result();
        String BlackShampoo = black_shampoo_result();
        String Dettol = dettol_result();
        String CastolOil = castol_oil_result();
        String OliveSpray = olive_spray_result();
        String VaselineBaby = vaseline_baby_result();


//        output.append(shops);
//        output.append("\n");
//        output.append("\n");
//        output.append(date_issued);
//        output.append("\n");
//        output.append(time_issued);
//        output.append("\n");
//        output.append(amount_paid);
//        output.append("\n");
//        output.append(mpesa_code);
//        output.append("\n");
//        output.append(pump_patrol);
//        output.append("\n");
//        output.append(vaseline_men);
//        output.append("\n");
//        output.append(neck_roll);
//        output.append("\n");
//        output.append(shaving_foam);
//        output.append("\n");
//        output.append(massage_oil);
//        output.append("\n");
//        output.append(king_hearts);
//        output.append("\n");
//        output.append(fresh_man);
//        output.append("\n");
//        output.append(shampoo_soap);
//        output.append("\n");
//        output.append(surgical_spirit);
//        output.append("\n");
//        output.append(aden_scrub);
//        output.append("\n");
//        output.append(tonner);
//        output.append("\n");
//        output.append(masque);
//        output.append("\n");
//        output.append(cleanser);
//        output.append("\n");
//        output.append(creme_nature);
//        output.append("\n");
//        output.append(black_shampoo);
//        output.append("\n");
//        output.append(dettol);
//        output.append("\n");
//        output.append(castol_oil);
//        output.append("\n");
//        output.append(olive_spray);
//        output.append("\n");
//        output.append(vaseline_baby);
//        output.append("\n");

        ApimProducts apimProducts = ApiClient.getApiClient().create(ApimProducts.class);
        Call<Pmanagerupload1> call = apimProducts.issueproducts(Shops, DateIssued, TimeIssued, AmountPaid,MpesaCode,PumpPatrol,VaselineMen,NeckRoll,ShavingFoam,MassageOil,KingHearts,FreshMan,ShampooSoap,SurgicalSpirit,AdenScrub,Tonner,Masque,Cleanser,CremeNature,BlackShampoo, Dettol, CastolOil,OliveSpray,VaselineBaby);
        call.enqueue(new Callback<Pmanagerupload1>() {
            @Override
            public void onResponse(Call<Pmanagerupload1> call, Response<Pmanagerupload1> response) {
                Toast.makeText(ProOrderActivity.this, "Data Sent Successfully:", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Pmanagerupload1> call, Throwable t) {
                Toast.makeText(ProOrderActivity.this, "Data NOT SENT", Toast.LENGTH_SHORT).show();

            }
        });


    }

    private String shop_result() {
        String shopchoice = "";
        int shop_id = allShops.getCheckedRadioButtonId();
        if (shop_id == R.id.shop1) {
            String item = new String("Shop One");
            shopchoice = item;
            return shopchoice;

        }
        int shop2_id = allShops.getCheckedRadioButtonId();
        if (shop2_id == R.id.shop2) {
            String item2 = new String("Shop two");
            shopchoice = item2;
            return shopchoice;
        }
        int shop3_id = allShops.getCheckedRadioButtonId();
        if (shop3_id == R.id.shop3) {
            String item3 = new String("Shop Three");
            shopchoice = item3;
            return shopchoice;
        }
        int shop4_id = allShops.getCheckedRadioButtonId();
        if (shop4_id == R.id.shop4) {
            String item4 = new String("Shop four");
            shopchoice = item4;
            return shopchoice;
        }
        int shop5_id = allShops.getCheckedRadioButtonId();
        if (shop5_id == R.id.shop5) {
            String item5 = new String("Shop five");
            shopchoice = item5;
            return shopchoice;
        }

        return shopchoice;

    }

    private String vaseline_baby_result() {
        String vaseline_baby_choice = "";
        if (bvaseline.isChecked()) {
            String string_item = new String("Vaseline Baby");
            vaseline_baby_choice = string_item;
        } else {
            String string_null = new String("0");
            vaseline_baby_choice = string_null;
        }
        return vaseline_baby_choice;

    }

    private String olive_spray_result() {
        String olive_spray_choice = "";
        if (ospray.isChecked()) {
            String string_item = new String("Olive Spray");
            olive_spray_choice = string_item;
        } else {
            String string_null = new String("0");
            olive_spray_choice = string_null;
        }
        return olive_spray_choice;

    }

    private String castol_oil_result() {
        String castol_oil_choice = "";
        if (castoloil.isChecked()) {
            String string_item = new String("Castol Oil");
            castol_oil_choice = string_item;
        } else {
            String string_null = new String("0");
            castol_oil_choice = string_null;
        }
        return castol_oil_choice;
    }

    private String dettol_result() {
        String dettol_choice = "";
        if (dettol.isChecked()) {
            String string_item = new String("Dettol");
            dettol_choice = string_item;
        } else {
            String string_null = new String("0");
            dettol_choice = string_null;
        }
        return dettol_choice;

    }

    private String black_shampoo_result() {
        String black_shampoo_choice = "";
        if (blackshampoo.isChecked()) {
            String string_item = new String("Black Shampoo");
            black_shampoo_choice = string_item;
        } else {
            String string_null = new String("0");
            black_shampoo_choice = string_null;
        }
        return black_shampoo_choice;

    }

    private String creme_nature_result() {
        String creme_nature_choice = "";
        if (cremeofnature.isChecked()) {
            String string_item = new String("Creme Nature");
            creme_nature_choice = string_item;
        } else {
            String string_null = new String("0");
            creme_nature_choice = string_null;
        }
        return creme_nature_choice;

    }

    private String cleanser_result() {
        String cleanser_choice = "";
        if (masque.isChecked()) {
            String string_item = new String("Cleanser");
            cleanser_choice = string_item;
        } else {
            String string_null = new String("0");
            cleanser_choice = string_null;
        }
        return cleanser_choice;

    }

    private String masque_result() {
        String masque_choice = "";
        if (masque.isChecked()) {
            String string_item = new String("Masque");
            masque_choice = string_item;
        } else {
            String string_null = new String("0");
            masque_choice = string_null;
        }
        return masque_choice;

    }

    private String tonner_result() {
        String tonner_choice = "";
        if (tonner.isChecked()) {
            String string_item = new String("Tonner");
            tonner_choice = string_item;
        } else {
            String string_null = new String("0");
            tonner_choice = string_null;
        }
        return tonner_choice;
    }

    private String aden_scrub_result() {
        String aden_scrub_choice = "";
        if (scrub.isChecked()) {
            String string_item = new String("Aden Scrub");
            aden_scrub_choice = string_item;
        } else {
            String string_null = new String("0");
            aden_scrub_choice = string_null;
        }
        return aden_scrub_choice;
    }

    private String surgical_spirit_result() {
        String surgical_spirit_choice = "";
        if (surgicalspirit.isChecked()) {
            String string_item = new String("Spirit");
            surgical_spirit_choice = string_item;
        } else {
            String string_null = new String("0");
            surgical_spirit_choice = string_null;
        }
        return surgical_spirit_choice;

    }

    private String shampoo_soap_result() {
        String shampoo_soap_choice = "";
        if (shampoo.isChecked()) {
            String string_item = new String("Shampoo");
            shampoo_soap_choice = string_item;
        } else {
            String string_null = new String("0");
            shampoo_soap_choice = string_null;
        }
        return shampoo_soap_choice;

    }

    private String fresh_man_result() {
        String freshman_choice = "";
        if (freshmancool.isChecked()) {
            String string_item = new String("Fresh Man");
            freshman_choice = string_item;
        } else {
            String string_null = new String("0");
            freshman_choice = string_null;
        }
        return freshman_choice;

    }

    private String king_hearts_result() {
        String king_hearts_choice = "";
        if (kinghearts.isChecked()) {
            String string_item = new String("King Hearts");
            king_hearts_choice = string_item;
        } else {
            String string_null = new String("0");
            king_hearts_choice = string_null;
        }
        return king_hearts_choice;

    }

    private String massage_oil_result() {
        String massage_oil_choice = "";
        if (massageoil.isChecked()) {
            String string_item = new String("massage Oil )");
            massage_oil_choice = string_item;
        } else {
            String string_null = new String("0");
            massage_oil_choice = string_null;
        }
        return massage_oil_choice;
    }

    private String shaving_foam_result() {
        String shaving_foam_choice = "";
        if (shavingfoam.isChecked()) {
            String string_item = new String("Shaving Foam");
            shaving_foam_choice = string_item;
        } else {
            String string_null = new String("0");
            shaving_foam_choice = string_null;
        }
        return shaving_foam_choice;
    }

    private String pump_patrol_result() {
        String pump_patrol_choice = "";
        if (neckroll.isChecked()) {
            String string_item = new String("Pump_patrol");
            pump_patrol_choice = string_item;
        } else {
            String string_null = new String("0");
            pump_patrol_choice = string_null;
        }
        return pump_patrol_choice;

    }

    private String vaseline_men_result() {
        String vaseline_men_choice = "";
        if (vasilinemen.isChecked()) {
            String string_item = new String("Vaseline_men");
            vaseline_men_choice = string_item;
        } else {
            String string_null = new String("0");
            vaseline_men_choice = string_null;
        }
        return vaseline_men_choice;
    }

    private String neckroll_result() {
        String neckroll_choice = "";
        if (neckroll.isChecked()) {
            String neckroll = new String("Neckroll");
            neckroll_choice = neckroll;
        } else {
            String neck_roll_null = new String("0");
            neckroll_choice = neck_roll_null;
        }
        return neckroll_choice;
    }

    private void setdate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd:MM:yy");
        String exact_time = format.format(calendar.getTime());
        prodate.setText(exact_time);
        getcurrenttime();
    }

    private void settime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        String exact_time = format.format(calendar.getTime());
        protime.setText(exact_time);
        getcurrenttime();
    }

    private void getcurrenttime() {
        final Calendar calendar = Calendar.getInstance();
    }
}
