package com.sayeedul.intentlogin;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
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
       openAlert();
    }

    @Override
    public void onBackPressed() {
        openBackAlert();
    }

    private void openAlert()
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(RegistrationActivity.this);

        alertDialogBuilder.setTitle("SAVE DATA ");
        alertDialogBuilder.setMessage("Are You Sure To Save Data ? ");
        alertDialogBuilder.setIcon(R.mipmap.ic_launcher);

        alertDialogBuilder.setPositiveButton("YES,Proceed to Login.", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(RegistrationActivity.this, "PLease Wait. Saving Your Data .... ", Toast.LENGTH_SHORT).show();

                String userName = userEdt.getText().toString();
                Intent i = new Intent(RegistrationActivity.this,LoginActivity.class);
                i.putExtra("username",userName);
                startActivity(i);
            }
        });

        alertDialogBuilder.setNegativeButton("NO,Stay On This Page.", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(RegistrationActivity.this, "Staying On this Page.... ", Toast.LENGTH_SHORT).show();
                dialog.cancel();

            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void openBackAlert()
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(RegistrationActivity.this);

        alertDialogBuilder.setTitle("Go BACK ");
        alertDialogBuilder.setMessage("Are You Sure To Cancel ? ");
        alertDialogBuilder.setIcon(R.mipmap.ic_launcher);

        alertDialogBuilder.setPositiveButton("YES,Proceed", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(RegistrationActivity.this, "PLease Wait..... ", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(RegistrationActivity.this,MainActivity.class);
                startActivity(i);
            }
        });

        alertDialogBuilder.setNegativeButton("NO,Stay On This Page.", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(RegistrationActivity.this, "Staying On this Page.... ", Toast.LENGTH_SHORT).show();
                dialog.cancel();

            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

}
