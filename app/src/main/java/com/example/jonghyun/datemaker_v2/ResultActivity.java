package com.example.jonghyun.datemaker_v2;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Parcelable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import com.google.firebase.FirebaseException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ResultActivity extends AppCompatActivity {
    static final String TAG = "ResultActivity";
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
        ArrayList<String> title = new ArrayList<String>();
        ArrayList<String> openTime = new ArrayList<String>();
        ArrayList<String> closeTime = new ArrayList<String>();
        ArrayList<String> city = new ArrayList<String>();
        ArrayList<String> address = new ArrayList<String>();
        ArrayList<String> cuisine = new ArrayList<String>();
        ArrayList<Integer> budgets = new ArrayList<Integer>();
        ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference(); // gets root
        //DatabaseReference ref = database.getReference().child("Recreation"); // gets recreation list
        //DatabaseReference ref = database.getReference().child("Recreation");

        //get the extras from the ConditionActivity.java
        int flag = i.getIntExtra("flag", 0);
        int budget = i.getIntExtra("startbudget", 499);
        int start = i.getIntExtra("starthour",99);
        restaurants = i.getParcelableArrayListExtra("recreations");

        if(flag == 0) {
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    ArrayList<Restaurant> rests = new ArrayList<Restaurant>();
                    Log.i(TAG, "Magic: The Gathering: " + dataSnapshot.getChildrenCount());
                    for (DataSnapshot ChildrenA: dataSnapshot.getChildren()) {
                        for (DataSnapshot ChildrenB: ChildrenA.getChildren()) {
                            for (DataSnapshot ChildrenC: ChildrenB.getChildren()) {
                                rests.add(ChildrenC.getValue(Restaurant.class));
                                Log.i(TAG, "Magic IT WORKS ARIEL 7.50" + ChildrenC.getValue().toString());
                            }
                        }
                    }
                    Intent j = new Intent(ResultActivity.this, ResultActivity.class);
                    j.putParcelableArrayListExtra("recreations", rests);
                    j.putExtra("flag", 1);
                    ResultActivity.this.startActivity(j);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
        else if(flag == 1){
            //hard coded shit. should be channged once firebase is implemented!
            ArrayList<Idea> ideas = new ArrayList<Idea>();
            Random ran = new Random();
            int num1, num2, num3, num4, num5, num6;
            num1 = ran.nextInt(restaurants.size());
            num2 = ran.nextInt(restaurants.size());
            num3 = ran.nextInt(restaurants.size());
            num4 = ran.nextInt(restaurants.size());
            num5 = ran.nextInt(restaurants.size());
            num6 = ran.nextInt(restaurants.size());
            for(int ctr = 0; ctr < restaurants.size(); ctr++) {
                ideas.add(new Idea(restaurants.get(ctr).getTitle(), restaurants.get(ctr).getOpenTime(), restaurants.get(ctr).getCloseTime(), restaurants.get(ctr).getCity(), restaurants.get(ctr).getAddress(), restaurants.get(ctr).getBudget(), restaurants.get(ctr).getCuisine()));
            }
            if(ideas.size() < 3) {
                ideas.add(new Idea("Yabu","12:00","22:00","Makati City","Glorietta 5, Ayala Center, Makati, 1224 Metro Manila",800, "Japanese"));
                ideas.add(new Idea("Glorietta","test","test","test","Glorietta, Makati City",250, "One of the popular malls in the Philippines"));
                ideas.add(new Idea("Mystery Manila","13:00","22:00","Makati City","Jupiter Street, Makati",1000, "Thriller"));
            }
            //Idea r1 = new Idea("Mystery Manila","13:00","22:00","Makati City","Jupiter Street, Makati",1000, "Thriller");
            //Idea r2 = new Idea("Glorietta","test","test","test","Glorietta, Makati City",250, "One of the popular malls in the Philippines");
            //Each Resto/Rec must be converted to an idea then each date plan must be converted to Plan. Then all Plans will be stored in an arraylist of plans :D
            //A plan is basically 2 - 3 Ideas i.e. resto or rec
            Plan p = new Plan(ideas.get(num1), ideas.get(num2), ideas.get(num3));
            ArrayList<Plan> plans = new ArrayList<>();
            plans.add(p);
            p = new Plan(ideas.get(num4), ideas.get(num5), ideas.get(num6));
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
}
