package com.example.projectplany.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.example.projectplany.Activity.Perioddetails;
import com.example.projectplany.R;

import java.util.ArrayList;
import java.util.List;


public class FragmentSchedule extends Fragment {
    GridView G1;
    String[] mylist = {"Period","1","2","3","4","5","6","7","8","9","Sun"," "," "," "," "," "," "," "," "," ","Mon"," "," "," "," "," "," "," "," "," ","Tue"," "," "," "," "," "," "," "," "," ","Wed"," "," "," "," "," "," "," "," "," ","Thur"," "," "," "," "," "," "," "," "," "};
        private View view;
    public FragmentSchedule() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_schedule, container, false);

        G1 = (GridView)view.findViewById(R.id.grid_1);
        List<String> values = new ArrayList<String>();
        for (int y=0;y<mylist.length;y++){
            values.add(mylist[y]);
        }
        G1.setAdapter(new ArrayAdapter<String>(getContext(),R.layout.activity_gridcell,values));
      /*
        G1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int y, long id) {
                Intent intent=new Intent(getContext(),Perioddetails.class);
                final Intent intent1 = intent.putExtra(getString(R.string.Class), mylist[y]);
                startActivity(intent);
            }
        });

       */
        return view;
    }
}