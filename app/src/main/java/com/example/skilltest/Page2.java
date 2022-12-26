package com.example.skilltest;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

public class Page2 extends Fragment {
    public Page2() {
        // Constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_page2, container, false);
        int currentQuestionIndex = getArguments().getInt("index");
        String value = getArguments().getString("key");

        TextView txt_counter = view.findViewById(R.id.txt_counter);
        txt_counter.setText("Question: 2 of 5");

        TextView txt_question = view.findViewById(R.id.txt_question);
        RadioButton rbtn_one = view.findViewById(R.id.rbtn_one);
        RadioButton rbtn_two = view.findViewById(R.id.rbtn_two);
        RadioButton rbtn_three = view.findViewById(R.id.rbtn_three);
        RadioButton rbtn_four = view.findViewById(R.id.rbtn_four);
        RadioGroup rGroup = view.findViewById(R.id.radio_group);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String txt_color = sharedPreferences.getString("txt_color","lightgrey");
        if(txt_color.equals("lightgrey")){
            int color = Color.parseColor("#909090");
            txt_counter.setTextColor(color);
            txt_question.setTextColor(color);
            rbtn_one.setTextColor(color);
            rbtn_two.setTextColor(color);
            rbtn_three.setTextColor(color);
            rbtn_four.setTextColor(color);
        } if (txt_color.equals("bronzegold")){
            int color = Color.parseColor("#A08E5A");
            txt_counter.setTextColor(color);
            txt_question.setTextColor(color);
            rbtn_one.setTextColor(color);
            rbtn_two.setTextColor(color);
            rbtn_three.setTextColor(color);
            rbtn_four.setTextColor(color);
        } if (txt_color.equals("charblack")){
            int color = Color.parseColor("#131313");
            txt_counter.setTextColor(color);
            txt_question.setTextColor(color);
            rbtn_one.setTextColor(color);
            rbtn_two.setTextColor(color);
            rbtn_three.setTextColor(color);
            rbtn_four.setTextColor(color);
        }

        ViewPagerAdapter.setContent((ViewGroup) view, value, currentQuestionIndex,
                txt_question, rbtn_one,
                rbtn_two, rbtn_three, rbtn_four);

        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton checkedRadioButton = group.findViewById(checkedId);
                boolean isChecked = checkedRadioButton.isChecked();

                if (isChecked){
                    ViewPagerAdapter.selectAnswer((ViewGroup) view, checkedRadioButton, value,
                            currentQuestionIndex, getContext());
                }
            }
        });

        return view;
    }
}
