package com.mynet.yatota.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mynet.yatota.Adapters.CategoryAdapter;
import com.mynet.yatota.Adapters.DiscountedProductsAdapter;
import com.mynet.yatota.Adapters.RecentlyViewedAdapter;
import com.mynet.yatota.Model.AllCetegoryModel;
import com.mynet.yatota.Model.Category;
import com.mynet.yatota.Model.DiscountedProducts;
import com.mynet.yatota.Model.RecentlyViewed;
import com.mynet.yatota.R;

import java.util.ArrayList;
import java.util.List;

public class ProductHome extends AppCompatActivity {
    RecyclerView discountRecyclerView, categoryRecyclerView, recentlyViewedRecycler;
    DiscountedProductsAdapter discountedProductAdapter;
    List<DiscountedProducts> discountedProductsList;

    CategoryAdapter categoryAdapter;
    List<Category> categoryList;

    RecentlyViewedAdapter recentlyViewedAdapter;
    List<RecentlyViewed> recentlyViewedList;

    TextView allCategory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_home);
        discountRecyclerView = findViewById(R.id.discountedRecycler);
        categoryRecyclerView = findViewById(R.id.categoryRecycler);
        allCategory = findViewById(R.id.allCategoryImage);
        recentlyViewedRecycler = findViewById(R.id.recently_item);


        allCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProductHome.this, AllCetegoryModel.class);
                startActivity(i);
            }
        });

        // adding data to model
        discountedProductsList = new ArrayList<>();
        discountedProductsList.add(new DiscountedProducts(1, R.drawable.neckroll2));
        discountedProductsList.add(new DiscountedProducts(2, R.drawable.neckroll2));
        discountedProductsList.add(new DiscountedProducts(3, R.drawable.neckroll2));
        discountedProductsList.add(new DiscountedProducts(4, R.drawable.neckroll2));
        discountedProductsList.add(new DiscountedProducts(5, R.drawable.neckroll2));
        discountedProductsList.add(new DiscountedProducts(6, R.drawable.neckroll2));

        // adding data to model
        categoryList = new ArrayList<>();
        categoryList.add(new Category(1, R.drawable.ic_launcher_background));
        categoryList.add(new Category(2, R.drawable.ic_launcher_background));
        categoryList.add(new Category(3, R.drawable.ic_launcher_background));
        categoryList.add(new Category(8, R.drawable.ic_launcher_background));
        categoryList.add(new Category(4, R.drawable.ic_launcher_background));
        categoryList.add(new Category(5, R.drawable.ic_launcher_background));
        categoryList.add(new Category(6, R.drawable.ic_launcher_background));
        categoryList.add(new Category(7, R.drawable.ic_launcher_background));

        // adding data to model
        recentlyViewedList = new ArrayList<>();
        recentlyViewedList.add(new RecentlyViewed("Apricot Aden scrub", "Most in demand scrub for all your facial needs.", "Ksh 550", "1", "PC",R.drawable.neckroll,R.drawable.neckroll3 ));
        recentlyViewedList.add(new RecentlyViewed("Black Hair Shampoo", "Get all that natural dark hair", "Ksh 50", "1", "Pc", R.drawable.neckroll,R.drawable.neckroll3));
        recentlyViewedList.add(new RecentlyViewed("Castol oil", "Best Hair food used by our barbers loved by our clients", "Ksh 300", "1", "Kg", R.drawable.neckroll,R.drawable.neckroll3));
        recentlyViewedList.add(new RecentlyViewed("Chase After Shave", "Best for  that aftershave effect", "Ksh 200", "1", "PC", R.drawable.neckroll,R.drawable.neckroll3));

        setDiscountedRecycler(discountedProductsList);
        setCategoryRecycler(categoryList);
        setRecentlyViewedRecycler(recentlyViewedList);

    }

    private void setDiscountedRecycler(List<DiscountedProducts> dataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        discountRecyclerView.setLayoutManager(layoutManager);
        discountedProductAdapter = new DiscountedProductsAdapter(this, dataList);
        discountRecyclerView.setAdapter(discountedProductAdapter);
    }


    private void setCategoryRecycler(List<Category> categoryDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        categoryRecyclerView.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(this, categoryDataList);
        categoryRecyclerView.setAdapter(categoryAdapter);
    }

    private void setRecentlyViewedRecycler(List<RecentlyViewed> recentlyViewedDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recentlyViewedRecycler.setLayoutManager(layoutManager);
        recentlyViewedAdapter = new RecentlyViewedAdapter(this, recentlyViewedDataList);
        recentlyViewedRecycler.setAdapter(recentlyViewedAdapter);
    }

}

