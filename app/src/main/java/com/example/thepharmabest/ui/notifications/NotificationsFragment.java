package com.example.thepharmabest.ui.notifications;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.thepharmabest.Home;
import com.example.thepharmabest.R;
import com.example.thepharmabest.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {

    ImageButton back;
    Activity table;

    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel = new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textNotifications;
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        table=getActivity();
        return root;
    }

    public void onStart() {
        super.onStart();

        Spinner spinnerLanguages=table.findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(table, R.array.languages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerLanguages.setAdapter(adapter);

        back=(ImageButton)table.findViewById(R.id.imageButtonback);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(table, Home.class);
                startActivity(intent);
            }
        });
        }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}