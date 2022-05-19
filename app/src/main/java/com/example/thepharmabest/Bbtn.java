package com.example.thepharmabest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thepharmabest.ui.dashboard.DashboardFragment;

public class Bbtn extends AppCompatActivity {

    TextView heaB,b1,b2;
    ImageButton backB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbtn);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        backB=(ImageButton)findViewById(R.id.imageButtonbackB) ;
        heaB=(TextView) findViewById(R.id.Bhea);
        b1=(TextView) findViewById(R.id.B_1);
        b2=(TextView) findViewById(R.id.B_2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bbtn.this, bloodClot.class);
                startActivity(intent);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bbtn.this,infection.class);
                startActivity(intent);
            }
        });

        backB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bbtn.this, DashboardFragment.class);
                startActivity(intent);
            }
        });
    }
}