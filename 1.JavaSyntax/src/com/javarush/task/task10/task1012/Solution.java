package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Вам никогда не казалось, что букв в алфавите — слишком много?
Компьютеры вполне обходятся двумя, а у нас их целых 33.
Непозволительная избыточность!
Тем не менее, приходится мириться с реальностью и решать соответствующие задачи.
Вот одна из них: введите с клавиатуры 10 строчек и подсчитайте в них количество различных букв

Количество букв
Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 маленьких букв алфавита).
Результат вывести на экран в алфавитном порядке.

Пример вывода:
а 5
б 8
в 3
г 7
д 0
…
я 9


Требования:
1. Программа должна считывать данные с клавиатуры.
2. Программа должна выводить текст на экран.
3. Выведенный текст должен содержать 33 строки.
4. Каждая строка вывода должна содержать букву русского алфавита,
пробел и сколько раз буква встречалась в введенных строках.
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        // напишите тут ваш код

        for (char c :
                alphabet) {
            int n = 0;
            for (String s:list) {
                for (char ch :
                        s.toCharArray()) {
                    if (c == ch) {
                        n++;
                    }
                }
            }
            System.out.println(c + " " + n);
        }

        /* int[] indexes = new int[abc.length()];
        Arrays.fill(indexes, 0);

        for (String s:
             list) {
            for (int i = 0, sLen = s.length(); i < sLen; i++) {
                if (alphabet.contains(s.charAt(i))) {
                    Integer index = Arrays.binarySearch(abcArray, s.charAt(i));
                    ++indexes[index];
                }
            }
        }

        for (int i = 0; i < abc.length(); i++) {
            System.out.println(abcArray[i] + " " + indexes[i]);
        }*/


        // напишите тут ваш код
        /*Map<Character, Integer> characterIntegerTreeMap = new TreeMap<Character, Integer>();
        //Iterator<Map.Entry<Character, Integer>> iterator = characterIntegerTreeMap.entrySet().iterator();

        for (int i = 0, len = abc.length(); i < len; i++) {
            characterIntegerTreeMap.put(abc.charAt(i), 0);
        }

        for (int i = 0, lenList = list.size(); i < lenList; i++) {
            String string = list.get(i);
            for (int j = 0, lenString = string.length(); j < lenString; j++) {
                Character character = string.charAt(j);
                if (characterIntegerTreeMap.containsKey(character)) {
                    Integer value = characterIntegerTreeMap.get(character);
                    characterIntegerTreeMap.put(character, ++value);
                }
            }
        }

       characterIntegerTreeMap.forEach((character, integer) -> {
           System.out.println(character + " " + integer);
       }); */
    }

}
/*public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }


        // напишите тут ваш код
    }

}*/
