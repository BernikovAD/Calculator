package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.radiobutton.MaterialRadioButton;

public class MainActivity extends AppCompatActivity {
    private TextView text;
    private CalculatorExemple calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        int theme = sp.getInt("THEME", R.style.MyStyle);
        setTheme(theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculator = new CalculatorExemple();
        text = findViewById(R.id.textView);
        RadioGroup radioGroup = findViewById(R.id.radioButtons);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButtonMyStyle:
                        setTheme(R.style.MyStyle);
                        break;
                    case R.id.radioButtonDark:
                        setTheme(R.style.Theme_AppCompat_DayNight);
                        break;
                    case R.id.radioButtonLight:
                        setTheme(R.style.Theme_AppCompat_Light);
                        break;
                }
            }
        });
        //создаем массив кнопок с цифрами
        int[] numberIds = new int[]{
                R.id.button_0,
                R.id.button_1,
                R.id.button_2,
                R.id.button_3,
                R.id.button_4,
                R.id.button_5,
                R.id.button_6,
                R.id.button_7,
                R.id.button_8,
                R.id.button_9
        };
        //создаем массив операций
        int[] actionsIds = new int[]{
                R.id.button_add,
                R.id.button_sub,
                R.id.button_mul,
                R.id.button_div,
                R.id.button_equals
        };
        //Слушатель на кнопки с цифрами и вызов класса калькулятора, так же устанавливаем текст в TextView
        View.OnClickListener numberButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.onNumPressed(view.getId());
                text.setText(calculator.getText());
            }
        };
        //Слушатель на кнопки с операциями и вызов класса калькулятора, так же устанавливаем текст в TextView
        View.OnClickListener actionButtonOnclickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.onActionPressed(view.getId());
                text.setText(calculator.getText());
            }
        };
        //призваеваем каждой кнопке слушателя, дабы избежать копипасты
        for (int i = 0; i < numberIds.length; i++) {
            findViewById(numberIds[i]).setOnClickListener(numberButtonClickListener);
        }
        for (int i = 0; i < actionsIds.length; i++) {
            findViewById(actionsIds[i]).setOnClickListener(actionButtonOnclickListener);
        }
        //слушатель на кнопку обнуления
        findViewById(R.id.button_res).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.reset();
                text.setText(calculator.getText());
            }
        });
    }
}