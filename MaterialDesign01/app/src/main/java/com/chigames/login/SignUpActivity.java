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

public class SignUpActivity extends AppCompatActivity
{
    public EditText emailET;
    public EditText passwordET;
    public EditText nameET;
    public CheckBox termsCB;
    public ImageButton signUpButton;
    public Toolbar toolbar;
    public Button signInButton;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_activity);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_forward_black_24dp);


        emailET = findViewById(R.id.email_et);
        passwordET = findViewById(R.id.password_et);
        nameET = findViewById(R.id.name_et);
        termsCB = findViewById(R.id.terms_cb);
        signInButton = findViewById(R.id.signin_button);
        signUpButton = findViewById(R.id.signup_imgbtn);

        signInButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(SignUpActivity.this, "Sign Up Button Clicked", Toast.LENGTH_LONG).show();
            }
        });

        signInButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent signInIntent = new Intent(SignUpActivity.this, SignInActivity.class);
                startActivity(signInIntent);
            }
        });





    }
}
