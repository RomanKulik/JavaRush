package com.javarush.task.task12.task1202;

/* 
Переопределение методов в Java — очень сильный инструмент.
Так что усваиваем его на практике, начинаем прямо сейчас.
У нас есть кит, потомок коровы. Не спрашивайте, почему так получилось.
Дело семейное… Переопределим геттер киту так, чтобы на экран не выводилось сообщение, что он — корова.

Кит, коровий потомок
Переопределить метод getName в классе Whale(Кит), чтобы программа ничего не выводила на экран.


Требования:
1. Программа не должна выводить текст на экран.
2. Класс Whale должен наследоваться от класса Cow.
3. Класс Whale должен переопределять метод getName().
4. Метод main() должен вызывать метод getName() у объекта cow.
5. Реализуй метод getName() класса Whale чтобы программа ничего не выводила на экран.
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
        @Override
        public String getName() {
            return "";
        }
    }
}

/*
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

    }
}*/
