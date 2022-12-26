package com.example.skilltest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import java.util.Arrays;

public class Page5 extends Fragment {
    public Page5() {
        // Constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); }

    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_page5, container, false);

        int currentQuestionIndex = getArguments().getInt("index");
        String value = getArguments().getString("key");

        TextView txt_counter = view.findViewById(R.id.txt_counter);
        txt_counter.setText("Question: 5 of 5");

        TextView txt_question = view.findViewById(R.id.txt_question);
        RadioButton rbtn_one = view.findViewById(R.id.rbtn_one);
        RadioButton rbtn_two = view.findViewById(R.id.rbtn_two);
        RadioButton rbtn_three = view.findViewById(R.id.rbtn_three);
        RadioButton rbtn_four = view.findViewById(R.id.rbtn_four);
        RadioGroup rGroup = view.findViewById(R.id.radio_group);
        Button submit = view.findViewById(R.id.btn_submit);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String txt_color = sharedPreferences.getString("txt_color","lightgrey");
        String btnColor = sharedPreferences.getString("button_color", "darkblue");
        SharedPreferences.Editor editor = sharedPreferences.edit();

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

        if (btnColor.equals("darkblue")){
            int btColor = Color.parseColor("#223759");
            submit.setBackgroundColor(btColor);
            editor.putInt("color", btColor);
            editor.apply();
        } if (btnColor.equals("bronzegold")){
            int btColor = Color.parseColor("#A08E5A");
            submit.setBackgroundColor(btColor);
            editor.putInt("color", btColor);
            editor.apply();
        } if (btnColor.equals("darkgrey")){
            int btColor = Color.parseColor("#2F2F2F");
            submit.setBackgroundColor(btColor);
            editor.putInt("color", btColor);
            editor.apply();
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

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = getActivity().getSharedPreferences(
                        "prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("name", "user");

                ViewPagerAdapter.totalScore = 0;
                String msg;

                for (int number : ViewPagerAdapter.score){
                    ViewPagerAdapter.totalScore += number;
                }

                if (ViewPagerAdapter.totalScore < 60) {
                    msg = "Unfortunately, You have failed the quiz.";
                } else {
                    msg = "Congrats, You have passed the quiz!";
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Quiz Result");
                builder.setMessage("Username: " + username + "\n\nScore: " +
                        ViewPagerAdapter.totalScore + " / 100\n\n" + msg);
                builder.setPositiveButton("Go to Menu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Main.question = "";
                        ViewPagerAdapter.totalScore = 0;
                        Arrays.fill(ViewPagerAdapter.score,0);
                        Intent intent = new Intent(getContext(),Main.class);
                        startActivity(intent);

                    }
                });
                builder.show();
            }
        });

        return view;
    }
}