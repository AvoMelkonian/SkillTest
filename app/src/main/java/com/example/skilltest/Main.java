package com.example.skilltest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.preference.PreferenceManager;

public class Main extends AppCompatActivity {
    static String question = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConstraintLayout constraintLayout = findViewById(R.id.mainContainer);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
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

        Button btn_one = findViewById(R.id.btn_one);
        Button btn_two = findViewById(R.id.btn_two);
        Button btn_three = findViewById(R.id.btn_three);
        Button btn_four = findViewById(R.id.btn_four);
        ImageButton btn_settings = findViewById(R.id.btn_menu);

        if (btnColor.equals("darkblue")){
            int btColor = Color.parseColor("#223759");
            btn_settings.setBackgroundColor(btColor);
            btn_one.setBackgroundColor(btColor);
            btn_two.setBackgroundColor(btColor);
            btn_three.setBackgroundColor(btColor);
            btn_four.setBackgroundColor(btColor);
            editor.putInt("color", btColor);
            editor.apply();
        } if (btnColor.equals("bronzegold")){
            int btColor = Color.parseColor("#A08E5A");
            btn_settings.setBackgroundColor(btColor);
            btn_one.setBackgroundColor(btColor);
            btn_two.setBackgroundColor(btColor);
            btn_three.setBackgroundColor(btColor);
            btn_four.setBackgroundColor(btColor);
            editor.putInt("color", btColor);
            editor.apply();
        } if (btnColor.equals("darkgrey")){
            int btColor = Color.parseColor("#2F2F2F");
            btn_settings.setBackgroundColor(btColor);
            btn_one.setBackgroundColor(btColor);
            btn_two.setBackgroundColor(btColor);
            btn_three.setBackgroundColor(btColor);
            btn_four.setBackgroundColor(btColor);
            editor.putInt("color", btColor);
            editor.apply();
        }

        btn_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Settings.class));
            }
        });

        btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                question = "PHP";
                Intent intent = new Intent(getApplicationContext(), Quiz.class);
                intent.putExtra("keyQuestion", question);
                startActivity(intent);
            }
        });

        btn_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                question = "Java";
                Intent intent = new Intent(getApplicationContext(), Quiz.class);
                intent.putExtra("keyQuestion", question);
                startActivity(intent);
            }
        });

        btn_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                question = "Python";
                Intent intent = new Intent(getApplicationContext(), Quiz.class);
                intent.putExtra("keyQuestion", question);
                startActivity(intent);
            }
        });

        btn_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                question = "Javascript";
                Intent intent = new Intent(getApplicationContext(), Quiz.class);
                intent.putExtra("keyQuestion", question);
                startActivity(intent);
            }
        });

    }
}