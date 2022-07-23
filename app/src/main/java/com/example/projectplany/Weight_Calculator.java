package com.example.projectplany;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Weight_Calculator extends AppCompatActivity {
    EditText height , weight ;
    TextView result , state, Vwater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight__calculator);
        height= findViewById(R.id.height);
        weight=findViewById(R.id.weight);
        result = findViewById(R.id.result);
        state=findViewById(R.id.StateW);
        Vwater = findViewById(R.id.Vwater);
    }

    public void Calc(View view) {

            String h = (height.getText()).toString();
            float heig= Float.parseFloat(h)/100;
            String w = weight.getText().toString();
            float weig = Float.parseFloat(w);
             float res = weig/(heig*heig);
             String Result = String.valueOf(res);
            result.setText("%.2f".format(Result));
            if (res>= 19 && res<= 24 ) state.setText("Normal weight");
            else if (res>=25 && res<=29 ) state.setText("Overweight");
            else state.setText("Obesity");
            if (weig >= 45.0) Vwater.setText("1.9 L");
            else if  (weig >= 50.0) Vwater.setText("2 L");
            else if (weig >= 55.0)Vwater.setText("2.3 L");
            else if (weig >= 60.0)Vwater.setText("2.5 L");
            else if (weig >= 65.0)Vwater.setText("2.7 L");
            else if (weig >= 70.0)Vwater.setText("2.9 L");
            else if (weig >= 75.0)Vwater.setText("3.2 L");
            else if (weig >= 80.0)Vwater.setText("3.5 L");
            else if (weig >= 85.0)Vwater.setText("3.7 L");
            else if (weig >= 90.0)Vwater.setText("3.9 L");
            else if (weig >= 95.0)Vwater.setText("4.1 L");
            else if (weig >= 100.0)Vwater.setText("4.3 L");

    }


}