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
        ArrayList<Restaurant> restaurants;
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference(); // gets root
        //DatabaseReference ref = database.getReference().child("Recreation"); // gets recreation list

        //get the extras from the ConditionActivity.java
        final int budget = i.getIntExtra("budget", 499);
        final int start = i.getIntExtra("starthour",99);
        Log.i(TAG, "Starting budget is" + budget);
        //checker whether it went here again yet or not
        int flag = i.getIntExtra("flag", 0);
        restaurants = i.getParcelableArrayListExtra("recreations"); // first run this would be null

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
                    j.putExtra("budget", budget);
                    j.putExtra("starthour", start);
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
            ArrayList<Plan> plans = new ArrayList<>();
            ArrayList<Idea> ideas = new ArrayList<>();
            int totalBudget;
            Random ran = new Random();
            for(int ctr = 0; ctr < restaurants.size(); ctr++) {
                totalBudget = budget;
                Log.i(TAG, "Budget is " + totalBudget);
                for(int ctr2 = ctr+1; ctr2 < restaurants.size(); ctr2++) {
                    if(ctr+1 == ctr2 && restaurants.get(ctr).getBudget() <= totalBudget) {
                        ideas.add(new Idea(restaurants.get(ctr).getTitle(), restaurants.get(ctr).getOpenTime(), restaurants.get(ctr).getCloseTime(), restaurants.get(ctr).getCity(), restaurants.get(ctr).getAddress(), restaurants.get(ctr).getBudget(), restaurants.get(ctr).getCuisine()));
                        totalBudget -= restaurants.get(ctr).getBudget();
                    }
                    else if (restaurants.get(ctr2).getBudget() <= totalBudget) {
                        ideas.add(new Idea(restaurants.get(ctr2).getTitle(), restaurants.get(ctr2).getOpenTime(), restaurants.get(ctr2).getCloseTime(), restaurants.get(ctr2).getCity(), restaurants.get(ctr2).getAddress(), restaurants.get(ctr2).getBudget(), restaurants.get(ctr2).getCuisine()));
                        totalBudget -= restaurants.get(ctr2).getBudget();
                    }
                }
                if(ideas.size() >= 3) {
                    plans.add(new Plan(ideas.get(0), ideas.get(1), ideas.get(2)));
                }
                ideas.clear();
            }
            if(plans.isEmpty()) {
                ideas.add(new Idea("Sad","12:00","22:00","Makati City","Glorietta 5, Ayala Center, Makati, 1224 Metro Manila",0, "Make iyak"));
                ideas.add(new Idea("Lakad nalang kayo sa park","13:00","22:00","Makati City","Jupiter Street, Makati",0, "Make lakad"));
                ideas.add(new Idea("You need to work bes","test","test","test","Glorietta, Makati City",0, "Make pera"));
                plans.add(new Plan(ideas.get(0), ideas.get(1), ideas.get(2)));
            }
            
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
