package com.example.thepharmabest;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Animation animRotate,animInter;
    ImageView loading,logo;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        logo=(ImageView) findViewById(R.id.logop);     //register
        loading=(ImageView) findViewById(R.id.loadpic);

        animInter= AnimationUtils.loadAnimation(MainActivity.this,R.anim.interpolator);     //animation on logo
        logo.setAnimation(animInter);


        loading.setOnClickListener(new View.OnClickListener() {       //animation
            @Override
            public void onClick(View view) {
                animRotate= AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotate);
                loading.startAnimation(animRotate);
                loading.setVisibility(View.VISIBLE);
            }
        });

        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,login.class);
                startActivity(intent);
                finish();
            }
        },6000);

    }
}