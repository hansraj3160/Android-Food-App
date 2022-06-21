package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
     DatabaseHelper db;
    EditText email,password;
    String saveEmail;
    String savepass;
    boolean status=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=findViewById(R.id.inputEmail);
         password=findViewById(R.id.inputPassword);
            db=new DatabaseHelper(this);

    }
    public void onLogin(View view){
         Cursor cr=db.getdata();
        if (cr.getCount()==0){
            Toast.makeText(this, "No Entry Exist", Toast.LENGTH_SHORT).show();
            return;
        }
         String enter_email=email.getText().toString();
        String enter_password=password.getText().toString();
         int count=0;
         String U_email[]=new String[cr.getCount()];
          String U_password[]=new String[cr.getCount()];
        while (cr.moveToNext()){
            String Id="\n"+cr.getString(0);
           String U_n="\n"+cr.getString(1);
            U_email[count]=U_n;
           saveEmail=U_n;
            String pass="\n"+cr.getString(2);
            U_password[count]=pass;
            savepass=pass;
             if (enter_email.equals(saveEmail.trim()) && enter_password.equals(savepass.trim())){
                status=true;
                break;
            }
            count++;

        }
         if (status){
               Intent intent = new Intent(this, HomeScreen.class);
                startActivity(intent);
                finish();
            }
         else {
             Toast.makeText(this, enter_email+"Wrong Email "+saveEmail, Toast.LENGTH_SHORT).show();
         }

    }
    public void onSignUp(View view){
        Intent intent=new Intent(this,SignUp.class);
        startActivity(intent);
    }

}