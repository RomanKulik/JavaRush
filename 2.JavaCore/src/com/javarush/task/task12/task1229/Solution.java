package com.javarush.task.task12.task1229;

/* 
Родитель класса CTO
Знаете ли вы, откуда берутся станции технического обслуживания?
Как и продукты в магазинах, они не самозарождаются в недрах планеты.
За ними стоят люди, роботы и маллорианцы.
В нашей задаче нужно классу СТО добавить правильного родителя,
и сделать это нужно так, чтобы класс перестал быть абстрактным.

Родитель класса CTO
Добавь такой класс-родитель к классу CTO(технический директор), чтобы класс перестал быть абстрактным.
Добавлять/реализовывать методы в классе CTO запрещается.


Требования:
1. Класс Solution должен содержать интерфейс Businessman с методом void workHard().
2. Класс Solution должен содержать не абстрактный класс CTO.
3. Класс CTO должен реализовывать интерфейс Businessman.
4. Класс CTO не должен содержать методов.
5. Класс Solution должен содержать дополнительный класс.
6. Класс CTO должен наследоваться от дополнительного класса.
7. Дополнительный класс должен содержать один метод.
*/
public class Solution {

    public static void main(String[] args) {
        CTO cto = new CTO();
        System.out.println(cto);
    }

    public static interface Businessman {
        public void workHard();
    }

    public static class aCTO implements Businessman {
        @Override
        public void workHard() {

        }
    }

    public static class CTO extends aCTO implements Businessman {

    }
}
/*public class Solution {

    public static void main(String[] args) {
        CTO cto = new CTO();
        System.out.println(cto);
    }

    public static interface Businessman {
        public void workHard();
    }

    public static class CTO extends aCTO implements Businessman {

    }
}*/
