package com.example.projectplany.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.projectplany.R;
import com.example.projectplany.ui.FragmentSchedule;

public class Perioddetails extends AppCompatActivity {
    Button closebutt;
    Button editbutt;
    Button clearbutt;
    TextView Class;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perioddetails);

        closebutt =(Button) findViewById(R.id.closebutt);
        editbutt =(Button) findViewById(R.id.editbutt);
        clearbutt =(Button) findViewById(R.id.clearbutt);
        Intent intent=getIntent();
        Class.setText(intent.getStringExtra("Class"));

        closebutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeActivityDetails();
            }
        });

        editbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editActivityDetails();
            }
        });

        clearbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleaActivityDetails();
            }
        });
    }

    public void closeActivityDetails(){
        Intent intent =new Intent(this, FragmentSchedule.class);
        startActivity(intent);
    }

    public void editActivityDetails(){
        Intent intent =new Intent(this,AddPeriod.class);
        startActivity(intent);
    }
    public void cleaActivityDetails(){

    }
}