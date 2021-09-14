package com.danielcranky;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            String inputLine = scanner.nextLine();

            try {
                String[] chars = inputLine.split(" ");

                if (chars.length != 3) throw new Exception("Нарушен формат ввода");

                Num firstNumber = NumberActions.checkAndSetNumber(chars[0]);
                Num secondNumber = NumberActions.checkAndSetNumber(chars[2], firstNumber.getType());
                String result = NumberActions.calculate(firstNumber, secondNumber, chars[1]);
                System.out.println(result);

            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            }

        }

        scanner.close();
    }
}
