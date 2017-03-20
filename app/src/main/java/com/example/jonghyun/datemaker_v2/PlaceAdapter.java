package com.example.jonghyun.datemaker_v2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by JongHyun on 2017-03-19.
 */

class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder> {
    private ArrayList<Place> data;
    private OnItemClickListener onItemClickListener;

    public PlaceAdapter(ArrayList<Place> data) {
        this.data = data;
    }

    @Override
    public PlaceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_place, parent, false);
        return new PlaceViewHolder(v);
    }

    public void setOnClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        public void onItemClick(int placeID);
    }

    @Override
    public void onBindViewHolder(PlaceViewHolder holder, int position) {
        Place temp = data.get(position);

        holder.place_tv_name.setText(temp.getsName());
        holder.place_tv_price.setText(temp.getsPrice());

        holder.place_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(1); // HOW TO USE TEMP's ID
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class PlaceViewHolder extends RecyclerView.ViewHolder{
        ImageView place_iv;
        TextView place_tv_name, place_tv_price, place_tv_location;
        LinearLayout place_layout;

        public PlaceViewHolder(View itemView)
        {
            super(itemView);
            place_iv = (ImageView) itemView.findViewById(R.id.place_iv);
            place_tv_name = (TextView) itemView.findViewById(R.id.place_tv_name);
            place_tv_price = (TextView) itemView.findViewById(R.id.place_tv_price);
            place_tv_location = (TextView) itemView.findViewById(R.id.place_tv_location);
            place_layout = (LinearLayout) itemView.findViewById(R.id.place_layout);
        }
    }
}
