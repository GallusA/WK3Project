package com.example.gallusawa.wk3project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class BookActivity extends AppCompatActivity {

    ImageView bigImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        bigImage = (ImageView) findViewById(R.id.imageView);
        Intent intent = getIntent();
        String img = intent.getStringExtra("picture");
        Glide.with(this).load(img).into(bigImage);
    }
}