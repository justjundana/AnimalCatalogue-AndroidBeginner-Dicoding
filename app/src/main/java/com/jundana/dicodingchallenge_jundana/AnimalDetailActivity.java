package com.jundana.dicodingchallenge_jundana;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.Objects;

public class AnimalDetailActivity extends AppCompatActivity {

    ImageView imgPhoto;
    TextView tvItemDetail;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
//        if (toolbar != null) {
//            setSupportActionBar(toolbar);
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//            getSupportActionBar().setHomeButtonEnabled(true);
//            getSupportActionBar().setDisplayShowHomeEnabled(true);
//        }
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(false);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);

        imgPhoto = findViewById(R.id.img_item_photo);
        tvItemDetail = findViewById(R.id.tv_item_detail);

        if(getIntent().getExtras()!=null) {
            final Bundle bundle = getIntent().getExtras();

            int itemPhoto = bundle.getInt("photoItem");

            Glide.with(this)
                    .load(itemPhoto)
                    .into(imgPhoto);

            String itemName = bundle.getString("itemName");
            collapsingToolbar.setTitle(itemName);
            collapsingToolbar.setExpandedTitleColor(Color.RED);
            String itemNameDetail = bundle.getString("itemNameDetail");
            tvItemDetail.setText(itemNameDetail);
        }
    }
}
