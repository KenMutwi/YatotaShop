package com.mynet.yatota.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.mynet.yatota.Interfaces.ApiInterface2;
import com.mynet.yatota.Model.ManagerimodelClass;
import com.mynet.yatota.R;
import com.mynet.yatota.Utilis.ApiClient;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ManagerPortal extends AppCompatActivity {
    Button submit,presstime;
    EditText time, amount, mpesacode;
    CheckBox shave, beard, scrub, dye, style, rocks, pedi, mani, massage;
    RadioGroup gender, age, attendant, athi, mesus;
    TextView  output;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_portal);

        time = findViewById(R.id.timeSevice);
        amount= findViewById(R.id.chargeRate);
        mpesacode = findViewById(R.id.mpesacode);
        attendant= findViewById(R.id.attendant);
        shave = findViewById(R.id.shave);
        beard = findViewById(R.id.beard);
        scrub = findViewById(R.id.scrub);
        dye = findViewById(R.id.dye);
        style = findViewById(R.id.style);
        rocks = findViewById(R.id.rocks);
        pedi = findViewById(R.id.pedi);
        mani = findViewById(R.id.mani);
        massage = findViewById(R.id.massage);
        gender = findViewById(R.id.gender);
        age = findViewById(R.id.age);
        output = findViewById(R.id.output);
        submit = findViewById(R.id.submit);
        presstime=findViewById(R.id.clienttime);

        time.setInputType(InputType.TYPE_NULL);

        presstime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar= Calendar.getInstance();
                SimpleDateFormat format=new SimpleDateFormat("HH:mm");
                String exact_time=format.format(calendar.getTime());
                time.setText(exact_time);
                getcurrenttime();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                manageruploaddata();


            }
        });

    }

    private void getcurrenttime() {
        final Calendar calendar = Calendar.getInstance();


    }

    private  String resultattendant(){
        String resultattendant = "";
        int attendant_id = attendant.getCheckedRadioButtonId();
        if (attendant_id==R.id.obama){
            String obama1 = new String("Obama");
            resultattendant=obama1;
        }

        if (attendant_id==R.id.mike){
            String mike1 = new String("Mike");
            resultattendant= mike1;
        }
        if (attendant_id==R.id.levee){
            String levee = new String("Levee");
            resultattendant= levee;

        }
        return resultattendant;
    }

    private String resultgender(){
        String genderchoice = "";
        int gender_id= gender.getCheckedRadioButtonId();
        if (gender_id==R.id.male){
            String male = new String("Male");
            genderchoice=male;
        }else{
            String female = new String("Female");
            genderchoice=female;

        }
        return genderchoice;
    }
    private String resultage(){
        String agechoice ="";
        int age_id=age.getCheckedRadioButtonId();
        if (age_id==R.id.adult){
            String adult = new String("Adult");
            agechoice=adult;

        }else{
            String kid = new String("Kid");
            agechoice=kid;
        }
        return agechoice;
    }
    private String resultservice(){
        String servicechoice = "";
        if (shave.isChecked()){
            String shave = new String("Shave,");
            servicechoice=shave;
        }
        if (beard.isChecked()){
            String beard = new String("Beard");
            servicechoice=beard;
        }
        if (scrub.isChecked()){
            String scrub = new String("Scrub");
            servicechoice = scrub;

        }
        if (dye.isChecked()){
            String dye = new String("Dye");
            servicechoice=dye;
        }
        if (style.isChecked()){
            String style = new String("Style");
            servicechoice=style;

        }
        if (rocks.isChecked()){
            String rocks = new String("Rocks");
            servicechoice=rocks;
        }
        if (pedi.isChecked()){
            String pedicure = new String("Pedicure");
            servicechoice=pedicure;
        }
        if (mani.isChecked()){
            String manicure = new String("Manicure");
            servicechoice=manicure;
        }
        if (massage.isChecked()){
            String massage = new String("Full Massage");
            servicechoice=massage;
        }
        return servicechoice;
    }

    private void manageruploaddata() {
        String TimeServed = time.getText().toString();
        String Attendant =resultattendant();
        String CustomerGender=resultgender();
        String CustomerAge=resultage();
        String ServiceType=resultservice();
        String Amount = amount.getText().toString();
        String MpesaCode = mpesacode.getText().toString();

        output.append("\n");
        output.append(TimeServed);
        output.append("\n");
        output.append(Attendant);
        output.append("\n");
        output.append(CustomerGender);
        output.append("\n");
        output.append(CustomerAge);
        output.append("\n");
        output.append(ServiceType);
        output.append("\n");
        output.append(Amount);
        output.append("\n");
        output.append(MpesaCode);
        output.append("\n");

        ApiInterface2 apiInterface2 = ApiClient.getApiClient().create(ApiInterface2.class);
        Call<ManagerimodelClass> call = apiInterface2.manageruploaddata(TimeServed,Attendant,CustomerGender,CustomerAge,ServiceType,Amount,MpesaCode);

        call.enqueue(new Callback<ManagerimodelClass>() {
            @Override
            public void onResponse(Call<ManagerimodelClass> call, Response<ManagerimodelClass> response) {
                Toast.makeText(ManagerPortal.this, "Data Sent Successfully:", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ManagerimodelClass> call, Throwable t) {
                Toast.makeText(ManagerPortal.this, "Data NOT Sent Successfully:", Toast.LENGTH_SHORT).show();

            }
        });

    }
}