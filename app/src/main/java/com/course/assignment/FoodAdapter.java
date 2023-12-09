package com.course.assignment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {
    ArrayList<FoodItem> items = new ArrayList<FoodItem>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.food_cardview, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FoodItem item = items.get(position);
        holder.setItem(item);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(view.getContext(), Food.class);
                intent.putExtra("food_name", item.food_name);
                intent.putExtra("food_count", item.food_count);
                intent.putExtra("content", item.content);
                intent.putExtra("place", item.place);
                intent.putExtra("date", item.date);
                intent.putExtra("time", item.time);
                intent.putExtra("image", item.image);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void clear() {
        items = new ArrayList<FoodItem>();
    }

    public void addItem(FoodItem item) {
        items.add(item);
    }

    public ArrayList<FoodItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<FoodItem> items) {
        this.items = items;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView dateTextView, subjectTextView;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);

            dateTextView = itemView.findViewById(R.id.dateTextView);
            subjectTextView = itemView.findViewById(R.id.subjectTextView);
            cardView = itemView.findViewById(R.id.cardView);
        }

        public void setItem(FoodItem item) {
            dateTextView.setText(item.getDate());
            subjectTextView.setText(item.getFood_name());
        }
    }
}
