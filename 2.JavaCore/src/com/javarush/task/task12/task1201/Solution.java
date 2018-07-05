package com.javarush.task.task12.task1201;

/* 
В нормальной жизни кита с коровой не перепутать
(хотя в террианских водах порой встречаются морские коровы,
а на планетах Содружества и не такое встретишь!),
а вот в программировании — сколько угодно.
Напишем правильный геттер для класса кит, чтобы программа выдавала фразу «я не корова, я — кит».

Киты и коровы
Переопределить метод getName в классе Whale(Кит), чтобы программа выдавала:

Я не корова, Я - кит.


Требования:
1. Программа должна выводить текст на экран.
2. Класс Whale должен наследоваться от класса Cow.
3. Класс Whale должен переопределять метод getName().
4. Метод main() должен вызывать метод getName() у объекта cow.
5. Переопределить метод getName в классе Whale(Кит), чтобы программа выводила на экран: "Я не корова, Я - кит."
6. Метод main() должен выводить на экран результат вызова метода getName().
*/
public class Solution {
    public static void main(String[] args) {
        Cow cow = new Whale();

        System.out.println(cow.getName());
    }

    public static class Cow {
        public String getName() {
            return "Я - корова";
        }
    }

    public static class Whale extends Cow {
        public String getName() { return "Я не корова, Я - кит."; }
    }
}
/*public class Solution {
    public static void main(String[] args) {
        Cow cow = new Whale();

        System.out.println(cow.getName());
    }

    public static class Cow {
        public String getName() {
            return "Я - корова";
        }
    }

    public static class Whale extends Cow {
    }
}*/
