package com.example.projectplany.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import com.example.projectplany.Activity.Bmi;
import com.example.projectplany.R;

public class FragmentHlthFollow extends Fragment {


    private View view;
    private Toolbar toolbar;
    private Button btn;
    public FragmentHlthFollow() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_hlth_follow, container, false);

        btn = view.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity() , Bmi.class);
                startActivity(intent);

                }


        });
        return view;
    }

    }

