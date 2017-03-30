package com.example.jonghyun.datemaker_v2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class PlanActivity extends AppCompatActivity {

    RecyclerView rv_plan;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_plan);
         rv_plan = (RecyclerView) findViewById(R.id.rv_plan);

         layoutManager = new LinearLayoutManager(this);
         rv_plan.setLayoutManager(layoutManager);

         //gets the arraylist from resultactivity
         ArrayList<Idea> ideaList = getIntent().getParcelableArrayListExtra("plan");

         //displays the contents of arraylist
         adapter = new PlanAdapter(ideaList);
         rv_plan.setAdapter(adapter);

     }
}
