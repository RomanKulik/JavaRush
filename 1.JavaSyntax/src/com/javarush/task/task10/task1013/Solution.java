package com.javarush.task.task10.task1013;

/* 
Люди — разные, и у каждого человека различные важные особенности.
Скажем, этот — новорожденный, и у него есть только имя и мама,
а этот — музыкант, и для него важны уровень исполнительского мастерства и его группа.
Давайте напишем класс Human с 6 полями и придумаем для него 10 различных конструкторов.
Каждый конструктор должен иметь смысл.

Конструкторы класса Human
Напиши класс Human с 6 полями.
Придумай и реализуй 10 различных конструкторов для него.
Каждый конструктор должен иметь смысл.


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. В классе Human должно быть 6 полей.
3. Все поля класса Human должны быть private.
4. В классе Human должно быть 10 конструкторов.
5. Все конструкторы класса Human должны быть public.
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
        private String firstName;
        private String secondName;
        private int age;
        private boolean sex;
        private Human mother;
        private Human father;

        public Human(String firstName, int age, Human father) {
            this.firstName = firstName;
            this.age = age;
            this.father = father;
        }

        public Human () {
            super();
        }
        public Human (boolean isDefault) {
            this.firstName = "firstName";
            this.secondName = "secondName";
            this.age = 20;
            this.sex = true;
            this.mother = new Human();
            this.father = new Human();
        }
        public Human (boolean isDefault, boolean isMother) {
            this(true);
            this.mother = new Human(true);
        }
        public Human (boolean isDefault, boolean isMother, boolean isFather) {
            this(true);
            this.mother = new Human(true);
            this.father = new Human(true);
        }
        public Human (String firstName, String secondName) {
            this.firstName = firstName;
            this.secondName = secondName;
        }
        public  Human (int age, boolean sex) {
            this(true);
            this.age = age;
            this.sex = sex;
        }
        public Human (String firstName, String secondName, int age, boolean sex, Human mother, Human father) {
            this(firstName, secondName);
            this.age = age;
            this.sex = sex;
            this.mother = mother;
            this.father = father;
        }
        public Human (String firstName, String secondName, int age, boolean sex) {
            this(firstName, secondName);
            this.age = age;
            this.sex = sex;
            this.mother = new Human();
            this.father = new Human();
        }
        public Human (String firstName, boolean sex) {
            this(true);
            this.firstName = firstName;
            this.sex = sex;
        }
        public Human (String firstName, boolean sex, int age) {
            this(firstName, sex);
            this.age = age;
        }

    }
}
