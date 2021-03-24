package com.example.calculator;


import android.annotation.SuppressLint;

public class CalculatorExemple implements Calculator {
    //StringBuilder для облегчения работы со строками
    private final StringBuilder inputStr = new StringBuilder();
    private int actionSelected;
    //Создаем паттерн состояния, будет показывает на каком этапе сейчас находиться пользователь
    private State state;
    //Создаем переменные для работы в калькуляторе
    private int valueFirst;
    private int valueSecond;
/*   Перечислим состояние нашего калькулятора
    1- Ввод числа 1
    2- Ввод операции
    3- Ввод числа 2
    4- Вычисляем и показываем результат*/
    private enum State {
    VALUE_FIRST_INPUT,
    OPERATION_SELECTED,
    VALUE_SECOND_INPUT,
    RESULT_SHOW
    }
    //Конструктор класса, с выбор действия 1
    public CalculatorExemple() {
        state = State.VALUE_FIRST_INPUT;
    }
    //Обрабатываем события нажатия кнопок с цифрами
    @SuppressLint("NonConstantResourceId")
    public void onNumPressed(int buttonId) {
    //Если состояние равно 4(вычислять) то обнуляем  и переходим в первое состояние
        if (state == State.RESULT_SHOW) {
            state = State.VALUE_FIRST_INPUT;
            inputStr.setLength(0);
        }
        //Если состояние на выборе операции, то переходим на состояние ввода второй переменнной
        if (state == State.OPERATION_SELECTED) {
            state = State.VALUE_SECOND_INPUT;
            inputStr.setLength(0);
        }
        //ограничем максимальную длинну значения в 10 цифр и переходим к определению какая кнопка нажата
        if (inputStr.length() < 9) {
            switch (buttonId) {
                case R.id.button_0:
                    if (inputStr.length() != 0) {
                        inputStr.append("0");
                    }
                    break;
                case R.id.button_1:
                    inputStr.append("1");
                    break;
                case R.id.button_2:
                    inputStr.append("2");
                    break;
                case R.id.button_3:
                    inputStr.append("3");
                    break;
                case R.id.button_4:
                    inputStr.append("4");
                    break;
                case R.id.button_5:
                    inputStr.append("5");
                    break;
                case R.id.button_6:
                    inputStr.append("6");
                    break;
                case R.id.button_7:
                    inputStr.append("7");
                    break;
                case R.id.button_8:
                    inputStr.append("8");
                    break;
                case R.id.button_9:
                    inputStr.append("9");
                    break;
            }
        }
    }
    //Обрабатываем события нажатия кнопок на действия
    @SuppressLint("NonConstantResourceId")
    public void onActionPressed(int actionId) {
        if (actionId == R.id.button_equals && state == State.VALUE_SECOND_INPUT && inputStr.length() > 0) {
            valueSecond = Integer.parseInt(inputStr.toString());
            state = State.RESULT_SHOW;
            inputStr.setLength(0);
            switch (actionSelected) {
                case R.id.button_add:
                    inputStr.append(valueFirst + valueSecond);
                    break;
                case R.id.button_sub:
                    inputStr.append(valueFirst - valueSecond);
                    break;
                case R.id.button_mul:
                    inputStr.append(valueFirst * valueSecond);
                    break;
                case R.id.button_div:
                    inputStr.append(valueFirst / valueSecond);
                    break;
            }

        } else if (inputStr.length() > 0 && state == State.VALUE_FIRST_INPUT) {
            valueFirst = Integer.parseInt(inputStr.toString());
            state = State.OPERATION_SELECTED;
            actionSelected = actionId;
        }
    }

    public String getText() {
        StringBuilder str = new StringBuilder();
        switch (state) {
            default:
                //по умолчанию вводим первое число и показываем его
                return inputStr.toString();
            case OPERATION_SELECTED:
                //Если выбор операции, то выводим первое число и операцию(-=*/)
                return str.append(valueFirst).append(' ').append(getOperationChar()).toString();
            case VALUE_SECOND_INPUT:
                //Ввод 2го числа и вывод на экран пользователю
                return str.append(valueFirst).append(' ').append(getOperationChar()).append(' ').append(inputStr).toString();
            case RESULT_SHOW:
                //Показываем полученый результат
                return str.append(valueFirst).append(' ').append(getOperationChar()).append(' ').append(valueSecond).append(" = ").append(inputStr.toString()).toString();
        }
    }

    @SuppressLint("NonConstantResourceId")
    private char getOperationChar() {
        switch (actionSelected) {
            case R.id.button_add:
                return '+';
            case R.id.button_sub:
                return '-';
            case R.id.button_mul:
                return '*';
            case R.id.button_div:
                return '/';
            default:
                return '+';
        }
    }
// Обнуляем поле
    public void reset() {
        state = State.VALUE_FIRST_INPUT;
        inputStr.setLength(0);
    }
}
