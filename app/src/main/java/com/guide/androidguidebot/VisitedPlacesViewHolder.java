package com.guide.androidguidebot;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.guide.androidguidebot.R;

public class VisitedPlacesViewHolder extends RecyclerView.ViewHolder {

    View itemView;
    TextView titleTextView;
    ImageView titleImageView;

    public VisitedPlacesViewHolder(View itemView) {
        super(itemView);

        this.itemView = itemView;

        titleTextView = itemView.findViewById(R.id.title);
        titleImageView = itemView.findViewById(R.id.image);

    }
}
