package com.aviator.festa;

import android.os.Bundle;
import com.google.android.material.textfield.TextInputEditText;
import android.widget.TextView;

import com.aviator.festa.abstracts.BaseActivity;

import spencerstudios.com.bungeelib.Bungee;

public class Auth extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        // TODO: 8/1/2019
        initViews();
        Initialize();

    }

    private TextInputEditText email;
    private TextInputEditText password;
    private TextView loginBtn;
    private TextView forgottenPassword;

    public void initViews() {
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        loginBtn = findViewById(R.id.login_btn);
        forgottenPassword = findViewById(R.id.forgotten_password);
    }


    @Override
    public void Initialize() {
        loginBtn.setOnClickListener(v -> {
            finish();
            NextActivity(AddEvent.class);
            Bungee.swipeLeft(Auth.this);
        });
    }


}
