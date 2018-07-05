package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*

Омовение Рамы

Когда-то жил и правил легендарный древнеиндийский царь Рама.
И, вероятно, была та, которая его родила. Не факт, что она мыла его самостоятельно (царица всё-таки),
но да простят нам затоки эту невинную историческую фантазию.
Напишем программу, которая заменит текст «мама мыла раму» на «Мама Мыла Раму».

Омовение Рамы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
мама мыла раму.

Пример вывода:
Мама Мыла Раму.


Требования:
1. Программа должна выводить текст на экран.
2. Программа должна считывать строку с клавиатуры.
3. Класс Solution должен содержать один метод.
4. Программа должна заменять в тексте первые буквы всех слов на заглавные.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //напишите тут ваш код
        for (String st :
                s.split("\\b")) {
            System.out.print(st.substring(0, 1).toUpperCase() + st.substring(1));
        }

        /*char[] chars = new char[s.length()];
        chars[0] = Character.toUpperCase(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                while (ch == ' ') {
                    chars[i] = ch;
                    i++;
                    if (i == s.length() - 1) {
                        break;
                    }
                    ch = s.charAt(i);
                }
                chars[i] = Character.toUpperCase(s.charAt(i));
            } else {
                chars[i] = s.charAt(i);
            }
        }

        System.out.println(chars);*/


        /*int slenghth = s.length();
        char[] chars = new char[slenghth];
        char[] total = new char[slenghth];
        char space = ' ';

        chars = s.toCharArray();
        total[0] = Character.toUpperCase(chars[0]);

        for (int i = 1; i < slenghth; i++) {
            if (chars[i] == space) {
                total[i] = chars[i];
                total[i + 1] = Character.toUpperCase(chars[i + 1]);
                i++;
            } else {
                total[i] = chars[i];
            }
        }

        System.out.println(total);*/
    }
}
