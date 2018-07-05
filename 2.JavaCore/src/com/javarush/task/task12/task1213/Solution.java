package com.javarush.task.task12.task1213;

/* 
В этой серии драмы «Исправь код» молодой,
но весьма перспективный программис-стажёр снова борется с нечистью и… котятами.
Котята очень милы, не так ли? Или не так?? Это вы расскажете заводчице котов Павловне (если рискнёте!),
а нам нужно, чтобы вы исправили код так, чтобы программа компилировалась.

«Исправь код», часть 2
Исправь код, чтобы программа компилировалась.


Требования:
1. Класс Pet должен быть статическим.
2. Класс Pet должен иметь два метода.
3. Метод getChild() должен быть абстрактным.
4. Класс Pet должен быть объявлен с модификатором, который запрещает создавать конкретные объекты этого класса.
*/
public class Solution {
    public static void main(String[] args) {

    }

    public static abstract class Pet {
        public String getName() {
            return "Я - котенок";
        }

        public abstract Pet getChild();
    }

}
/*public class Stringolution {
    public static void main(String[] args) {

    }

    public static class Pet {
        public String getName() {
            return "Я - котенок";
        }

        public Pet getChild();
    }

}*/
