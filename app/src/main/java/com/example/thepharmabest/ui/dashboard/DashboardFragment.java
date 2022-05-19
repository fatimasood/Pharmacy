package com.example.thepharmabest.ui.dashboard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.thepharmabest.Abtn;
import com.example.thepharmabest.Bbtn;
import com.example.thepharmabest.Home;
import com.example.thepharmabest.R;
import com.example.thepharmabest.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {
    Button btna,btnb,btnc,btnd,btne;

    ImageButton back;
    Activity table;

    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

       /* Spinner spinner= requireActivity().findViewById(R.id.spinner1);      //object for spinner
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this.getActivity(),R.array.languages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);*/

        table=getActivity();
        final TextView textView = binding.dash;
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    public void onStart() {
        super.onStart();

        back=(ImageButton)table.findViewById(R.id.imageButtonback);

        btna=(Button)table.findViewById(R.id.btnA);
        btnb=(Button)table.findViewById(R.id.btnB);
        btnc=(Button)table.findViewById(R.id.btnC);
        btnd=(Button)table.findViewById(R.id.btnD);
        btne=(Button)table.findViewById(R.id.btnE);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(table, Home.class);
                startActivity(intent);
            }
        });

        btna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(table, Abtn.class);
                startActivity(intent);
            }
        });

        btnb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(table, Bbtn.class);
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