package com.guide.androidguidebot;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static com.bumptech.glide.request.RequestOptions.centerCropTransform;
import static com.bumptech.glide.request.RequestOptions.fitCenterTransform;

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
    public void onBindViewHolder(@NonNull VisitedPlacesViewHolder holder, final int position) {
        holder.titleTextView.setText(PlacesDataBase.PLACES.get(position).title);

        Glide
                .with(this.context)
                .load(PlacesDataBase.PLACES.get(position).imgPath)
                .apply(fitCenterTransform())
                .apply(centerCropTransform())
                .into(holder.titleImageView);

        final VisitedPlaces visitedPlaces = PlacesDataBase.PLACES.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startDescriptionAtivity(visitedPlaces, position);
            }
        });
    }
    private void startDescriptionAtivity(VisitedPlaces visitedPlaces, int position) {
        Intent intent = new Intent(context, PlaceDescription.class);
        intent.putExtra("position", position);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return PlacesDataBase.PLACES.size();
    }
}
