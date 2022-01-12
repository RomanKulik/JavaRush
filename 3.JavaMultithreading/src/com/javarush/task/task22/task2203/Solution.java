package com.javarush.task.task22.task2203;

/* 
Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.


Requirements:
1. Класс TooShortStringException должен быть потомком класса Exception.
2. Метод getPartOfString должен принимать строку в качестве параметра.
3. В случае, если строка, переданная в метод getPartOfString
содержит менее 2 табуляций должно возникнуть исключение TooShortStringException.
4. Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
*/

public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null)
            throw new TooShortStringException();

        String[] stringSplitedByTabs = string.split("\\t");

        if (stringSplitedByTabs.length < 3)
            throw new TooShortStringException();

        return stringSplitedByTabs[1];

       /* int firstTab = string.indexOf("\t");
        int secondTab = string.indexOf("\t", firstTab + 1);
        if (firstTab == -1 || secondTab == -1)
            throw new TooShortStringException();

        return string.substring(firstTab, secondTab).trim();*/
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
       /* System.out.println(Arrays.toString("I love Java -3".split(" ", -3)));
        System.out.println(Arrays.toString("I love Java -2".split(" ", -2)));
        System.out.println(Arrays.toString("I love Java -1".split(" ", -1)));
        System.out.println(Arrays.toString("I love Java 0".split(" ", 0)));
        System.out.println(Arrays.toString("I love Java 1".split(" ", 1)));
        System.out.println(Arrays.toString("I love Java 2".split(" ", 2)));
        System.out.println(Arrays.toString("I love Java 3".split(" ", 3)));*/
    }
}


/*
package com.javarush.task.task22.task2203;

/*
Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.


Requirements:
1. Класс TooShortStringException должен быть потомком класса Exception.
2. Метод getPartOfString должен принимать строку в качестве параметра.
3. В случае, если строка, переданная в метод getPartOfString содержит менее 2 табуляций должно возникнуть исключение TooShortStringException.
4. Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.


public class Solution {
    public static String getPartOfString(String string) {
        return null;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
 */