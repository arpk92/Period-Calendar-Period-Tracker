package com.example.projectplany;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button sign;
    Button log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sign = (Button) findViewById(R.id.SignHome);
        log = (Button) findViewById(R.id.LogHome);
    }

    public void Log(View V) {
        Intent log = new Intent(this,LoginProject.class);
        startActivity(log); }

    public void sign (View V)
    {
        Intent sign = new Intent (this,registrationProject.class);
        startActivity(sign);
    }


}