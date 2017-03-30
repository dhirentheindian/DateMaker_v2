package com.example.jonghyun.datemaker_v2;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ResultActivity extends AppCompatActivity {

    RecyclerView rv_resultactivity;
    RecyclerView.LayoutManager layoutManager;
    ResultAdapter adapter;
    Plan currentSelectedPlan = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getSupportActionBar().setTitle("Result");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent i = getIntent();

        //get the extras from the ConditionActivity.java
        int budget = i.getIntExtra("budget",499);
        int start = i.getIntExtra("starthour",99);

        //hard coded shit. should be channged once firebase is implemented!
        Idea r = new Idea("Yabu","12:00","22:00","Makati City","Glorietta 5, Ayala Center, Makati, 1224 Metro Manila",800, "Japanese");
        Idea r1 = new Idea("Mystery Manila","13:00","22:00","Makati City","Jupiter Street, Makati",1000, "Thriller");
        Idea r2 = new Idea("Glorietta","test","test","test","Glorietta, Makati City",250, "One of the popular malls in the Philippines");
        //Each Resto/Rec must be converted to an idea then each date plan must be converted to Plan. Then all Plans will be stored in an arraylist of plans :D
        //A plan is basically 2 - 3 Ideas i.e. resto or rec
        Plan p = new Plan(r,r1,r2);
        ArrayList<Plan> plans = new ArrayList<>();
        plans.add(p);
        p = new Plan(r2,r1,r);
        plans.add(p);

        rv_resultactivity = (RecyclerView) findViewById(R.id.rv_resultactivity);
        layoutManager = new LinearLayoutManager(this);
        rv_resultactivity.setLayoutManager(layoutManager);

        adapter = new ResultAdapter(plans);
        adapter.setOnPlanClickListener(new ResultAdapter.OnPlanClickListener() {
            @Override
            public void onPlanClick(View view, Plan t) {
                //This is what will be used to transfer to PlanActivity.java
                //Implement a way to send the Plan object to the next activity. Parcelable.

                Intent i = new Intent(ResultActivity.this, PlanActivity.class);
                Bundle bundlebee = new Bundle();
                bundlebee.putParcelableArrayList("plan",t.getParcelableArrayList());
                i.putExtras(bundlebee);
                startActivity(i);
            }
        });
        rv_resultactivity.setAdapter(adapter);


    }
}
