package com.mynet.yatota.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mynet.yatota.R;
import com.mynet.yatota.database.Cart;

import static com.mynet.yatota.Activities.ProductHome.myDatabase;

public class ProductDetails extends AppCompatActivity {
    ImageView img, back,imgCart,cartActivity;
    TextView proName, proPrice, proDesc, proQty, proUnit,cartcount;

    String name, price, desc, qty, unit;
    int image,overallprice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        Intent i = getIntent();

        name = i.getStringExtra("name");
        image = i.getIntExtra("image", R.drawable.neckroll3);
        price = i.getStringExtra("price");
        desc = i.getStringExtra("desc");
        qty = i.getStringExtra("qty");
        unit = i.getStringExtra("unit");
        final int id=i.getIntExtra("id",0);

        imgCart= findViewById(R.id.imageView7);
        proName = findViewById(R.id.productName);
        proDesc = findViewById(R.id.prodDesc);
        proPrice = findViewById(R.id.prodPrice);
        img = findViewById(R.id.big_image);
        back = findViewById(R.id.back2);
        proQty = findViewById(R.id.qty);
        proUnit = findViewById(R.id.unit);
        cartActivity=findViewById(R.id.cart);
        cartcount=findViewById(R.id.cartcount);

        proName.setText(name);
        proPrice.setText(price);
        proDesc.setText(desc);
        proQty.setText(qty);
        proUnit.setText(unit);


        img.setImageResource(image);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(ProductDetails.this, ProductHome.class);
                startActivity(i);
                finish();

            }
        });
        imgCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cart cart=new Cart();
                cart.setId(id);
                cart.setImg(image);
                cart.setName(name);
                cart.setProPrice(price);
                if (myDatabase.cartDao().isAddToCart(id)!=1){
                    myDatabase.cartDao().addToCart(cart);
                    Toast.makeText(ProductDetails.this, "Product Added", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(ProductDetails.this, "You Already added this to cart!", Toast.LENGTH_SHORT).show();

                }
            }
        });
        cartActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProductDetails.this,MyCartActivity.class));
            }
        });

    }
    private void updatacartcount() {
        if (cartcount==null)return;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (myDatabase.cartDao().countCart()==0)
                    cartcount.setVisibility(View.INVISIBLE);
                else {
                    cartcount.setVisibility(View.VISIBLE);
                    cartcount.setText(String.valueOf(myDatabase.cartDao().countCart()));
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        updatacartcount();
    }



}
