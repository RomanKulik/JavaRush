package com.javarush.task.task06.task0619;

/* 

Три статические переменных name

Статические переменные несут огромную пользу, если ими не злоупотреблять.
И вообще… Их нужно понимать, холить и лелеять.
Сейчас вы получите код, в котором уже реализованы кое-какие классы.
Ваша задача состоит в том, чтобы дописать в код три public статические переменные:
String Solution.name, String Cat.name, String Dog.name.

Три статические переменных name
Добавь 3 public статических переменных:
String Solution.name, String Cat.name, String Dog.name.


Требования:
1. В класс Solution добавь public статическую переменную name типа String.
2. В класс Cat добавь public статическую переменную name типа String.
3. В класс Dog добавь public статическую переменную name типа String.
4. В каждом классе должна быть своя переменная name.
*/

public class Solution {
    public static String name;

    public static class Cat {
        public static String name;
    }

    public static class Dog {
        public static String name;
    }

    public static void main(String[] args) {

    }
}
