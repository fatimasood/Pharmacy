package com.example.thepharmabest;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class login extends AppCompatActivity {

    TextView signin, hmail, hpswrd, sup;
    EditText pswrd, mail;
    Button bforgot,btnsin, btnsup;

    FirebaseAuth fAuth;

    CheckBox rem;
    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;
    private Boolean saveLogin;
    private String username,password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        fAuth = FirebaseAuth.getInstance();

        signin = findViewById(R.id.signin);
        hmail = findViewById(R.id.hmail);
        hpswrd = findViewById(R.id.hpswrd);
        bforgot = findViewById(R.id.textView4);
        sup = findViewById(R.id.btm_msg);

        pswrd = findViewById(R.id.Password);
        mail = findViewById(R.id.mail);

        rem = findViewById(R.id.checkBox);

        btnsin = findViewById(R.id.btn_sign_in);
        btnsup = findViewById(R.id.signup);

        btnsin.setOnClickListener(view -> {
            loginUser();
        });

        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();

        saveLogin = loginPreferences.getBoolean("saveLogin", false);
        if (saveLogin == true) {
            mail.setText(loginPreferences.getString("mail", ""));
            pswrd.setText(loginPreferences.getString("password", ""));
            rem.setChecked(true);
        }

        btnsup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this, signup.class);
                startActivity(intent);
            }
        });

    }

        public void onClick (View view){
            if (view == btnsin) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mail.getWindowToken(), 0);

                username = mail.getText().toString();
                password = pswrd.getText().toString();

                if (rem.isChecked()) {
                    loginPrefsEditor.putBoolean("saveLogin", true);
                    loginPrefsEditor.putString("mail", username);
                    loginPrefsEditor.putString("password", password);
                    loginPrefsEditor.commit();
                } else {
                    loginPrefsEditor.clear();
                    loginPrefsEditor.commit();
                }

                doSomethingElse();
            }
        }

        public void doSomethingElse () {
            startActivity(new Intent(login.this, Home.class));
            login.this.finish();
        }



        private void loginUser() {
            String email=mail.getText().toString();
            String password=pswrd.getText().toString();

            if(TextUtils.isEmpty(email)){
                mail.setError("Mail may not be Empty");
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
            }
            else if(TextUtils.isEmpty(password)){
                pswrd.setError("Password is necessary");
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
            }
            else
            {
                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(login.this, "login Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(login.this, Home.class));
                            login.this.finish();
                        }
                        else
                        {
                            Toast.makeText(login.this, "login Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

     }

    }