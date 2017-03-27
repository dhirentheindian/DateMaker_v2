package com.example.jonghyun.datemaker_v2;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Deran on 3/27/2017.
 */

public class PlanAdapter extends RecyclerView.Adapter<PlanAdapter.PlanViewHolder> {
    ArrayList<Idea> ideas;
    Idea temp, tempPrev;
    int positionp;
    public PlanAdapter(ArrayList<Idea> ideas) {
        this.ideas = ideas;
    }

    public class PlanViewHolder extends RecyclerView.ViewHolder{

        TextView tv_title, tv_openTime, tv_closeTime;
        Button btn_getDirections;
        public PlanViewHolder(View itemView)
        {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_openTime= (TextView) itemView.findViewById(R.id.tv_openTime);
            tv_closeTime = (TextView) itemView.findViewById(R.id.tv_closeTime);
            btn_getDirections = (Button) itemView.findViewById(R.id.btn_getDirections);

        }
    }

    @Override
    public PlanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout,parent, false);
        return new PlanViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PlanViewHolder holder, int position) {
        temp = ideas.get(position);
        positionp = position;
        if(position != 0){
            tempPrev = ideas.get(position-1);
        }
        holder.tv_title.setText("Place: " + temp.getTitle());
        holder.tv_openTime.setText("Open Time:" + temp.getOpenTime());
        holder.tv_closeTime.setText("Close Time:" + temp.getCloseTime());

        holder.btn_getDirections.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), positionp, Toast.LENGTH_SHORT).show();
                Geocoder geo = new Geocoder(v.getContext());
                List<Address> result;
                List<Address> resultPrev;
                try {
                    result = geo.getFromLocationName(temp.getAddress(), 1);
                    resultPrev = geo.getFromLocationName(tempPrev.getAddress(), 1);

                    Toast.makeText(v.getContext(),temp.getAddress(), Toast.LENGTH_SHORT).show();

                    double lat = result.get(0).getLatitude();
                    double lng = result.get(0).getLongitude();
                    double prevLat = resultPrev.get(0).getLatitude();
                    double prevLong = resultPrev.get(0).getLongitude();

                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                            Uri.parse("http://maps.google.com/maps?saddr="+prevLat+","+prevLong+"&daddr="+lat+","+lng));
                    v.getContext().startActivity(intent);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return ideas.size();
    }

}
