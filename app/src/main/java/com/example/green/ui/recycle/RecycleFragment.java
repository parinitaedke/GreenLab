package com.example.green.ui.recycle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.green.R;

public class RecycleFragment extends Fragment {
    private RecycleViewModel recycleViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        recycleViewModel = ViewModelProviders.of(this).get(RecycleViewModel.class);
        View root = inflater.inflate(R.layout.fragment_recycle, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);
        recycleViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
