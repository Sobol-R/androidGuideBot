package com.guide.androidguidebot;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class VisitedPlacesFragment extends Fragment {
    public VisitedPlacesFragment() {
        ///////////////////////////
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View fragmentView = inflater.inflate(R.layout.visited_places_fragment_layout, container, false);

        Context context = getContext();

        PlacesAdapter adapter = new PlacesAdapter(context);

        RecyclerView recyclerView = (RecyclerView) fragmentView.findViewById(R.id.recycler_view);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setLayoutManager(new GridLayoutManager(context, 1));
        return fragmentView;
    }
}
