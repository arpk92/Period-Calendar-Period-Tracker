package com.example.projectplany;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class registrationProject extends AppCompatActivity {
    TextView HaveAcc;
    TextView back;
    EditText Name , Password , Email , Age ;
    Button button_sign;
    UserInfo db;
    Intent moveLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_project);
        setUpValue();
        //=======================================================================================================================================================================================
        button_sign.setOnClickListener(new View.OnClickListener()
                                       {
                                           @Override
                                           public void onClick(View v) {
                                               String user = Name.getText().toString().trim().toLowerCase();
                                               String email = Email.getText().toString().trim().toLowerCase();
                                               String pass = Password.getText().toString().trim();
                                               String age =Age.getText().toString().trim();
                                               //==========================================================
                                               if (validate () == true ) {
                                                   if (db.cheackUser(user, pass))
                                                   {Toast.makeText(registrationProject.this, "You have account", Toast.LENGTH_SHORT).show();
                                                        moveLogin = new Intent (registrationProject.this , LoginProject.class);
                                                       startActivity(moveLogin);}
                                                    else {if (db.addUser(user,email,pass,age))
                                                   {Toast.makeText(registrationProject.this, "Succeful regesration", Toast.LENGTH_SHORT).show();
                                                   Intent MoveLogin = new Intent(registrationProject.this, LoginProject.class);}
                                                    else  Toast.makeText(registrationProject.this, "Error", Toast.LENGTH_SHORT).show();} }}});}

    //=======================================================================================================================================================================================

    public void setUpValue(){
        HaveAcc =  findViewById(R.id.haveAccount);
        back= findViewById(R.id.back);
        Name= findViewById(R.id.input_Name);
        Email= findViewById(R.id.input_Email);
        Password = findViewById(R.id.Check_pass);
        Age = findViewById(R.id.input_age);
        button_sign= findViewById(R.id.button_sign);
    db = new UserInfo(this);}
//======================================================

    public void Login (View V)
    { Intent login = new Intent (this,LoginProject.class);
        startActivity(login); }
    //======================================================
    public void back(View V)
    {Intent back = new Intent (this,MainActivity.class);
        startActivity(back);}
    //======================================================

    public boolean validate() {
        Boolean result = false;
        String name = Name.getText().toString();
        String email = Email.getText().toString();
        String password = Password.getText().toString();
        String age = Age.getText().toString();
        if (name.isEmpty() && password.isEmpty() && email.isEmpty() && age.isEmpty()) {
            Toast.makeText(registrationProject.this, "Pleas Enter All the details", Toast.LENGTH_SHORT).show();
        } else if (password.length() < 8)
        { Toast.makeText(registrationProject.this, "Please enter the 8 characters for the password (letters, numbers, or symbols)", Toast.LENGTH_SHORT).show();}
        else   result = true;
        return result;}
//======================================================

}
