package com.chigames.responsiveloginui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{

    private Button signUpBtn;
    private Button learnMoreBtn;
    private Button loginBtn;
    private TextView forgotTV;
    private TextInputEditText emailET;
    private TextInputEditText passwordET;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signUpBtn = findViewById(R.id.sign_up_btn);
        learnMoreBtn = findViewById(R.id.learn_more_btn);
        loginBtn = findViewById(R.id.login_btn);
        forgotTV = findViewById(R.id.forgot_tv);
        emailET = findViewById(R.id.email_et);
        passwordET = findViewById(R.id.password_et);


        signUpBtn.setOnClickListener(view -> signUpClicked());
        learnMoreBtn.setOnClickListener(view -> learnMoreClicked());
        loginBtn.setOnClickListener(view -> loginClicked());
        forgotTV.setOnClickListener(view -> forgotClicked());

    }

    private void signUpClicked()
    {
        Toast.makeText(this, "Sign Up Pressed", Toast.LENGTH_LONG).show();
    }

    private void learnMoreClicked()
    {
        Toast.makeText(this, "Learn MorebPressed", Toast.LENGTH_LONG).show();
    }

    private void loginClicked()
    {
        Toast.makeText(this, "Login Pressed", Toast.LENGTH_LONG).show();
    }
    private void forgotClicked()
    {
        Toast.makeText(this, "forgot Password Pressed", Toast.LENGTH_LONG).show();
    }

}
