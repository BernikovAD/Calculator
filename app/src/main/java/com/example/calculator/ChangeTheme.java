package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import static androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO;
import static androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES;
import static androidx.appcompat.app.AppCompatDelegate.setDefaultNightMode;

public class ChangeTheme extends AppCompatActivity {
    private boolean isDark = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_theme);

        findViewById(R.id.btnBack).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settingsIntent = new Intent(ChangeTheme.this,MainActivity.class);
                startActivity(settingsIntent);
            }
        });

        findViewById(R.id.settingsBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isDark) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Day", Toast.LENGTH_SHORT);
                    toast.show();
                    setDefaultNightMode(MODE_NIGHT_NO);
                } else  {
                    Toast toast = Toast.makeText(getApplicationContext(), "Night", Toast.LENGTH_SHORT);
                    toast.show();
                    setDefaultNightMode(MODE_NIGHT_YES);

                }
                isDark = !isDark;
            }
        });

    }
}