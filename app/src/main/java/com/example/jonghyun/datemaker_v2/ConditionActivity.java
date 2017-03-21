package com.example.jonghyun.datemaker_v2;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class ConditionActivity extends AppCompatActivity {
    Button cond_btn_summary;
    SeekBar cond_sb;
    CheckBox cond_cbox_budget, cond_cbox_time;
    TimePicker cond_tp_start, cond_tp_end;
    TextView tv_selected;
    int minimum, budgetValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_condition);
        getSupportActionBar().setTitle("Detail");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        minimum = budgetValue = 500;

        cond_btn_summary = (Button) findViewById(R.id.cond_btn_summary);
        cond_sb = (SeekBar) findViewById(R.id.cond_sb);
        cond_cbox_budget = (CheckBox) findViewById(R.id.cond_cbox_budget);
        cond_cbox_time = (CheckBox) findViewById(R.id.cond_cbox_time);
        cond_tp_start = (TimePicker) findViewById(R.id.cond_tp_start);
        cond_tp_end = (TimePicker) findViewById(R.id.cond_tp_end);
        tv_selected = (TextView) findViewById(R.id.tv_selected);
        cond_sb.setMax(5000);
        cond_sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress <= minimum){
                    progress = progress+minimum;
                }
                tv_selected.setText("Chosen Budget: PHP "+progress);
                budgetValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        cond_btn_summary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hourS, minuteS, hourE, minuteE = 0;
                if (Build.VERSION.SDK_INT >= 23 ) {
                    hourS = cond_tp_start.getHour();
                    minuteS = cond_tp_start.getMinute();
                    hourE = cond_tp_end.getHour();
                    minuteE = cond_tp_end.getMinute();
                }
                else {
                    hourS = cond_tp_start.getCurrentHour();
                    minuteS = cond_tp_start.getCurrentMinute();
                    hourE = cond_tp_end.getCurrentHour();
                    minuteE = cond_tp_end.getCurrentMinute();
                }
                Intent i = new Intent(ConditionActivity.this, ResultActivity.class);
                i.putExtra("budget", budgetValue);
                i.putExtra("hourS", hourS );
                i.putExtra("minuteS", minuteS);
                i.putExtra("hourE", hourE);
                i.putExtra("minuteE", minuteE);

                ConditionActivity.this.startActivity(i);
            }
        });
    }
}
