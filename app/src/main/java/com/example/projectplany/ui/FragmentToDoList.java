package com.example.projectplany.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.FileUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.projectplany.Activity.AddToDO;
import com.example.projectplany.R;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FragmentToDoList extends Fragment {
    private View view;
    private Button button;
    public FragmentToDoList() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_to_do_list, container, false);

        button = view.findViewById(R.id.button_add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext() , AddToDO.class);
                startActivity(intent);
            }
        });


        return view;
    }

}

