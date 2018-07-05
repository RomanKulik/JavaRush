package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* 
Факториал
На планете Линейный Хаос поиском факториала двузначных чисел
на их планете принято занимать младенцев.
Ну а мы подойдём по-взрослому, по-программистски, и напишем метод,
вычисляющий факториал вплоть до введённого числа.

Факториал
Написать метод, который вычисляет факториал -
произведение всех чисел от 1 до введенного числа включая его.

Пример вычислений: 4! = factorial(4) = 1*2*3*4
Пример вывода: 24

1. Ввести с консоли число меньше либо равно 150.
2. Реализовать функцию factorial.
3. Если введенное число меньше 0, то вывести 0.
0! = 1


Требования:
1. Программа должна считывать данные с клавиатуры.
2. Программа должна выводить на экран факториал введенного числа.
3. Метод factorial должен возвращать строковое представление
факториала числа переданного ему в качестве параметра.
4. Метод factorial должен принимать один параметр типа int.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //while (true) {
            try {
                int input = Integer.parseInt(reader.readLine());
                reader.close(); // закомментировать для цикла

                System.out.println(factorial(input));
            } catch (Exception e) {}
        //}
    }

    public static String factorial(int n) {
        //add your code here
        if (n < 0)
            return "0";
       /* if (n == 0)
            return "0! = 1";
        if (n > 150)
            return "Число больше 150";*/

        //System.out.println(Integer.MIN_VALUE); // -2 147 483 648
        //System.out.println(Integer.MAX_VALUE); //  2 147 483 647
        // MAX = 2 147 483 647
        //(int)12! =   479 001 600
        //(int)13! = 1 932 053 504 // over int
        //(BigDecimal)13! = 6 227 020 800 // > Integer.MAX_VALUE
        int factorialInt = 1;

        //System.out.println(Long.MIN_VALUE); // -9 223 372 036 854 775 808
        //System.out.println(Long.MAX_VALUE); //  9 223 372 036 854 775 807
        // MAX =  9 223 372 036 854 775 807
        //(long)20! =  2 432 902 008 176 640 000
        //(long)21! = -4 249 290 049 419 214 848 // over long
        //(BigDecimal)21! = 51 090 942 171 709 440 000 // > Long.MAX_VALUE
        long factorialLong = 1L;

        BigDecimal factorial = new BigDecimal(1);

        for (int i = 1; i <= n; i++) {
            //factorialInt *= i;
            //factorialLong *= (long) i;
            factorial = factorial.multiply(BigDecimal.valueOf(i));
        }

        //System.out.println("factorialInt = \n" + factorialInt);
        //System.out.println("factorialLong = \n" + factorialLong);

        //возвращают строку, потому что факториал числа 13 уже выходит за Integer.MAX_VALUE
        return String.valueOf(factorial);
    }
}
