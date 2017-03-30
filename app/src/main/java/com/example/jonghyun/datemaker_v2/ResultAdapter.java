package com.example.jonghyun.datemaker_v2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Deran on 3/29/2017.
 */

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ResultViewHolder>{

    ArrayList<Plan> plans;
    OnPlanClickListener onPlanClickListener;
    public ResultAdapter(ArrayList<Plan> plans){
        this.plans = plans;
    }
    @Override
    public ResultAdapter.ResultViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.plancard_layout,parent, false);
        return new ResultAdapter.ResultViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ResultAdapter.ResultViewHolder holder, int position) {
        Plan p = plans.get(position);

        holder.tv_first.setText(p.getIdea1().getTitle());
        holder.tv_second.setText(p.getIdea2().getTitle());
        holder.tv_third.setText(p.getIdea3().getTitle());
        holder.tv_budget.setText("Total Cost is: PHP "+ p.getTotalBudget());
        holder.resultcardview.setTag(p);
        holder.resultcardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onPlanClickListener != null)
                    onPlanClickListener.onPlanClick(v, (Plan) v.getTag());
            }
        });
        //holder.currentPlan = p;
    }

    public interface OnPlanClickListener{
        public void onPlanClick(View view,  Plan t);
    }


    public OnPlanClickListener getOnPlanClickListener() {

        return onPlanClickListener;
    }

    public void setOnPlanClickListener(OnPlanClickListener onPlanClickListener) {
        this.onPlanClickListener = onPlanClickListener;
    }
    public class ResultViewHolder extends RecyclerView.ViewHolder{
        TextView tv_first, tv_second,tv_third, tv_budget;
        View resultcardview;
        public ResultViewHolder(View itemView){
            super(itemView);
            tv_first = (TextView) itemView.findViewById(R.id.tv_first);
            tv_second = (TextView) itemView.findViewById(R.id.tv_second);
            tv_third = (TextView) itemView.findViewById(R.id.tv_third);
            tv_budget = (TextView) itemView.findViewById(R.id.tv_result_cost);
            resultcardview = itemView.findViewById(R.id.resultcardview);
        }
    }
    //setOnItemClickListener whatebur

    @Override
    public int getItemCount() {
        return plans.size();
    }


}
