package com.mynet.yatota.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.mynet.yatota.R;
import com.mynet.yatota.Utilis.Endpoints;

public class LiveShopActivity extends AppCompatActivity {
    ImageView shop1view,shop2view,shop3view,shop4view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_shop);

        shop1view=(ImageView)findViewById(R.id.imageChair1);
        shop2view=(ImageView)findViewById(R.id.imageChair2);
        shop3view=(ImageView)findViewById(R.id.imageChair3);
        shop4view=(ImageView)findViewById(R.id.imageChair4);

        shop1view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Getchair1();

            }
        });
        shop2view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Getchair2();

            }
        });
        shop3view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Getchair3();

            }
        });
        shop4view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Getchair4();

            }
        });

    }

    private void Getchair3() {
        Uri uri = Uri.parse(Endpoints.ichair3_url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private void Getchair4() {
        Uri uri = Uri.parse(Endpoints.ichair4_url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private void Getchair2() {
        Uri uri = Uri.parse(Endpoints.ichair2_url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private void Getchair1() {
        Uri uri = Uri.parse(Endpoints.ichair1_url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
