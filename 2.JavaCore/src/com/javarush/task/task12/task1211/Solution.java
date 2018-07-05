package com.javarush.task.task12.task1211;

/* 
Ферма «Добрососедство» принимает любых домашних животных,
включая маргиналов и беглых каторжников со всей галактики.
Но те, кто содержат ферму, не знают, каких именно животных
в следующий раз доставит поезд межгалактической железной дороги.
Создадим для «Добрососедства» абстрактный класс Pet, во избежание недоразумений.

Абстрактный класс Pet
Сделать класс Pet абстрактным.


Требования:
1. Программа не должна выводить текст на экран.
2. Класс Pet должен быть статическим.
3. Класс Pet должен быть абстрактным.
4. Класс Pet должен иметь один метод getName().
*/
public class Solution {
    public static void main(String[] args) {

    }

    public abstract static class Pet {
        public String getName() {
            return "Я - котенок";
        }
    }

}
/*public class Solution {
    public static void main(String[] args) {

    }

    public static class Pet {
        public String getName() {
            return "Я - котенок";
        }
    }

}*/
