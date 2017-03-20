package com.example.jonghyun.datemaker_v2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TimePicker;

public class ConditionActivity extends AppCompatActivity {
    Button cond_btn_summary;
    SeekBar cond_sb;
    CheckBox cond_cbox_budget, cond_cbox_time;
    TimePicker cond_tp_start, cond_tp_end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_condition);
        getSupportActionBar().setTitle("Detail");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cond_btn_summary = (Button) findViewById(R.id.cond_btn_summary);
        cond_sb = (SeekBar) findViewById(R.id.cond_sb);
        cond_cbox_budget = (CheckBox) findViewById(R.id.cond_cbox_budget);
        cond_cbox_time = (CheckBox) findViewById(R.id.cond_cbox_time);
        cond_tp_start = (TimePicker) findViewById(R.id.cond_tp_start);
        cond_tp_end = (TimePicker) findViewById(R.id.cond_tp_end);

        cond_btn_summary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ConditionActivity.this, ResultActivity.class);
                ConditionActivity.this.startActivity(i);
            }
        });
    }
}
