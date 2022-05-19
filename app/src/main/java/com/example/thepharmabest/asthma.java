package com.example.thepharmabest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class asthma extends AppCompatActivity {

    ImageButton back;
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asthma);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        back=(ImageButton)findViewById(R.id.imageButtonback);
        t1=(TextView)findViewById(R.id.hAsthma);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(asthma.this, Abtn.class);
                startActivity(intent);
            }
        });

    }
}