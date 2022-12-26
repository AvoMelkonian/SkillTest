package com.example.skilltest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ConstraintLayout constraintLayout = findViewById(R.id.splashContainer);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String bgColor = sharedPreferences.getString("background_color", "darkblue_gradient");

        if (bgColor.equals("darkblue_gradient")){
            constraintLayout.setBackgroundResource(R.drawable.darkblue_gradient);
        } else if (bgColor.equals("lightblue_gradient")){
            constraintLayout.setBackgroundResource(R.drawable.lightblue_gradient);
        } else {
            constraintLayout.setBackgroundResource(R.drawable.smokeygray_gradient);
        }

        // Declare a new handler
        Handler handler = new Handler();

        // Define the code block to be executed after the delay
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // Start the new activity
                startActivity(new Intent(Splash.this, Main.class));
            }
        };

        // Set the delay in milliseconds (2400 = 2.4 seconds)
        int delay = 2400;

        // Schedule the code block to be executed after the delay
        handler.postDelayed(runnable, delay);
    }
}