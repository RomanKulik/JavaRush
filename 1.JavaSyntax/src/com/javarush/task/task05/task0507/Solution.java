package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
Требования:
1. Программа должна считывать данные с клавиатуры.
2. Программа должна выводить данные на экран.
3. Если ввести: 1 2 2 4 5 -1, программа должна вывести 2.8.
4. Если ввести: -100 0 100 -1, программа должна вывести 0.0.
5. Если ввести: 1 -1, программа должна вывести 1.0.
6. Выведенный результат должен соответствовать заданию для любых входных данных.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int counter = 0;
        double num = 0;
        double sum = 0;

        do {
            num = Double.parseDouble(reader.readLine());
            if(num != -1) {
                sum += num;
                counter++;
            }
        }
        while (num != -1);

        System.out.println(sum / counter);
    }
}

