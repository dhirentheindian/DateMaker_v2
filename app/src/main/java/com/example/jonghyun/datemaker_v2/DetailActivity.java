package com.example.jonghyun.datemaker_v2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    Button detail_btn_gmap;
    TextView detail_tv_location, detail_tv_price;
    ImageView detail_iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setTitle("GET THE NAME OF PLACE");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        detail_btn_gmap = (Button) findViewById(R.id.detail_btn_gmap);
        detail_tv_location = (TextView) findViewById(R.id.detail_tv_location);
        detail_tv_price = (TextView) findViewById(R.id.detail_tv_price);
        detail_iv = (ImageView) findViewById(R.id.detail_iv);
    }
}
