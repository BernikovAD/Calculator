package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.Normalizer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private TextView textView1;
    private Double number1 = null;
    private Double number2 = null;
    Calculator calc = new Calculator();
    char operand = ' ';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button0 = findViewById(R.id.button_0);
        Button button1 = findViewById(R.id.button_1);
        Button button2 = findViewById(R.id.button_2);
        Button button3 = findViewById(R.id.button_3);
        Button button4 = findViewById(R.id.button_4);
        Button button5 = findViewById(R.id.button_5);
        Button button6 = findViewById(R.id.button_6);
        Button button7 = findViewById(R.id.button_7);
        Button button8 = findViewById(R.id.button_8);
        Button button9 = findViewById(R.id.button_9);
        Button buttonAdd = findViewById(R.id.button_add);
        Button buttonMul = findViewById(R.id.button_mul);
        Button buttonEquals = findViewById(R.id.button_equals);
        Button buttonPoint = findViewById(R.id.button_point);
        Button buttonSub = findViewById(R.id.button_sub);
        Button buttonDiv = findViewById(R.id.button_div);
        Button buttonRes = findViewById(R.id.button_res);
        textView = findViewById(R.id.textView);
        textView1 = findViewById(R.id.textView1);
        View.OnClickListener editText = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = (String) textView.getText();
                String text1 = (String) textView1.getText();
                switch (v.getId()) {
                    case (R.id.button_0):
                        textView.setText(String.format("%s%s", text, button0.getText()));
                        textView1.setText(String.format("%s", button0.getText()));
                        break;
                    case (R.id.button_1):
                        textView.setText(String.format("%s%s", text, button1.getText()));
                        textView1.setText(String.format("%s", button1.getText()));
                        break;
                    case (R.id.button_2):
                        textView.setText(String.format("%s%s", text, button2.getText()));
                        textView1.setText(String.format("%s",  button2.getText()));
                        break;
                    case (R.id.button_3):
                        textView.setText(String.format("%s%s", text, button3.getText()));
                        textView1.setText(String.format("%s", button3.getText()));
                        break;
                    case (R.id.button_4):
                        textView.setText(String.format("%s%s", text, button4.getText()));
                        textView1.setText(String.format("%s", button4.getText()));
                        break;
                    case (R.id.button_5):
                        textView.setText(String.format("%s%s", text, button5.getText()));
                        textView1.setText(String.format("%s",  button5.getText()));
                        break;
                    case (R.id.button_6):
                        textView.setText(String.format("%s%s", text, button6.getText()));
                        textView1.setText(String.format("%s", button6.getText()));
                        break;
                    case (R.id.button_7):
                        textView.setText(String.format("%s%s", text, button7.getText()));
                        textView1.setText(String.format("%s", button7.getText()));
                        break;
                    case (R.id.button_8):
                        textView.setText(String.format("%s%s", text, button8.getText()));
                        textView1.setText(String.format("%s",  button8.getText()));
                        break;
                    case (R.id.button_9):
                        textView.setText(String.format("%s%s", text, button9.getText()));
                        textView1.setText(String.format("%s",  button9.getText()));
                        break;
                    case (R.id.button_add):
                        if (checkE(text.charAt(text.length() - 1))) {
                            operand = '+';
                            if (number1 == null) {
                                number1 = Double.parseDouble(text1);
                                textView.setText(String.format("%s+", text));
                                textView1.setText("");
                            }
                        }
                        break;
                    case (R.id.button_div):
                        if (checkE(text.charAt(text.length() - 1))) {
                            operand = '/';
                            if (number1 == null) {
                                number1 = Double.parseDouble(text1);
                                textView.setText(String.format("%s+", text));
                                textView1.setText("");
                            }
                        }
                        break;
                    case (R.id.button_mul):
                        if (checkE(text.charAt(text.length() - 1))) {
                            operand = '*';
                            if (number1 == null) {
                                number1 = Double.parseDouble(text1);
                                textView.setText(String.format("%s+", text));
                                textView1.setText("");
                            }
                        }
                        break;
                    case (R.id.button_sub):
                        if (checkE(text.charAt(text.length() - 1))) {
                            operand = '-';
                            if (number1 == null) {
                                number1 = Double.parseDouble(text1);
                                textView.setText(String.format("%s+", text));
                                textView1.setText("");
                            }
                        }
                        break;
                    case (R.id.button_point):
                        if (text.charAt(text.length() - 1) != '.')
                            textView.setText(String.format("%s.", text));
                        break;
                    case (R.id.button_equals):
                        if (checkE(text.charAt(text.length() - 1))) {
                            if (number2 == null) {
                                number2 = Double.parseDouble(text1);
                                textView.setText(String.format("%s=%s", text, calc.calculator(number1, number2, operand)));
                                textView1.setText("");
                                System.out.println(number1);
                                number1=calc.calculator(number1, number2, operand);
                            }
                        }
                        break;
                    case (R.id.button_res):
                        textView.setText("");
                        break;
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
        button9.setOnClickListener(editText);
        buttonAdd.setOnClickListener(editText);
        buttonMul.setOnClickListener(editText);
        buttonSub.setOnClickListener(editText);
        buttonDiv.setOnClickListener(editText);
        buttonEquals.setOnClickListener(editText);
        buttonPoint.setOnClickListener(editText);
        buttonRes.setOnClickListener(editText);
    }

    private boolean checkE(char c) {
        return (c != R.string.addition || c != R.string.multiplication || c != R.string.division || c != R.string.subtraction);
    }

}