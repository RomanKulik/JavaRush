package com.javarush.task.task12.task1214;

/* 
Во время межгалактической переписи, земных коров не внесли в единый реестр животных,
перепутав их с невероятно на них похожей разумной формой жизни с планеты МуУлинг.
Будьте программистом, исправьте эту оплошность.
Унаследуйте класс Cow от класса Animal и допишите коровке недостающие методы.

Корова — тоже животное
Унаследуй класс Cow от Animal.
Реализуй все недостающие методы в классе Cow.


Требования:
1. Класс Animal должен быть абстрактным.
2. Класс Cow не должен быть абстрактным.
3. Класс Cow должен наследоваться от класса Animal.
4. Класс Cow должен реализовать абстрактный метод из класса Animal.
5. Метод getName() класса Cow должен возвращать любое имя коровы.
*/
public class Solution {
    public static void main(String[] args) {

    }

    public static abstract class Animal {
        public abstract String getName();
    }

    public static class Cow extends Animal{
        @Override
        public String getName() {
            return "Машка";
        }
    }

}
/*public class Solution {
    public static void main(String[] args) {

    }

    public static abstract class Animal {
        public abstract String getName();
    }

    public static class Cow {
    }

}*/
