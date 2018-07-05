package com.javarush.task.task01.task0140;

import java.util.Scanner;

/* 
Выводим квадрат числа
Требования:
1. Программа должна выводить текст.
2. В программе необходимо создать объект типа Scanner.
3. Программа должна считывать данные с клавиатуры.
4. Программа должна выводить квадрат считанного числа.
*/

public class Solution {
    public static void main(String[] args) {
        int a;
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        System.out.println(a * a);
    }
}