package com.javarush.task.task10.task1016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

/* 
Поиск аналогов и совпадений — любимое занятие программистов.
Давайте проделаем вот что: введем с клавиатуры в список 20 слов и подсчитаем,
сколько одинаковых слов в этом списке.
Результат представим в виде словаря Map<String, Integer>, где первый параметр – уникальная строка,
а второй – число (сколько раз данная строка встречалась в списке).

Одинаковые слова в списке
Ввести с клавиатуры в список 20 слов.
Нужно подсчитать количество одинаковых слов в списке.
Результат нужно представить в виде словаря Map<String, Integer>, где первый параметр – уникальная строка, а второй – число, сколько раз данная строка встречалась в списке.

Вывести содержимое словаря на экран.
В тестах регистр (большая/маленькая буква) влияет на результат.


Требования:
1. Метод countWords должен объявлять и инициализировать HashMap с типом элементов .
2. Метод countWords должен возвращать созданный словарь.
3. Метод countWords должен добавлять в словарь ключи, соответствующие уникальным строкам,
    и значения по этим ключам, отображающие сколько раз встречалась строка.
4. Программа должна выводить на экран полученный словарь.
5. Метод main должен вызывать метод countWords.
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            words.add(reader.readLine());
        }

        Map<String, Integer> map = countWords(words);

        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    public static Map<String, Integer> countWords(ArrayList<String> list) {
        HashMap<String, Integer> result = new HashMap<String, Integer>();

        /*for(String s : list){
            result.merge(s, 1, Integer::sum);
        }*/

        list.forEach(item -> result.put(item, Collections.frequency(list, item)));

        //напишите тут ваш код
        /*for (String s:
             list) {
            Integer integer = Integer.valueOf(0);
            if(result.containsKey(s)) {
                integer = result.get(s);
            }
            result.put(s, ++integer);
        }*/
        return result;

    }
}
/*public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            words.add(reader.readLine());
        }

        Map<String, Integer> map = countWords(words);

        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    public static Map<String, Integer> countWords(ArrayList<String> list) {
        HashMap<String, Integer> result = new HashMap<String, Integer>();

        //напишите тут ваш код


        return result;
    }

}*/

