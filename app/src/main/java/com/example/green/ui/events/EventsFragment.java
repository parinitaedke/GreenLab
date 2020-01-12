package com.example.green.ui.events;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.green.EventAdapter;
import com.example.green.R;
import com.example.green.StoreAdapter;

public class EventsFragment extends Fragment {

    private EventViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(EventViewModel.class);
        View root = inflater.inflate(R.layout.fragment_events, container, false);
        RecyclerView recyclerView = root.findViewById(R.id.events);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        // get sorted list of events
//        EventAdapter eventAdapter = new EventAdapter();
//        recyclerView.setAdapter(eventAdapter);
        return root;
    }
}