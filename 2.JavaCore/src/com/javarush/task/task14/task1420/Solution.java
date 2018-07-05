package com.javarush.task.task14.task1420;

import com.sun.javafx.binding.StringFormatter;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
НОД
Продолжаем наши попытки войти в космическое пространство планеты Линейный Хаос.
И вот ещё одно задание с приграничного собеседования для юных поступающих:
найти наибольший общий делитель (или НОД) двух целых положительных чисел.

НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.


Требования:
1. Программа должна считывать с клавиатуры 2 строки.
2. В случае если введенные строки невозможно преобразовать
в положительные целые числа, должно возникать исключение.
3. Программа должна выводить данные на экран.
4. Программа должна выводить на экран наибольший общий делитель(НОД)
чисел считанных с клавиатуры и успешно завершаться.
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        if (num1 <= 0 || num2 <= 0) {
            throw new IllegalArgumentException("Only positive numbers allowed");
        }

        int nod = 0;

        for (int i = 1; i <= Math.min(num1, num2); i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                nod = i;
            }
        }
        int n = num1;
        char ch = '%';
        for (int i = 0; i <= num2; i++) {
            System.out.printf("Остаток %d %c %d  = %d", i, ch, n, i%n);
            System.out.println();
        }

        //System.out.println(nod);

        while (num2 != 0) {
            num2 = num1%(num1 = num2); // в одну строку всё поместилось
            /*
            * 12 9              9 12
            * 9 = 12 %(9)       12 = 9 % 12
            * 3 = 9 % 3         9 = 12 % 9
            * 0                 3 = 9 % 3
            *                   0
            * */
        }
        //System.out.println(num1); // вычисленный  НОД

        System.out.println(gcd(num1, num2));

        //System.out.println(nod(num1, num2));
    }

    // через рекурсию
    private static int gcd(int a, int b) {
        //return b == 0 ? a : gcd (b, a % b);
        System.out.println("Recursion");
        if (b == 0) {
            System.out.println("return a (b = 0)");
            return a;
        } else {
            System.out.println("a = " + a);
            System.out.println("b = " + b);
            System.out.println("a%b = " + a % b);
            return gcd(b, a % b);
        }
    }

    // nod через побитовые операции
    public static int nod(int a, int b) {
        if (a == b) return a;
        if (a == 0) return b;
        if (b == 0) return a;
        if ((~a & 1) != 0) {
            if ((b & 1) != 0)
                return nod(a >> 1, b);
            else
                return nod(a >> 1, b >> 1) << 1;
        }
        if ((~b & 1) != 0)
            return nod(a, b >> 1);
        if (a > b)
            return nod((a - b) >> 1, b);
        return nod((b - a) >> 1, a);
    }
}
/*public class Solution {
    public static void main(String[] args) throws Exception {
    }
}*/
