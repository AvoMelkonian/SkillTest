package com.example.skilltest;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.preference.PreferenceManager;
import androidx.viewpager.widget.ViewPager;

public class Quiz extends AppCompatActivity {

    // Initialize
    ImageButton btn_prev, btn_forw;
    ViewPagerAdapter viewPagerAdapter;
    MediaPlayer next, prev;
    String value;
    ViewPager viewPager;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        value = getIntent().getStringExtra("keyQuestion");

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean soundEffect = sharedPreferences.getBoolean("sound_mode", true);

        ConstraintLayout constraintLayout = findViewById(R.id.quizContainer);
        String bgColor = sharedPreferences.getString("background_color", "darkblue_gradient");
        String btnColor = sharedPreferences.getString("button_color", "darkblue");
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if (bgColor.equals("darkblue_gradient")){
            constraintLayout.setBackgroundResource(R.drawable.darkblue_gradient);
        } else if (bgColor.equals("lightblue_gradient")){
            constraintLayout.setBackgroundResource(R.drawable.lightblue_gradient);
        } else {
            constraintLayout.setBackgroundResource(R.drawable.smokeygray_gradient);
        }

        viewPager = findViewById(R.id.view_pager);
        btn_prev = findViewById(R.id.btn_prev);
        btn_forw = findViewById(R.id.btn_forw);

        if (btnColor.equals("darkblue")){
            int btColor = Color.parseColor("#223759");
            btn_prev.setBackgroundColor(btColor);
            btn_forw.setBackgroundColor(btColor);
            editor.putInt("color", btColor);
            editor.apply();
        } if (btnColor.equals("bronzegold")){
            int btColor = Color.parseColor("#A08E5A");
            btn_prev.setBackgroundColor(btColor);
            btn_forw.setBackgroundColor(btColor);
            editor.putInt("color", btColor);
            editor.apply();
        } if (btnColor.equals("darkgrey")){
            int btColor = Color.parseColor("#2F2F2F");
            btn_prev.setBackgroundColor(btColor);
            btn_forw.setBackgroundColor(btColor);
            editor.putInt("color", btColor);
            editor.apply();
        }

        next = MediaPlayer.create(getApplicationContext(), R.raw.click_effect);
        prev = MediaPlayer.create(getApplicationContext(), R.raw.switch_select);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.add(new Page1(), "Page 1",value,0);
        viewPagerAdapter.add(new Page2(), "Page 2",value,1);
        viewPagerAdapter.add(new Page3(), "Page 3",value,2);
        viewPagerAdapter.add(new Page4(), "Page 4",value,3);
        viewPagerAdapter.add(new Page5(), "Page 5",value,4);

        btn_forw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentItem = viewPager.getCurrentItem();
                if (currentItem < viewPagerAdapter.getCount() - 1) {
                    if(soundEffect){
                        next.start();
                    }
                    viewPager.setCurrentItem(currentItem + 1, true);
                }
            }
        });

        btn_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentItem = viewPager.getCurrentItem();
                if (currentItem > 0) {
                    if(soundEffect){
                        prev.start();
                    }
                    viewPager.setCurrentItem(currentItem - 1, true);
                }
            }
        });

        viewPager.setAdapter(viewPagerAdapter);
    }
}