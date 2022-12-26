package com.example.skilltest;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> fragments = new ArrayList<>();
    private final List<String> fragmentTitle = new ArrayList<>();
    public static String[] userAnswers = new String[5];
    public static int[] score = {0,0,0,0,0};
    public static int totalScore = 0;

    public ViewPagerAdapter(@NonNull FragmentManager fm)
    {
        super(fm);
    }

    public void add(Fragment fragment, String title, String value, int currentQuestionIndex)
    {
        fragments.add(fragment);
        fragmentTitle.add(title);
        Bundle bundle = new Bundle();
        bundle.putString("key", value);
        bundle.putInt("index",currentQuestionIndex);
        fragment.setArguments(bundle);
    }

    public static void setContent(ViewGroup container, @NonNull String value, int index,
                                  @NonNull TextView questiontxt,
                                  @NonNull RadioButton one, @NonNull RadioButton two,
                                  @NonNull RadioButton three, @NonNull RadioButton four){
        String question;
        String answers_1;
        String answers_2;
        String answers_3;
        String answers_4;
        if (value.equals("PHP")) {
            question = QuestionsAnswers.phpQuestions[index];
            answers_1 = QuestionsAnswers.phpAnswers[index][0];
            answers_2 = QuestionsAnswers.phpAnswers[index][1];
            answers_3 = QuestionsAnswers.phpAnswers[index][2];
            answers_4 = QuestionsAnswers.phpAnswers[index][3];
            questiontxt.setText(question);
            one.setText(answers_1);
            two.setText(answers_2);
            three.setText(answers_3);
            four.setText(answers_4);
        }
        if (value.equals("Java")) {
            question = QuestionsAnswers.javaQuestions[index];
            answers_1 = QuestionsAnswers.javaAnswers[index][0];
            answers_2 = QuestionsAnswers.javaAnswers[index][1];
            answers_3 = QuestionsAnswers.javaAnswers[index][2];
            answers_4 = QuestionsAnswers.javaAnswers[index][3];
            questiontxt.setText(question);
            one.setText(answers_1);
            two.setText(answers_2);
            three.setText(answers_3);
            four.setText(answers_4);
        }
        if (value.equals("Python")) {
            question = QuestionsAnswers.pythonQuestions[index];
            answers_1 = QuestionsAnswers.pythonAnswers[index][0];
            answers_2 = QuestionsAnswers.pythonAnswers[index][1];
            answers_3 = QuestionsAnswers.pythonAnswers[index][2];
            answers_4 = QuestionsAnswers.pythonAnswers[index][3];
            questiontxt.setText(question);
            one.setText(answers_1);
            two.setText(answers_2);
            three.setText(answers_3);
            four.setText(answers_4);
        }
        if (value.equals("Javascript")) {
            question = QuestionsAnswers.javascriptQuestions[index];
            answers_1 = QuestionsAnswers.javascriptAnswers[index][0];
            answers_2 = QuestionsAnswers.javascriptAnswers[index][1];
            answers_3 = QuestionsAnswers.javascriptAnswers[index][2];
            answers_4 = QuestionsAnswers.javascriptAnswers[index][3];
            questiontxt.setText(question);
            one.setText(answers_1);
            two.setText(answers_2);
            three.setText(answers_3);
            four.setText(answers_4);
        }
    }

    public static void selectAnswer(ViewGroup container, @NonNull RadioButton selectedRadioButton,
                                    @NonNull String value, int index, Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        boolean soundEffect = sharedPreferences.getBoolean("sound_mode", true);
        if(soundEffect){
            MediaPlayer select = MediaPlayer.create(context, R.raw.click_select);
            select.start();
        }

        if (selectedRadioButton.isChecked()) {
            String userAnswer = selectedRadioButton.getText().toString();
            userAnswers[index] = userAnswer;

            if (value.equals("PHP")){
                for (int i = 0; i < QuestionsAnswers.phpCorrectAnswers.length; i++){
                    if(userAnswers[index].equals(QuestionsAnswers.phpCorrectAnswers[i])){
                        score[index] = 20;
                        break;
                    } else {
                        score[index] = 0;
                    }
                }
            }
            if (value.equals("Java")){
                for (int i = 0; i < QuestionsAnswers.javaCorrectAnswers.length; i++){
                    if(userAnswers[index].equals(QuestionsAnswers.javaCorrectAnswers[i])){
                        score[index] = 20;
                        break;
                    } else {
                        score[index] = 0;
                    }
                }
            }
            if (value.equals("Python")){
                for (int i = 0; i < QuestionsAnswers.pythonCorrectAnswers.length; i++){
                    if(userAnswers[index].equals(QuestionsAnswers.pythonCorrectAnswers[i])){
                        score[index] = 20;
                        break;
                    } else {
                        score[index] = 0;
                    }
                }
            }
            if (value.equals("Javascript")){
                for (int i = 0; i < QuestionsAnswers.javascriptCorrectAnswers.length; i++){
                    if(userAnswers[index].equals(QuestionsAnswers.javascriptCorrectAnswers[i])){
                        score[index] = 20;
                        break;
                    } else {
                        score[index] = 0;
                    }
                }
            }
        }
    }

    @NonNull @Override public Fragment getItem(int position)
    {
        return fragments.get(position);
    }

    @Override public int getCount()
    {
        return 5;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position)
    {
        return fragmentTitle.get(position);
    }
}
