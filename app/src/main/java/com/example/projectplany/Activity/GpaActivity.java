package com.example.projectplany.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.projectplany.Adapter.CalculatorAdapter;
import com.example.projectplany.Model.ModelCalculator;
import com.example.projectplany.R;

import java.util.ArrayList;
import java.util.HashMap;

public class GpaActivity extends AppCompatActivity implements View.OnClickListener {
    private AppCompatButton mAddClassBtn;
    private AppCompatTextView mCalculate_tv;
    private AppCompatTextView mPrevious;
    private AppCompatTextView mPreviousGpa_tv;
    private CalculatorAdapter mCalculatorAdapter;
    private ArrayList<Double> gradevalue = new ArrayList<>();
    private RecyclerView mLayout1;
    HashMap<String, Double> map
            = new HashMap<>();

    private ArrayList<ModelCalculator> modelCalculatorArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpa);

        initView();
    }

    private void initView() {
        mPreviousGpa_tv = findViewById(R.id.mPreviousGpa_tv);
        mPrevious = findViewById(R.id.mPrevious_tv);

        mCalculate_tv = findViewById(R.id.mCalculate_tv);
        mCalculate_tv.setOnClickListener(this);
        mAddClassBtn = findViewById(R.id.mAddClass_btn);
        mAddClassBtn.setOnClickListener(this);
        mLayout1 = findViewById(R.id.mLayout1);


        modelCalculatorArrayList = setRecyclerViewList();
        mLayout1.setHasFixedSize(true);
        mLayout1.setLayoutManager(new LinearLayoutManager(this));
        mCalculatorAdapter = new CalculatorAdapter(this, modelCalculatorArrayList);
        mLayout1.setAdapter(mCalculatorAdapter);

    }

    private ArrayList<ModelCalculator> setRecyclerViewList() {
        ModelCalculator mModelCalculator = new ModelCalculator();

        modelCalculatorArrayList.add(mModelCalculator);
        return modelCalculatorArrayList;
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.mAddClass_btn) {

            addLayout("This is text 1", "This is first button", "This is second Button");
        } else if (v.getId() == R.id.mCalculate_tv) {
            if (modelCalculatorArrayList.size() > 0) {
                int totalGrade = 0;
                String grades = null;
                int number = 0;
                gradevalue.clear();
                for (int i = 0; i < modelCalculatorArrayList.size(); i++) {
                    if (modelCalculatorArrayList.get(i).getCredits() != 0) {
                        totalGrade += modelCalculatorArrayList.get(i).getCredits();
                        grades = modelCalculatorArrayList.get(i).getGrade();
                        if (grades != null) {
                            switch (grades) {
                                case "A+":

                                    number = modelCalculatorArrayList.get(i).getCredits();
                                    gradevalue.add(5.0 * number);

                                    break;

                                case "A":

                                    number = modelCalculatorArrayList.get(i).getCredits();

                                    gradevalue.add( 4.5 * number);
                                    break;
                                case "B+":
                                    number = modelCalculatorArrayList.get(i).getCredits();

                                    gradevalue.add( 4.0 * number);
                                    break;

                                case "B":

                                    number = modelCalculatorArrayList.get(i).getCredits();

                                    gradevalue.add( 3.5 * number);
                                    break;
                                case "C+":
                                    number = modelCalculatorArrayList.get(i).getCredits();

                                    gradevalue.add( 3.0 * number);
                                    break;

                                case "C":

                                    number = modelCalculatorArrayList.get(i).getCredits();

                                    gradevalue.add( 2.5 * number);
                                    break;
                                case "D+":

                                    number = modelCalculatorArrayList.get(i).getCredits();

                                    gradevalue.add( 2.0 * number);
                                    break;

                                case "F":

                                    gradevalue.add( 1.00 * number);

                                    break;
                            }
                        } else {
                            Toast.makeText(this, "Grade is not Empty", Toast.LENGTH_SHORT).show();
                        }


                    } else {
                        Toast.makeText(this, "Null Value", Toast.LENGTH_SHORT).show();
                    }
                    if (i + 1 == modelCalculatorArrayList.size()) {

                        calculatorGpa(totalGrade);
                    }
                }

            } else {
                Toast.makeText(this, "set Your Grade First", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void calculatorGpa(int totalGrade) {


        double mPointTotal = 0;
        for (int k = 0; k < gradevalue.size();
             k++){
            mPointTotal += gradevalue.get(k);
        }
        double gpa = mPointTotal / totalGrade;
//        String n= String.valueOf(gpa);
        String nn = String.valueOf(totalGrade);
        mPrevious.setText(nn);
        Log.d("TotalGradeValue", "calculatorGpa: point" + mPointTotal);
        String n = String.format("%.3f", gpa);
        mPreviousGpa_tv.setText(n);
    }

    private void addLayout(String textViewText, String buttonText1, String buttonText2) {
        if (modelCalculatorArrayList.size()<=6) {
            insertSingleItem();

        }
    }

    private void insertSingleItem() {
        ModelCalculator mModelCalculator = new ModelCalculator();

        modelCalculatorArrayList.add(mModelCalculator);
        mCalculatorAdapter.notifyItemInserted(modelCalculatorArrayList.size() + 1);
    }
}