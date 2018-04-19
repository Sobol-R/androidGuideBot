package com.guide.androidguidebot;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDialogFragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

import static com.guide.androidguidebot.R.id.recycler_view;

public class VisitedPlacesFragment extends Fragment {
    public VisitedPlacesFragment() {
        ///////////////////////////
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Context context = getContext();

        PlacesAdapter adapter = new PlacesAdapter(context);

        RecyclerView recyclerView = (RecyclerView) getActivity().findViewById(R.id.recycler_view);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setLayoutManager(new GridLayoutManager(context, 1));
        return inflater.inflate(R.layout.visited_places_layout, container, false);
    }
}
