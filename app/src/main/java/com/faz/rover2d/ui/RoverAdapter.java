package com.faz.rover2d.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.faz.rover2d.R;
import com.faz.rover2d.data.network.model.PointModel;
import com.faz.rover2d.data.network.model.RoverBehaviorResponse;


public class RoverAdapter extends RecyclerView.Adapter<RoverAdapter.MyViewHolder> {

    private Context _context;
    private RoverBehaviorResponse _result;

    public RoverAdapter(Context context, RoverBehaviorResponse result) {

        _context = context;
        _result = result;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        MyViewHolder(View v) {
            super(v);
            textView = itemView.findViewById(R.id.textView);
        }
    }

    @NonNull
    @Override
    public RoverAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                        int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rover_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        try {
            int y = position / 10;
            int x = position % 10;
            if(x == _result.getStart_point().getX() && y == _result.getStart_point().getY()){
                holder.textView.setText("^");
            } else {
                for (PointModel point:_result.getWeirs()) {
                    if(x ==point.getX() && y== point.getY()){
                        holder.textView.setText("#");
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return 200;
    }
}