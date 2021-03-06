package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button_add;
    private Button button_mul;
    private Button button_equals;
    private Button button_point;
    private Button button_sub;
    private Button button_div;
    private Button button_res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button0 = findViewById(R.id.button_0);
        button1 = findViewById(R.id.button_1);
        button2 = findViewById(R.id.button_2);
        button3 = findViewById(R.id.button_3);
        button4 = findViewById(R.id.button_4);
        button5 = findViewById(R.id.button_5);
        button6 = findViewById(R.id.button_6);
        button7 = findViewById(R.id.button_7);
        button8 = findViewById(R.id.button_8);
        button9 = findViewById(R.id.button_9);
        button_add = findViewById(R.id.button_add);
        button_mul = findViewById(R.id.button_mul);
        button_equals = findViewById(R.id.button_equals);
        button_point = findViewById(R.id.button_point);
        button_sub = findViewById(R.id.button_sub);
        button_div = findViewById(R.id.button_div);
        button_res = findViewById(R.id.button_res);
        textView = findViewById(R.id.textView);

        View.OnClickListener editText = new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String text = (String) textView.getText();
                if (v.getId() == R.id.button_0) {
                    textView.setText(text + button0.getText());
                }
                else if (v.getId() == R.id.button_1) {
                    textView.setText(text + button1.getText());
                }
                else if (v.getId() == R.id.button_2) {
                    textView.setText(text + button2.getText());
                }
                else if (v.getId() == R.id.button_3) {
                    textView.setText(text + button3.getText());
                }
                else if (v.getId() == R.id.button_4) {
                    textView.setText(text + button4.getText());
                }
                else if (v.getId() == R.id.button_5) {
                    textView.setText(text + button5.getText());
                }
                else if (v.getId() == R.id.button_6) {
                    textView.setText(text + button6.getText());
                }
                else if (v.getId() == R.id.button_7) {
                    textView.setText(text + button7.getText());
                }
                else if (v.getId() == R.id.button_8) {
                    textView.setText(text + button8.getText());
                }
                else if (v.getId() == R.id.button_9) {
                    textView.setText(text + button9.getText());
                }
                else if (v.getId() == R.id.button_add) {
                    textView.setText(text + button_add.getText());
                }
                else if (v.getId() == R.id.button_div) {
                    textView.setText(text + button_div.getText());
                }
                else if (v.getId() == R.id.button_mul) {
                    textView.setText(text + button_mul.getText());
                }
                else if (v.getId() == R.id.button_sub) {
                    textView.setText(text + button_sub.getText());
                }
                else if (v.getId() == R.id.button_point) {
                    textView.setText(text + button_point.getText());
                }
                else if (v.getId() == R.id.button_equals) {
                    calculator();
                }
                else if (v.getId() == R.id.button_res) {
                    textView.setText("");

                }
            }
        };
        button0.setOnClickListener(editText);
        button1.setOnClickListener(editText);
        button2.setOnClickListener(editText);
        button3.setOnClickListener(editText);
        button4.setOnClickListener(editText);
        button5.setOnClickListener(editText);
        button6.setOnClickListener(editText);
        button7.setOnClickListener(editText);
        button8.setOnClickListener(editText);


    }

    private void calculator() {

    }

}