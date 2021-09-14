package com.danielcranky;

import java.util.TreeMap;

public class NumberActions {

    private final static TreeMap <Integer, String> romanMap = new TreeMap();

    static {
        romanMap.put(1, "I");
        romanMap.put(4, "IV");
        romanMap.put(5, "V");
        romanMap.put(9, "IX");
        romanMap.put(10, "X");
        romanMap.put(40, "XL");
        romanMap.put(50, "L");
        romanMap.put(90, "XC");
        romanMap.put(100, "C");
    }

    static Num checkAndSetNumber(String num) throws Exception {

        int value;
        NumType type;

        try {
            value = Integer.parseInt(num);
            type = NumType.ARABIC;
        } catch (NumberFormatException e) {
            value = convertToArabic(num);
            type = NumType.ROMAN;
        }

        if (value < 1 || value > 10) {
            throw new Exception("Не выполнено условие - числа от 1 до 10");
        }

        return new Num(value, type);
    }

    static Num checkAndSetNumber(String num, NumType type) throws Exception {

        Num number = checkAndSetNumber(num);

        if (type != number.getType()) {
            throw new Exception("Разный тип чисел");
        }

        return number;
    }

    static int convertToArabic(String num) throws Exception {

        switch (num) {
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
            default:
                throw new Exception("Не выполнено условие ввода");
        }
    }

    static String calculate(Num firstNumber, Num secondNumber, String operation) throws Exception {

        int result;

        switch (operation) {
            case "+":
                result = firstNumber.getValue() + secondNumber.getValue();
                break;
            case "-":
                result = firstNumber.getValue() - secondNumber.getValue();
                break;
            case "*":
                result = firstNumber.getValue() * secondNumber.getValue();
                break;
            case "/":
                result = firstNumber.getValue() / secondNumber.getValue();
                break;
            default:
                throw new Exception("Неверный символ операции");
        }

        if (firstNumber.getType() == NumType.ROMAN && result < 1) {
            throw new Exception("Результат меньше 1");
        }
        else if (firstNumber.getType() == NumType.ROMAN) {
                return convertToRomanic(result);
        } else return String.valueOf(result);
    }

    static String convertToRomanic(int num) {

        int i = romanMap.floorKey(num);

        if (i == num) {
            return romanMap.get(num);
        }

        return romanMap.get(i) + convertToRomanic(num - i);
    }

}
