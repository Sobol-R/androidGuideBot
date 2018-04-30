package com.guide.androidguidebot;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import static com.bumptech.glide.request.RequestOptions.centerCropTransform;
import static com.bumptech.glide.request.RequestOptions.fitCenterTransform;

/**
 * Created by rosti on 24.04.2018.
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryViewHolder> {
    Context context;

    public GalleryAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.fragment_gallery, parent, false);
        GalleryViewHolder vH = new GalleryViewHolder(view);
        return vH;
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
        Glide
                .with(this.context)
                .load(PlacesDataBase.PLACES.get(position).imgPath)
                .apply(fitCenterTransform())
                .apply(centerCropTransform())
                .into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return PlacesDataBase.PLACES.size();
    }
}
