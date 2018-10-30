package com.example.dell.loginapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);

        dialog = new AlertDialog.Builder(MainActivity.this).create();
        dialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
    }

    public void doLogin(View view) {
        if(TextUtils.isEmpty(username.getText())){
            dialog.setTitle("Warning");
            dialog.setMessage("Username is a required field");
            dialog.show();
        }
        else if(TextUtils.isEmpty(password.getText())){
            dialog.setTitle("Warning");
            dialog.setMessage("Password is a required field");
            dialog.show();
        }
        else if(TextUtils.isEmpty(username.getText())&& TextUtils.isEmpty(password.getText())){
            dialog.setTitle("Warning");
            dialog.setMessage("Both fields are required");
            dialog.show();
        }
        else if(password.length()<6){
            dialog.setTitle("Warning");
            dialog.setMessage("You must have at least 6 characters in your Password");
            dialog.show();
        }
        else{
            Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
        }
    }
}
