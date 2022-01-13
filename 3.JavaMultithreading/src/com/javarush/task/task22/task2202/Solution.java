package com.javarush.task.task22.task2202;

/* 
Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная
с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.

Пример:
"JavaRush - лучший сервис обучения Java."

Результат:
"- лучший сервис обучения"

Пример:
"Амиго и Диего лучшие друзья!"

Результат:
"и Диего лучшие друзья!"

На некорректные данные бросить исключение TooShortStringException (сделать исключением).


Requirements:
1. Класс TooShortStringException должен быть потомком класса RuntimeException.
2. Метод getPartOfString должен принимать строку в качестве параметра.
3. В случае, если в метод getPartOfString были переданы некорректные данные,
должно возникнуть исключение TooShortStringException.
4. Метод getPartOfString должен возвращать подстроку начиная
с символа после 1-го пробела и до конца слова, которое следует после 4-го пробела.
*/

public class Solution {
    public static void main(String[] args) throws TooShortStringException {
        // "- лучший сервис обучения"
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        // "и Диего лучшие друзья!"
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        String[] splitWithSpaces = string.split(" ");

        if (splitWithSpaces.length < 5) throw new TooShortStringException();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i < 5; i++) {
            stringBuilder.append(splitWithSpaces[i]);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();

        /*if (string == null)
            throw new TooShortStringException();

        // Если в строке меньше 5-ти слов,
        // то будет меньше 4-х пробелов
        String[] words = string.split(" ");
        if (words.length < 5)
            throw new TooShortStringException();

        // Строка после первого пробела
        String stringAfterFirstSpace = string.substring(string.indexOf(" ") + 1);
        int posOf3rdSpace = getPosOfCharAtStringByCount(stringAfterFirstSpace, " ", 3);

        StringBuilder sb = new StringBuilder();
        // Строка до 3-го пробела
        sb.append(stringAfterFirstSpace.substring(0, posOf3rdSpace));
        sb.append(" ");
        // слово после 3-го пробела
        sb.append(words[4]);

        return sb.toString();*/
    }

    // Возвращает позицию символа по счету его вхождения, например, 3-й пробел
    public static int getPosOfCharAtStringByCount(String sting, String substring, int count) {
        int pos = sting.indexOf(substring);
        while (--count > 0 && pos != -1)
            pos = sting.indexOf(substring, pos + 1);

        return pos;
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
