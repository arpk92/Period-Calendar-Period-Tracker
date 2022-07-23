package com.example.projectplany.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projectplany.R;

public class AddPeriod extends AppCompatActivity {
    Button cancelbutt;
    Button doebutt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_period);

        cancelbutt =(Button) findViewById(R.id.cancelbutt);
        doebutt =(Button) findViewById(R.id.doebutt);

        cancelbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelAddPeriod();
            }
        });

        doebutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doneOfAddPeriod();
            }
        });
    }

    public void cancelAddPeriod(){
        Intent intent =new Intent(this,Perioddetails.class);
        startActivity(intent);
    }
    public void doneOfAddPeriod(){


    }
}