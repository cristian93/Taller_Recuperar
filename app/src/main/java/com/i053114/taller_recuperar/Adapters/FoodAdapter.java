package com.i053114.taller_recuperar.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.i053114.taller_recuperar.MainActivity;
import com.i053114.taller_recuperar.Models.Food;
import com.i053114.taller_recuperar.R;
import com.i053114.taller_recuperar.Views.ListFood;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chris on 13/11/2017.
 */

//
public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {
    List<Food> foodList = new ArrayList<>();
    Context context;

    public FoodAdapter(List<Food> foodList, Context context) {
        this.foodList = foodList;
        this.context = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater .from(parent.getContext()).inflate(R.layout.itemfood, parent , false);
        ViewHolder viewHolder = new ViewHolder(item);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position)
    {
        holder.textViewName.setText(foodList.get(position).getName());
        holder.textViewprice.setText(foodList.get(position).getPrice());
        holder.textViewdescription.setText(foodList.get(position).getDescription());


    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewName;
        TextView textViewprice;
        TextView textViewdescription;


        public ViewHolder(View item) {
            super(item);

            item.setOnClickListener(this);

            textViewName = (TextView) item.findViewById(R.id.id_tv_item_name);
            textViewprice = (TextView) item.findViewById(R.id.id_tv_item_price);
            textViewdescription = (TextView) item.findViewById(R.id.id_tv_item_description);


        }


        @Override
        public void onClick(View view) {
            Context contextItem = view.getContext();


           Intent intent = new Intent(context, MainActivity.class);
            //intent.putExtra("id", Integer.toString(foodList.get(getLayoutPosition()).getId()));
            //intent.putExtra("name", foodList.get(getLayoutPosition()).getName());
           // intent.putExtra ("price", (foodList.get(getLayoutPosition()).getPrice()));
           // intent.putExtra("description", foodList.get(getLayoutPosition()).getDescription());
            contextItem.startActivity(intent);
        }
    }
}