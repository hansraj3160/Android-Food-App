package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    DatabaseHelper db;
    EditText user_email, user_password, user_con_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        user_email = findViewById(R.id.id_reg_Email);
        user_password = findViewById(R.id.id_reg_password);
        user_con_password = findViewById(R.id.id_con_pass);
          db=new DatabaseHelper(this);


    }

    public void onInsert(View v) {
        String email = user_email.getText().toString();
        String password = user_password.getText().toString();
        String confirm_password = user_con_password.getText().toString();
        Toast.makeText(SignUp.this, email+" password", Toast.LENGTH_SHORT).show();
        if (email.length() > 0 && password.length() > 0 && confirm_password.length() > 0) {
                boolean checkinsertdata = db.insertData(email, password);
                if (checkinsertdata == true) {
                    Toast.makeText(SignUp.this, "New Entry inserted", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(SignUp.this, "New Entry Not inserted", Toast.LENGTH_SHORT).show();

                }
            }
        else {
                Toast.makeText(this, "password does not Match", Toast.LENGTH_SHORT).show();
            }
        Intent i=new Intent(this,Login.class);
        startActivity(i);
        finish();
    }
}