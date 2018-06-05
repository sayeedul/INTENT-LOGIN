package com.sayeedul.intentlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button loginBtn,resetBtn;
    EditText userEdt,pwdEdt;
    TextView registerTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn = (Button)findViewById(R.id.loginbutton);
        resetBtn = (Button)findViewById(R.id.resetbutton);

        userEdt = (EditText)findViewById(R.id.userNameEditText);
        pwdEdt = (EditText)findViewById(R.id.pwdEditText);

        registerTV = (TextView)findViewById(R.id.registerLink);

        loginBtn.setOnClickListener(this);
        resetBtn.setOnClickListener(this);
        registerTV.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

         switch(view.getId())
         {
             case R.id.loginbutton :
                                        String userName = userEdt.getText().toString();
                                        String pwd = pwdEdt.getText().toString();

                                        if(userName.equalsIgnoreCase("srk") && pwd.equals("srk"))
                                        {
                                            Intent i = new Intent(MainActivity.this,LoginActivity.class);
                                            i.putExtra("username",userName);
                                            startActivity(i);
                                        }
                                        else
                                        {
                                            Toast.makeText(this,"LOGIN DETAILS ARE INCORRECT...",Toast.LENGTH_SHORT).show();
                                        }
                                        break;

             case R.id.resetbutton :
                                        userEdt.setText("");
                                        pwdEdt.setText("");
                                        break;

             case R.id.registerLink :
                                        Toast.makeText(this,"You Are Redirected to SIGN_UP page.....",Toast.LENGTH_SHORT).show();
                                        Intent i = new Intent(MainActivity.this,RegistrationActivity.class);
                                        startActivity(i);

                                        break;
         }
    }
}
