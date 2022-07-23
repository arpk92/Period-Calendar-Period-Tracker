package com.example.projectplany;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginProject extends AppCompatActivity {
    TextView DHaveAcc;
    TextView back;
    UserInfo db;
    EditText name , pass;
    Button button_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_project);
        DHaveAcc = findViewById(R.id.dhaveAccount);
        button_login = findViewById(R.id.button_login);
        back = findViewById(R.id.back);
        name = findViewById(R.id.input_Name);
        pass = findViewById(R.id.Check_pass);
        db = new UserInfo(this);


//==============================================================
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = name.getText().toString().trim().toLowerCase();
                String password = pass.getText().toString().trim();
                Boolean res = db.cheackUser(user, password);
                if (res) {
                    Toast.makeText(LoginProject.this, "Successfully Logged in", Toast.LENGTH_SHORT).show();
                    Intent moveHome =new Intent (LoginProject.this , SplashPage.class);
                    startActivity(moveHome);
                } else {
                    Toast.makeText(LoginProject.this, " The username or password is incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //=============================================
    }
//===============================================================
    public void sign (View V)
    {
        Intent sign = new Intent (LoginProject.this,registrationProject.class);
        startActivity(sign);
    }
    public void back(View V)
    {
        Intent back = new Intent (LoginProject.this,MainActivity.class);
        startActivity(back);
    }


}