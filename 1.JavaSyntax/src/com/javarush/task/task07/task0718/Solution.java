package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
Проверка на упорядоченность

Иерархия — первый страж порядка и боевое оружие диктатуры.
О диктатуре подумаем поже, а пока составим список из 10 слов.
Введём их с клавиатуры. Наша задача состоит в том, чтобы проверить,
является ли список упорядоченным по возрастанию длины строки.
Если нет, выводим на экран номер первого элемента, нарушающего такую упорядоченность.

Проверка на упорядоченность
1. Введи с клавиатуры 10 слов в список строк.
2. Определить, является ли список упорядоченным по возрастанию длины строки.
3. В случае отрицательного ответа вывести на экран номер первого элемента, нарушающего такую упорядоченность.


Требования:
1. Объяви переменную типа список строк и сразу проинициализируй ee.
2. Считай 10 строк с клавиатуры и добавь их в список.
3. Если список упорядочен по возрастанию длины строки, то ничего выводить не нужно.
4. Если список не упорядочен по возрастанию длины строки, то нужно вывести на экран номер первого элемента,
нарушающего такую упорядоченность.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            strings.add(reader.readLine());
        }

        int max = strings.get(0).length();
        int unkorrect = 0;

        for (int i = 1, next = 0; i < strings.size(); i++) {
            next = strings.get(i).length();

            if (max > next) {
                unkorrect = i;
                break;
            } else {
                max = next;
            }
        }

        if (unkorrect != 0) {
            //System.out.println(strings.get(unkorrect));
            System.out.println(unkorrect);
        }
    }
}

/*public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
    }
}*/

