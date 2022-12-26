package com.example.skilltest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.preference.PreferenceManager;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.text.TextUtils;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class Signup extends AppCompatActivity {
    // Initializing
    public static SharedPreferences sharedPreferences;
    Context context;
    TextInputEditText txt_name;
    Button btn_signup;
    Toast error;
    String name;
    String error_msg;

    // First name string validation method
    public boolean isFirstNameValid(String text){
        return text.matches("^([A-Za-z]+)(\\S[A-Za-z]+)*\\S?$");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Initialize
        sharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE);
        context = getApplicationContext();
        txt_name = findViewById(R.id.txt_name);
        btn_signup = findViewById(R.id.btn_signup);

        ConstraintLayout constraintLayout = findViewById(R.id.signupContainer);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences username = getSharedPreferences("my_prefs", MODE_PRIVATE);
        String bgColor = sharedPreferences.getString("background_color", "darkblue_gradient");
        String btnColor = sharedPreferences.getString("button_color", "darkblue");
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if (btnColor.equals("darkblue")){
            int btColor = Color.parseColor("#223759");
            btn_signup.setBackgroundColor(btColor);
            editor.putInt("color", btColor);
            editor.apply();
        } if (btnColor.equals("bronzegold")){
            int btColor = Color.parseColor("#A08E5A");
            btn_signup.setBackgroundColor(btColor);
            editor.putInt("color", btColor);
            editor.apply();
        } if (btnColor.equals("darkgrey")){
            int btColor = Color.parseColor("#2F2F2F");
            btn_signup.setBackgroundColor(btColor);
            editor.putInt("color", btColor);
            editor.apply();
        }

        if (bgColor.equals("darkblue_gradient")){
            constraintLayout.setBackgroundResource(R.drawable.darkblue_gradient);
        } else if (bgColor.equals("lightblue_gradient")){
            constraintLayout.setBackgroundResource(R.drawable.lightblue_gradient);
        } else {
            constraintLayout.setBackgroundResource(R.drawable.smokeygray_gradient);
        }

        // setting onclick listener for input validation and switching to Splash activity
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get user input name and bind to Name variable with removing white spaces
                name = txt_name.getText().toString();
                name = name.replaceAll("^\\s+|\\s+$", "");

                // Check if user name input is empty
                if (TextUtils.isEmpty(name)) {
                    error_msg = "Please fill in your name!";
                    error = Toast.makeText(context, error_msg, Toast.LENGTH_SHORT);
                    error.show();   // Show error message
                } else if(!isFirstNameValid(name)) {
                    error_msg = "First name only!";
                    error = Toast.makeText(context, error_msg, Toast.LENGTH_SHORT);
                    error.show();
                } else {
                    // Creating an Editor object to edit(write to the file)
                    SharedPreferences.Editor myEdit = username.edit();

                    // Storing the key and its value
                    myEdit.putString("name", txt_name.getText().toString());
                    myEdit.apply();

                    startActivity(new Intent(context, Splash.class)); // Go to logo page
                }
            }
        });
    }
}