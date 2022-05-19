package com.example.thepharmabest;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {

    ImageButton google,apple,fb;
    TextView twlcm,tacnt,tmail,tpswrd,textrasup;
    EditText mail,pswrd;
    CheckBox check;
    Button bterms,bsignup;

    private ProgressBar progressbar;
    View progressBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        // taking instance of FirebaseAuth
        mAuth = FirebaseAuth.getInstance();

        google=findViewById(R.id.googlebtn);
        apple=findViewById(R.id.apple_btn);
        fb=findViewById(R.id.fb_btn);

        mail=findViewById(R.id.mail);
        pswrd=findViewById(R.id.Password);

        check=findViewById(R.id.checkBox);

        bterms=findViewById(R.id.terms);
        bsignup=findViewById(R.id.btn_sign_up);

        twlcm=findViewById(R.id.welcome);
        tacnt=findViewById(R.id.signuphead);
        tmail=findViewById(R.id.hmail);
        tpswrd=findViewById(R.id.hpswrd);
        textrasup=findViewById(R.id.msg);

        bterms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(signup.this, termsClass.class);
                startActivity(intent);
            }
        });

        // Set on Click Listener on Signup button
        bsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                registerNewUser();
            }
        });
    }


    private void registerNewUser() {

        // show the visibility of progress bar to show loading
         //progressbar.setVisibility(View.VISIBLE);

        // Take the value of two edit texts in Strings
        String email, password;
        email = mail.getText().toString();
        password = pswrd.getText().toString();

        // Validations for input email and password
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(),
                    "Please enter email!!",
                    Toast.LENGTH_LONG)
                    .show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(),
                    "Please enter password!!",
                    Toast.LENGTH_LONG)
                    .show();
            return;
        }

        // create new user or register new user
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Registration successful!", Toast.LENGTH_LONG).show();

                             //hide the progress bar
                           //  progressBar.setVisibility(View.GONE);

                            // if the user created intent to login activity
                            Intent intent = new Intent(signup.this, Home.class);
                            startActivity(intent);
                        } else {

                            // Registration failed
                            Toast.makeText(
                                    getApplicationContext(), "Registration failed!!" + " Please try again later", Toast.LENGTH_LONG).show();

                            // hide the progress bar
                             //progressBar.setVisibility(View.GONE);
                        }
                    }
                });
          }
    }