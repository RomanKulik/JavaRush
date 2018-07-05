package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Консоль-копилка
Консоль-копилка
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введет слово «сумма».
Вывести на экран полученную сумму.


Требования:
1. Программа должна считывать данные с клавиатуры.
2. Программа должна корректно работать, если пользователь ввел одно число и слово «сумма».
3. Программа должна корректно работать, если пользователь ввел два числа число и слово «сумма».
4. Программа должна корректно работать, если пользователь ввел более двух чисел и слово «сумма».
5. Программа должна выводить текст на экран.
6. Программа должна прекращать считывать данные с клавиатуры после того пользователь введет слово "сумма" и нажмет Enter.
*/

/*public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
    }
}*/
public class Solution2 {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        double sum = 0;
        String ssum = "сумма";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inNum = null;

        while (true) {
            inNum = reader.readLine();

            // @ строка не null || в строке нет цифр && строка в любом case не сумма && строка не содержит слово сумма
            if ((inNum == null || !inNum.matches("\\d+")) && !inNum.equalsIgnoreCase(ssum) && !inNum.contains(ssum)) {
                continue;
//          } else if (isStringIncludesOtherString(inNum, ssum)) {
            } else if (inNum.contains(ssum)) {
                sum += SumFromString(inNum);
                break;
            } else if (inNum.equalsIgnoreCase(ssum)) {
                break;
            } else {
                sum += Double.parseDouble(inNum);
            }
        }
        System.out.println(sum);

    }

    // выделяет цифры из строки и выдает их сумму, игнорируя буквы и буквы с цифрами
    public static double SumFromString(String s) {
       // 1 jkl 3jk 4 3 jkl 2 сумма 4   14
        System.out.println("SumFromString");
        char ch;
        double sum = 0;
        String newS = new String();

        // чтобы отработал if (ch != ' ') в конце строки
        s += " ";

        for(int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch != ' ') {
                newS += ch;
            } else {
                if (newS.matches("\\d+")) {
                    sum += Double.parseDouble(newS);
                }
                newS = new String();
            }
        }
        return sum;
    }

    // @ содержит ли строка в любой case слово сумма аналог inNum.contains(ssum)
    public static Boolean isStringIncludesOtherString(String sourceString, String includedString) {
        System.out.println("isStringIncludesOtherString");
        sourceString = sourceString.toLowerCase();
        includedString = includedString.toLowerCase();

        if (sourceString.contains(includedString)) {
            return true;
        } else {
            return false;
        }
    }
}

/*
    try
    {
        integer = Integer.parseInt(string);
    }
    catch ( NumberFormatException e )
    {
        integer = -1;
    }


        String s1 = "123";
    String s2 = "12q";

    System.out.println(s1.matches("\\d+")); - true
    System.out.println(s2.matches("\\d+")); - false

 */