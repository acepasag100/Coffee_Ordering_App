package com.example.coffeeorderingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder>{

    List<Model> modelList;
    Context context;

    public OrderAdapter(List<Model> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.listitem, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String getCoffeeName = modelList.get(position).getmDrinkName();
        String getDescription = modelList.get(position).getmDrinkDetail();
        int getImage = modelList.get(position).getmDrinkPhoto();

        holder.coffeeName.setText(getCoffeeName);
        holder.coffeeDescription.setText(getDescription);
        holder.coffeeImage.setImageResource(getImage);
    }

    @Override
    public int getItemCount()
    {
        return modelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView coffeeName, coffeeDescription;
        ImageView coffeeImage;

        public ViewHolder(View itemView) {
            super(itemView);
            coffeeName = itemView.findViewById(R.id.coffeeName);
            coffeeDescription = itemView.findViewById(R.id.coffeeDescription);
            coffeeImage = itemView.findViewById(R.id.coffeeImage);
        }
    }
}
