package com.example.calculator;

public class Calculator {
    double calculator(double number1, double number2, char sign) {
        double result = 0;
        switch (sign){
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '/':
                result = number1 / number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '=':
                result=result;
                break;
        }
        return result;
    }
}
