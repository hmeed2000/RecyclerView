package com.example.recyclerview;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarRVAdapter extends RecyclerView.Adapter<CarRVAdapter.CarViewHolder> {
    private ArrayList<Car> cars;
    public CarRVAdapter(ArrayList<Car> cars){
        this.cars = cars;

    }


    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_car_layout,null,false);
        CarViewHolder viewHolder = new CarViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
        Car c = cars.get(position);
        if (c.getImage()!= null && !c.getImage().isEmpty())
        holder.imageView.setImageURI(Uri.parse(c.getImage()));
        holder.tv_model.setText(c.getModel());
        holder.tv_color.setText(c.getColor());
        holder.tv_dpl.setText(String.valueOf(c.getDpl()));

    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    class CarViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView tv_model,tv_color,tv_dpl;


        public CarViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.custom_car_iv);
            tv_model = itemView.findViewById(R.id.custom_car_tv_model);
            tv_color = itemView.findViewById(R.id.custom_car_tv_color);
           tv_dpl= itemView.findViewById(R.id.custom_car_tv_dpl);



        }
    }
}
