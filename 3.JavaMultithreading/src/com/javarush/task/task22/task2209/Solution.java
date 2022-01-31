package com.javarush.task.task22.task2209;

/*
Составить цепочку слов
Составить цепочку слов: Arrays.sort(words, (o1, o2) -> { работает выборочно
В методе main считай с консоли имя файла,
который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder
 расставь все слова в таком порядке,
 чтобы последняя буква данного слова
 совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Считай, что абсолютно все слова из исходного
списка могут (и должны!) быть включены в результат (лишних слов нет).
Метод getLine должен возвращать любой правильный
вариант при наличии нескольких таковых (см. пример).
Слова разделять пробелом.
Вывести полученную строку на экран.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
или
Вена Амстердам Мельбурн Нью-Йорк Киев
или
Мельбурн Нью-Йорк Киев Вена Амстердам
и т.п.


Requirements:
1. Метод main должен считывать имя файла с клавиатуры.
2. В классе Solution не должно быть статических полей.
3. В методе getLine должен быть использован StringBuilder.
4. Метод getLine должен возвращать пустую строку
(пустой StringBuilder) в случае если ему не были переданы параметры (слова).
5. Метод getLine не должен изменять переданные ему параметры (слова).
6. Все слова переданные в метод getLine должны быть включены в результирующую строку.
7. Вывод на экран должен соответствовать условию задачи.

Тесты
Решила со стыдно сказать какой попытки! 😀
От радости делюсь тестами, собранными в комментариях:
Тест 1:   Киев Винница Нью-Йорк Киров Амстердам Вена Мельбурн
Тест 2:   Киев Нью-Йорк Афины Прага Вена Амстердам Мельбурн Алушта
Тест 3:  Венеция Ялта Минск Амстердам Москва Алушта Атланта Афины Ысити Столькольм Исбук Курск Кишинев Вена Астрахань Ьсити Иерусалим Мюнхен Норильск Канзас Киев
Тест 4:  Киев Нью-Йорк Амстердам Вена Мельбурн Милан
Тест 5:  Антверпен Прага Алушта
Тест 6:  Киев Нью-Йорк Роттердам Вена Мельбурн
Тест 7:  Дербент Якутск Арзамас Рог Киев Кувшиново Капустин-Яр Стокгольм Флоренция Глен-Хоп Тобольск Нью-Йорк Афины Муром Осташков Прага Кострома Вена Амстердам Мельбурн Волгоград Минск
Получилось только тогда, когда прошли все тесты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    // Лист листов со всеми возможными комбинациями
    private static List<List<String>> resultList = new ArrayList<>();

    public static void main(String[] args) {
        List<String> fileLines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fr = new BufferedReader(new FileReader(br.readLine()))) {
            while (fr.ready()) {
                fileLines.addAll(Arrays.asList(fr.readLine().split(" ")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] strings = new String[fileLines.size()];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = fileLines.get(i);
        }

        StringBuilder result = getLine(strings);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... wordss) {
        if (wordss.length == 0)
            return new StringBuilder();

        // Метод getLine не должен изменять переданные ему параметры (слова).
        String[] wordsStringArr = Arrays.copyOf(wordss, wordss.length);
        List<String> wordsListArr = new ArrayList<>();
        Collections.addAll(wordsListArr, wordsStringArr);
        //System.out.println("wordsListArr: " + wordsListArr);

        //getSortedListByEndToStartLetter(wordsListArr);
        recursionMethod(wordsStringArr, wordsStringArr.length);

        //System.out.println("result size = " + resultList.size());
        //printList(resultList);

        // Удаляет списки, которые не удовлетворяют условию
        // Оставляет те, в которых последняя буква слова
        // равна первой букве следующего слова
        deleteBadStrings(resultList);

       // printList(resultList);

        return printStringFromResult(0);
    }

    // Возвращает StringBuilder из resultList
    public static StringBuilder printStringFromResult(int index){
        ArrayList<String> arr = new ArrayList<>(resultList.get(index));
        StringBuilder sb = new StringBuilder();
        for (String s: arr){
            sb.append(s).append(" ");
        }
        return sb.deleteCharAt(sb.length()-1); // вернуть без пробела в конце
    }

    public static void deleteBadStrings(List<List<String>> list) {
        for (int i = 0; i < list.size(); i++) {
            if(!isStringTrue(list.get(i))){
                list.remove(i);
                i--;
            }
        }
    }

    // возвращает false, если последняя буква текущего слова не равна
    // первой букве следующего слова
    private static boolean isStringTrue(List<String> strings) {
        for (int i = 0; i < strings.size() - 1; i++) {
            String firstWord = strings.get(i).toLowerCase();
            char ch1 = firstWord.charAt(firstWord.length() - 1);
            String secondWord = strings.get(i + 1).toLowerCase();
            char ch2 = secondWord.charAt(0);
            if (ch1 != ch2)
                return false;
        }
        return true;
    }


    // Вывод List через StringBuilder
    public static void printList(List<List<String>> list) {
        // Вывод поля resultList
        for (List<String> ls : list) {
            StringBuilder sb = new StringBuilder();
            for (String s : ls) {
                sb.append(s).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }


    // return List содержащий все комбинации перестановок слов в виде листов
    // Записывает результат в поле класса
    public static void recursionMethod(String[] strings, int size) {
        // завершить рекурсионный вызов
        if (size < 2) {
            resultList.add(new ArrayList<>(Arrays.asList(strings)));
        } else {
            for (int i = 0; i < size; i++) {
                swap(strings, i, size - 1);
                recursionMethod(strings, size - 1);
                swap(strings, size - 1, i);
            }
        }
    }

    public static void swap(String[] strings, int i, int k) {
        String tmp = strings[i];
        strings[i] = strings[k];
        strings[k] = tmp;
    }

    public static List<String> getSortedListByEndToStartLetter(List<String> list) {
        List<String> copyOfList = new ArrayList<>(list);
        // если слово из массива from подходит, переносим его в массив to, удаляя из from
        List<String> from = new ArrayList<>(copyOfList);
        List<String> to = new ArrayList<>();
        // Индекс слова, которое изначально берется из From в массив То
        int indexOfTheFirstWordFromFrom = 0;
        int indexTo = 0; // индекс в массиве То, указывающий на слово с последней буквой
        int indexFrom = 0; // индекс в массиве from, указывающий на слово с первой буквой
        to.add(from.get(indexOfTheFirstWordFromFrom)); // добавить в массив То первое слово
        from.remove(indexOfTheFirstWordFromFrom); // удалить из массива from добавленное в То слово


        while (from.size() > 0) {
            String firstWord = to.get(indexTo); // последнее слово из массива То
            // Последняя буква слова в нижнем регистре
            char endOffirstWord = firstWord.toLowerCase().charAt(firstWord.length() - 1);
            String nextWord = from.get(indexFrom); // первое слово из массива from
            // Первая буква слова в нижнем регистре
            char startOfNextWord = nextWord.toLowerCase().charAt(0);

            if (endOffirstWord == startOfNextWord) {
                to.add(from.get(indexFrom));
                from.remove(indexFrom);
                indexTo++; // перейти к добавленному слову в массиве to
                indexFrom = 0; // начать перебор по массиу from сначала
            } else {
                indexFrom++; // перейти к следующему слову в массиве from
            }
        }

        // Если один проход не привел к успеху:
        // если дошли до конца массива from и массив to не заполнен,
        // восстановить массивы и добавить в массив to следующее слово,
        // от добавленного изначально
        if (indexFrom >= from.size() - 1 && to.size() != copyOfList.size()) {
            // Привести массивы в исходное состояние
            from.removeAll(from);
            from.addAll(copyOfList);
            to.removeAll(to);
            indexOfTheFirstWordFromFrom++;
            //indexTo=0; // индекс в массиве То, указывающий на слово с последней буквой
            indexFrom = 0; // индекс в массиве from, указывающий на слово с первой буквой
            to.add(from.get(indexOfTheFirstWordFromFrom)); // добавить в массив То первое слово
            from.remove(indexOfTheFirstWordFromFrom); // удалить из массива from добавленное в То слово
        }

        System.out.println("to: " + to);
        return to;
    }
}

/*
package com.javarush.task.task22.task2209;

/*
Составить цепочку слов
Составить цепочку слов
В методе main считай с консоли имя файла,
который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder
 расставь все слова в таком порядке,
 чтобы последняя буква данного слова
 совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Считай, что абсолютно все слова из исходного
списка могут (и должны!) быть включены в результат (лишних слов нет).
Метод getLine должен возвращать любой правильный
вариант при наличии нескольких таковых (см. пример).
Слова разделять пробелом.
Вывести полученную строку на экран.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
или
Вена Амстердам Мельбурн Нью-Йорк Киев
или
Мельбурн Нью-Йорк Киев Вена Амстердам
и т.п.


Requirements:
1. Метод main должен считывать имя файла с клавиатуры.
2. В классе Solution не должно быть статических полей.
3. В методе getLine должен быть использован StringBuilder.
4. Метод getLine должен возвращать пустую строку
(пустой StringBuilder) в случае если ему не были переданы параметры (слова).
5. Метод getLine не должен изменять переданные ему параметры (слова).
6. Все слова переданные в метод getLine должны быть включены в результирующую строку.
7. Вывод на экран должен соответствовать условию задачи.


public class Solution {
    public static void main(String[] args) {
        //...
        StringBuilder result = getLine();
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        return null;
    }
}

 */