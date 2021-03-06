package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 

Общение одиноких массивов

Давайте создадим не один, а сразу два массива!
В одном будет убежище для 10 чисел, в другом — для 10 строк.
Заполним массив строк с клавиатуры,
а в каждую ячейку массива чисел запишем длину строки из массива строк,
индекс ячейки которой совпадает с текущим индексом из массива чисел.
Затем выводим содержимое массива чисел на экран, и задача решена.

Общение одиноких массивов
1. Создать массив на 10 строк.
2. Создать массив на 10 чисел.
3. Ввести с клавиатуры 10 строк, заполнить ими массив строк.
4. В каждую ячейку массива чисел записать длину строки из массива строк,
индекс/номер ячейки которой совпадает с текущим индексом из массива чисел.

Вывести содержимое массива чисел на экран, каждое значение выводить с новой строки.


Требования:
1. Программа должна создавать массив на 10 строк.
2. Программа должна создавать массив на 10 целых чисел.
3. Программа должна считывать строки для массива с клавиатуры.
4. Программа должна в массив чисел записать длины строк из массива строк,
а затем их вывести на экран.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        String[] arrS = new String[10];
        int[] arrI = new int[10];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            arrS[i] = reader.readLine();
        }

        for (int i = 0; i < 10; i++) {
            arrI[i] = arrS[i].length();
        }

        for (int i:
             arrI) {
            System.out.println(i);
        }
    }
}

/*public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
    }
}*/
