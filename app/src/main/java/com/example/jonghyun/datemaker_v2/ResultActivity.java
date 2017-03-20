package com.example.jonghyun.datemaker_v2;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    ArrayList<Place> restaurant, activity;
    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getSupportActionBar().setTitle("Result");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tabLayout = (TabLayout) findViewById(R.id.result_tab);
        tabLayout.addTab(tabLayout.newTab().setText("Restaurant"));
        tabLayout.addTab(tabLayout.newTab().setText("Activity"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        restaurant = new ArrayList<>();
        activity = new ArrayList<>();

        // INSTANT DATA INSERTION
        restaurant.add(new Place(1, "mcdo", "everywhere", "100"));
        restaurant.add(new Place(2, "mcdo", "everywhere", "100"));
        restaurant.add(new Place(3, "mcdo", "everywhere", "100"));
        restaurant.add(new Place(4, "mcdo", "everywhere", "100"));
        restaurant.add(new Place(5, "mcdo", "everywhere", "100"));

        activity.add(new Place(1, "Jolibee", "near mcdo", "100"));
        activity.add(new Place(2, "Jolibee", "near mcdo", "100"));
        activity.add(new Place(3, "Jolibee", "near mcdo", "100"));
        activity.add(new Place(4, "Jolibee", "near mcdo", "100"));
        activity.add(new Place(5, "Jolibee", "near mcdo", "100"));

        viewPager = (ViewPager) findViewById(R.id.result_pager);
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount(), restaurant, activity));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
