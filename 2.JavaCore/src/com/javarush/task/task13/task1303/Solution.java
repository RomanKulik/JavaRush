package com.javarush.task.task13.task1303;

/* 
Пиво с колой не мешать
Что вы предпочитаете — пиво или колу?
Или, быть может, по настроению?
В любом случае самый логичный интерфейс пива с человеком или
там колы с человеком можно выразить одним коротким словом: «пить».
Или Drink, если по-английски.
Реализуйте интерфейс Drink в классах Beer и Cola.

Пиво с колой не мешать
Реализуй интерфейс Drink в классах Beer и Cola.


Требования:
1. Класс Beer должен реализовывать(implements) интерфейс Drink.
2. Класс Cola должен реализовывать(implements) интерфейс Drink.
3. В классе Beer должны быть реализованы все методы интерфейса Drink.
4. В классе Cola должны быть реализованы все методы интерфейса Drink.
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        print(new Beer());
        print(new Cola());
    }

    private static void print(Drink drink) {
        System.out.println(drink.getClass().getSimpleName());
    }

    public interface Drink {
        boolean isAlcoholic();
    }

    public static class Beer implements Drink{
        @Override
        public boolean isAlcoholic() {
            return true;
        }
    }

    public static class Cola implements Drink {
        @Override
        public boolean isAlcoholic() {
            return false;
        }
    }
}
/*public class Solution {
    public static void main(String[] args) throws Exception {
        print(new Beer());
        print(new Cola());
    }

    private static void print(Drink drink) {
        System.out.println(drink.getClass().getSimpleName());
    }

    public interface Drink {
        boolean isAlcoholic();
    }

    public static class Beer {

    }

    public static class Cola {

    }
}*/
