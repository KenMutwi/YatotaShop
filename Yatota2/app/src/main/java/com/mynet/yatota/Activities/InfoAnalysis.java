package com.mynet.yatota.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mynet.yatota.R;

public class InfoAnalysis extends AppCompatActivity {
    Button managerView,totalView,amazonView,imeldaView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_analysis);
        managerView = findViewById(R.id.manager_view);
        totalView = findViewById(R.id.Total_view);
        amazonView=findViewById(R.id.amazon_view);
        imeldaView=findViewById(R.id.imelda_view);

        managerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent= new Intent(InfoAnalysis.this, ShopData.class);
                startActivity(intent);
            }
        });
        totalView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(InfoAnalysis.this, Cosmetologist1.class);
                startActivity(intent);

            }
        });
        amazonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(InfoAnalysis.this, Amazondata.class);
                startActivity(intent);


            }
        });
        imeldaView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(InfoAnalysis.this, Imeldadata.class);
              startActivity(intent);
            }
        });
    }
}
