package com.chigames.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity
{
    public EditText emailET;
    public EditText passwordET;
    public CheckBox termsCB;
    public ImageButton signInButton;
    public Toolbar toolbar;
    public Button signUpButton;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_forward_black_24dp);


        emailET = findViewById(R.id.email_et);
        passwordET = findViewById(R.id.password_et);
        termsCB = findViewById(R.id.remember_me_cb);
        signInButton = findViewById(R.id.signin_ibtn);
        signUpButton = findViewById(R.id.signup_btn);

        signInButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(SignInActivity.this, "Sign In Button Clicked", Toast.LENGTH_LONG).show();
                Intent intentSignUp = new Intent(SignInActivity.this, SignInActivity.class);
                startActivity(intentSignUp);
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intentSignUp = new Intent(SignInActivity.this,SignUpActivity.class);
                startActivity(intentSignUp);
            }
        });
    }
}
