package com.sayeedul.intentlogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener{

    Button signup;
    EditText userEdt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_main);

        signup = (Button)findViewById(R.id.signUP);
        userEdt = (EditText)findViewById(R.id.usernameTV);

        signup.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        String userName = userEdt.getText().toString();

        Toast.makeText(this,"PLEASE WAIT.....",Toast.LENGTH_SHORT).show();

        Intent i = new Intent(RegistrationActivity.this,LoginActivity.class);
        i.putExtra("username",userName);
        startActivity(i);
    }
}
