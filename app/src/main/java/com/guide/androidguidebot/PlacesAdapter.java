package com.guide.androidguidebot;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

public class PlacesAdapter extends RecyclerView.Adapter<VisitedPlacesViewHolder> {

    Context context;
    public PlacesAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public VisitedPlacesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.visited_places_item_layout, parent, false);
        VisitedPlacesViewHolder vH = new VisitedPlacesViewHolder(view);
        return vH;
    }

    @Override
    public void onBindViewHolder(@NonNull VisitedPlacesViewHolder holder, int position) {
        holder.titleTextView.setText(PlacesDataBase.PLACES[position].title);

        Glide
                .with(this.context)
                .load(PlacesDataBase.PLACES[position].imgPath)
                .into(holder.titleImageView);

        final VisitedPlaces visitedPlaces = PlacesDataBase.PLACES[position];
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startMovieAtivity(visitedPlaces);
            }
        });
    }
    private void startMovieAtivity(VisitedPlaces movie) {
        Intent intent = new Intent(context, PlaceDescription.class);
        intent.putExtra("MOVIE", movie);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return PlacesDataBase.PLACES.length;
    }
}
