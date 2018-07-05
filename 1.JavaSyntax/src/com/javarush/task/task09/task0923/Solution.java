package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*

Гласные и согласные

Это мы с вами чётко знаем, какие буквы гласные, а какие – согласные.
Нам предстоит этому учить умных роботов, поэтому напишем программку для их обучения.
В ней пользователь будет вводить с клавиатуры строку текста,
а специальный метод поможет разделить данные на две строки, одна со всеми гласными введенной строки,
вторая — только с согласными.

Гласные и согласные
Написать программу, которая вводит с клавиатуры строку текста.
Программа должна вывести на экран две строки:
1. первая строка содержит только гласные буквы из введённой строки.
2. вторая — только согласные буквы и знаки препинания из введённой строки.
Буквы соединять пробелом, каждая строка должна заканчиваться пробелом.
Пример ввода:
Мама мыла раму.

Пример вывода:
а а ы а а у
М м м л р м .


Требования:
1. Программа должна считывать данные с клавиатуры.
2. Программа должна выводить две строки.
3. Первая строка должна содержать только гласные буквы из введенной строки, разделенные пробелом.
4. Вторая строка должна содержать только согласные и знаки препинания из введенной строки, разделенные пробелом.
5. Каждая строка должна заканчиваться пробелом.
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        /*Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        char[] chars = string.toCharArray();
        List<Character> glas = new ArrayList<>();
        List<Character> sogl = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            if (isVowel(chars[i])) {
                glas.add(chars[i]);
            } else {
                sogl.add((chars[i]));
            }
        }

       printArr(glas);
        System.out.println();
        printArr(sogl);*/

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        String s = reader.readLine();

        for(int i = 0; i < s.length(); i++){
            if (isVowel(s.charAt(i))){
                s1.append(s.charAt(i)).append(" ");
            } else if (!(s.charAt(i) == ' ')) {
                s2.append(s.charAt(i)).append(" ");
            }
        }
        System.out.println(s1.append("\n").append(s2));
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }

    public static void printArr(List<Character> list) {
        for (char c:
                list) {
            if (c == ' ') {
                continue;
            }
            System.out.print(c + " ");
        }
    }
}