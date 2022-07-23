package com.example.projectplany.Adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectplany.Model.ModelCalculator;
import com.example.projectplany.R;

import java.util.ArrayList;

public class CalculatorAdapter extends RecyclerView.Adapter<CalculatorAdapter.ViewHolder> {
    // Created By Web Tos 21/10/2020

    private ArrayList<ModelCalculator> modelCalculatorArrayList;
    private Context mContext;

    public CalculatorAdapter(Context mContext, ArrayList<ModelCalculator> modelCalculatorArrayList) {
        this.mContext = mContext;
        this.modelCalculatorArrayList = modelCalculatorArrayList;
    }
    @Override
    public CalculatorAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.liner_layout, parent, false);
        // pass MyCustomEditTextListener to viewholder in onCreateViewHolder
        // so that we don't have to do this expensive allocation in onBindViewHolder
        ViewHolder vh = new ViewHolder(v, new MyCustomEditTextListener(), new MyCustomEditTextListener1());

        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // update MyCustomEditTextListener every time we bind a new item
        // so that it knows what item in modelCalculatorArrayList to update
//        holder.myCustomEditTextListener.updatePosition(holder.getAdapterPosition());
//        holder.myCustomEditTextListener1.updatePosition(holder.getAdapterPosition());
//        holder.mGradeLayout.setText(modelCalculatorArrayList.get(holder.getAdapterPosition()).getGrade());
//        holder.mAppCompatTextView3.setText(modelCalculatorArrayList.get(holder.getAdapterPosition()).getCredits());

        holder.mAppCompatTextView3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d("afterTextChanged", "afterTextChanged: " + s.toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("afterTextChanged", "afterTextChanged: " + s.toString());
                int number = 0;
                try {
                    number = Integer.parseInt(s.toString());
                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                }

                modelCalculatorArrayList.get(position).setCredits(number);
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("afterTextChanged", "afterTextChanged: " + s.toString());
            }
        });


//        String text = holder.mGradeLayout.getSelectedItem().toString();
//        modelCalculatorArrayList.get(position).setGrade(text);


        holder.mGradeLayout.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d("afterTextChanged", "afterTextChanged: " + s.toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                if (s.toString().toUpperCase().contains("A+")) {
                    modelCalculatorArrayList.get(position).setGrade(s.toString().toUpperCase());
                } else if (s.toString().toUpperCase().contains("A")) {
                    modelCalculatorArrayList.get(position).setGrade(s.toString().toUpperCase());
                }else if (s.toString().toUpperCase().contains("B+")) {
                    modelCalculatorArrayList.get(position).setGrade(s.toString().toUpperCase());
                } else if (s.toString().toUpperCase().contains("B")) {
                    modelCalculatorArrayList.get(position).setGrade(s.toString().toUpperCase());
                } else if (s.toString().toUpperCase().contains("C+")) {
                    modelCalculatorArrayList.get(position).setGrade(s.toString().toUpperCase());
                } else if (s.toString().toUpperCase().contains("C")) {
                    modelCalculatorArrayList.get(position).setGrade(s.toString().toUpperCase());
                } else if (s.toString().toUpperCase().contains("D+")) {
                    modelCalculatorArrayList.get(position).setGrade(s.toString().toUpperCase());
                } else if (s.toString().toUpperCase().contains("F")) {
                    modelCalculatorArrayList.get(position).setGrade(s.toString().toUpperCase());
                } else {
                    holder.mGradeLayout.setError("e.g(A+,A,B+,B,C+,C,D+,F)");
//                    Toast.makeText(mContext, "e.g(A+,A,A-,B+,B,B-,C+,C,C-,D+,D,D-,F)", Toast.LENGTH_LONG).show();
                }


            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("afterTextChanged", "afterTextChanged: " + s.toString());
            }
        });


    }

    @Override
    public int getItemCount() {
        return modelCalculatorArrayList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        AppCompatTextView mAppCompatTextView1;
        AppCompatEditText mGradeLayout;
        AppCompatEditText mAppCompatTextView3;
        //        public AppCompatEditText mEditText;
        public MyCustomEditTextListener myCustomEditTextListener;
        public MyCustomEditTextListener1 myCustomEditTextListener1;

        public ViewHolder(View v, MyCustomEditTextListener myCustomEditTextListener, MyCustomEditTextListener1 myCustomEditTextListener1) {
            super(v);

            this.mGradeLayout = v.findViewById(R.id.mGrade_tv);
//            this.myCustomEditTextListener = myCustomEditTextListener;
//            this.mGradeLayout.addTextChangedListener(myCustomEditTextListener);
            this.mAppCompatTextView3 = v.findViewById(R.id.mCredits_tv);
//            this.myCustomEditTextListener1 = myCustomEditTextListener1;
//            this.mGradeLayout.addTextChangedListener(myCustomEditTextListener1);
        }
    }

    // we make TextWatcher to be aware of the position it currently works with
    // this way, once a new item is attached in onBindViewHolder, it will
    // update current position MyCustomEditTextListener, reference to which is kept by ViewHolder
    private class MyCustomEditTextListener implements TextWatcher {
        private int position;

        public void updatePosition(int position) {
            this.position = position;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            // no op
            Log.d("beforeTextChanged", "beforeTextChanged: " + charSequence.toString());
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Log.d("onTextChanged", "onTextChanged: " + charSequence.toString());
            modelCalculatorArrayList.get(position).setGrade(charSequence.toString());
        }

        @Override
        public void afterTextChanged(Editable editable) {
            Log.d("afterTextChanged", "afterTextChanged: " + editable.toString());
            // no op
        }
    }

    private class MyCustomEditTextListener1 implements TextWatcher {
        private int position;

        public void updatePosition(int position) {
            this.position = position;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            // no op
            Log.d("beforeTextChanged", "beforeTextChanged: " + charSequence.toString());
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Log.d("onTextChanged", "onTextChanged: " + charSequence.toString());
            modelCalculatorArrayList.get(position).setCredits(Integer.parseInt(charSequence.toString()));
        }

        @Override
        public void afterTextChanged(Editable editable) {
            Log.d("afterTextChanged", "afterTextChanged: " + editable.toString());
            // no op
        }
    }
}