package com.example.projectplany;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class ForgetPass extends AppCompatActivity {
    EditText FnameCheck , EmailCheck;
    Button Check;
    UserInfo db;
    Intent moveupdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass);
        FnameCheck = findViewById(R.id.Fname_forget);
        EmailCheck = findViewById(R.id.Email_forget);
        Check = findViewById(R.id.Check_B);
        Check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = EmailCheck.getText().toString().trim().toLowerCase();
                String fname = FnameCheck.getText().toString().trim().toLowerCase();
                //==========================================================
                /*
                 if (db.forgetPass(email, fname)) {
                    Toast.makeText(ForgetPass.this, "Successfully verified", Toast.LENGTH_SHORT).show();
                    moveupdate = new Intent(ForgetPass.this, UpdatePass.class);
                    startActivity(moveupdate);
                } else
                    Toast.makeText(ForgetPass.this, "The data entered is incorrect", Toast.LENGTH_SHORT).show();
                    */


            }



        });

        //======================================================================================

        //==============================
    }

    public void back(View view) {
        Intent back = new Intent (ForgetPass.this,MainActivity.class);
        startActivity(back);
    }
}

