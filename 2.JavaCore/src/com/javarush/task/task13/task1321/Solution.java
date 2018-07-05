package com.javarush.task.task13.task1321;


/* 
Исправление ошибок

Корректируем код, который работает совсем не так, как мы хотим, а то и вовсе не работает.
Вам предстоит переделать наследование в классах и интерфейсах таким образом,
чтобы программа компилировалась и продолжала делать то же самое.
При этом класс Hobbie должен наследоваться от интерфейсов Desire и Dream.

Исправление ошибок
1. Переделай наследование в классах и интерфейсах так, чтобы программа компилировалась и продолжала делать то же самое.
2. Класс Hobbie должен наследоваться от интерфейсов Desire, Dream.


Требования:
1. Интерфейс Desire должен быть реализован в классе Hobbie.
2. Интерфейс Dream должен быть реализован в классе Hobbie.
3. Класс Hobbie должен содержать статическую переменную INDEX.
4. Метод toString в классе Hobbie должен инкрементировать и возвращать переменную INDEX в виде строки.
*/
public class Solution {

    public static void main(String[] args) throws Exception {
        System.out.println(Dream.HOBBIE.toString());
        System.out.println(new Hobbie().INDEX);
    }

    interface Desire {
    }

    interface Dream {
        public static Hobbie HOBBIE = new Hobbie();
    }

    static class Hobbie implements Desire, Dream {
        static int INDEX = 1;

        @Override
        public String toString() {
            INDEX++;
            return "" + INDEX;
        }
    }

}
/*public class Solution {

    public static void main(String[] args) throws Exception {
        System.out.println(Dream.HOBBIE.toString());
        System.out.println(new Hobbie().INDEX);
    }

    interface Desire {
    }

    interface Dream implements Desire{
        public static Hobbie HOBBIE = new Hobbie();
    }

    static class Hobbie extends Desire, Dream {
        static int INDEX = 1;

        @Override
        public String toString() {
            INDEX++;
            return "" + INDEX;
        }
    }

}*/
