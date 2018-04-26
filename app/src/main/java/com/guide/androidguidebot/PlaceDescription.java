package com.guide.androidguidebot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import static com.bumptech.glide.request.RequestOptions.centerCropTransform;
import static com.bumptech.glide.request.RequestOptions.fitCenterTransform;

public class PlaceDescription extends AppCompatActivity {
    TextView title;
    ImageView img;
    TextView descriptionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_description);

        title = findViewById(R.id.title2);
        //img = findViewById(R.id.image2);
        descriptionText = findViewById(R.id.textDescription);

        int position;

        position = getIntent().getExtras().getInt("position");

        VisitedPlaces visitedPlaces = PlacesDataBase.PLACES[position];

        title.setText(visitedPlaces.title);

//        Glide
//                .with(this)
//                .load(PlacesDataBase.PLACES[position].imgPath)
//                .apply(fitCenterTransform())
//                .apply(centerCropTransform())
//                .into(img);

        descriptionText.setText(visitedPlaces.description);
    }
}
