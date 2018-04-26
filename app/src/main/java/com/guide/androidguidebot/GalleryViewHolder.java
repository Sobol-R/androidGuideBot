package com.guide.androidguidebot;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by rosti on 24.04.2018.
 */

public class GalleryViewHolder extends RecyclerView.ViewHolder {

    View itemView;
    ImageView mImageView;

    public GalleryViewHolder(View itemView) {
        super(itemView);

        this.itemView = itemView;

        mImageView = itemView.findViewById(R.id.mImageView);
    }
}
