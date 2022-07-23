package com.example.projectplany.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.projectplany.Activity.GpaActivity;
import com.example.projectplany.R;
public class FragmentCalculator extends Fragment {

    private Button button;
    private View view;

    public FragmentCalculator() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_calculator, container, false);




        button = view.findViewById(R.id.button);

        try {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                Intent intent = new Intent(getContext() , GpaActivity.class);
                startActivity(intent);
                }
            });
        }catch (NullPointerException e)
        {

        }


        return view;
    }

}