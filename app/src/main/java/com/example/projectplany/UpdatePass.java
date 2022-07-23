package com.example.projectplany;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UpdatePass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_pass);
    }

    public void back(View V)
    {
        Intent back = new Intent (UpdatePass.this,MainActivity.class);
        startActivity(back);
    }
}