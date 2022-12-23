package com.example.skilltest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.Objects;

public class activity_main extends AppCompatActivity {

    Spinner sp_theme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        Objects.requireNonNull(getSupportActionBar()).hide(); // hide the title bar without causing null pointer
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_main);

        // Theme spinner
        sp_theme = findViewById(R.id.sp_theme);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> sp_adapter = ArrayAdapter.createFromResource(this,
                R.array.sp_themes, android.R.layout.simple_spinner_dropdown_item);
        // Specify the layout to use when the list of choices appears
        sp_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        sp_theme.setAdapter(sp_adapter);
    }
}