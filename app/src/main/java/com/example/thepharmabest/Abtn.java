package com.example.thepharmabest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thepharmabest.ui.dashboard.DashboardFragment;

public class Abtn extends AppCompatActivity {
    TextView hea,a1,a2;
    ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abtn);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        back=(ImageButton)findViewById(R.id.imageButtonback) ;
        hea=(TextView) findViewById(R.id.Ahea);
        a1=(TextView) findViewById(R.id.A1);
        a2=(TextView) findViewById(R.id.A2);

        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Abtn.this, asthma.class);
                startActivity(intent);
            }
        });

        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Abtn.this,infection.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Abtn.this, DashboardFragment.class);
                startActivity(intent);
            }
        });

    }
}