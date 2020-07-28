package com.createsapp.roomdatabasewithretrofit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.createsapp.roomdatabasewithretrofit.R;
import com.createsapp.roomdatabasewithretrofit.model.Actor;

import java.util.List;

public class ActorAdapter extends RecyclerView.Adapter<ActorAdapter.ActorsViewHolder> {
    private Context context;
    private List<Actor> actorModels;

    public ActorAdapter(Context context, List<Actor> actorModels) {
        this.context = context;
        this.actorModels = actorModels;
    }

    @NonNull
    @Override
    public ActorsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ActorsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.each_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ActorsViewHolder holder, int position) {
        Actor actorModel = actorModels.get(position);
        holder.name.setText("Name : " + actorModel.getName());
        holder.id.setText("Id : " + actorModel.getId());
        holder.age.setText("Age : " + actorModel.getAge());
        Glide.with(context)
                .load(actorModel.getImage())
                .into(holder.imageView);
    }

    public void getAllActors(List<Actor> actorModels) {
        this.actorModels = actorModels;
    }

    @Override
    public int getItemCount() {
        return actorModels.size();
    }

    static class ActorsViewHolder extends RecyclerView.ViewHolder {
        public TextView id, name, age;
        public ImageView imageView;

        public ActorsViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            name = itemView.findViewById(R.id.name);
            age = itemView.findViewById(R.id.age);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}

