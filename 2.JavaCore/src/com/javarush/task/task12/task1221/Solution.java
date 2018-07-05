package com.javarush.task.task12.task1221;

/* 
Вам было бы приятно, если бы вас называли Пушистиком?
А если при этом вы — рыжая гроза района, потерявшая глаз в районной бойне за территорию?
Представляете, такой бравый земной кот, главный на улице — и вдруг — Пушистик! Собакам на смех.
Помогите коту сохранить гордость, переопределите метод getName.

Все мы немного кошки…
Переопредели метод getName в классе Cat так, чтобы программа выдавала на экран надпись «Я - кот».


Требования:
1. Класс Solution должен содержать класс Pet.
2. Класс Solution должен содержать класс Cat.
3. Класс Cat должен наследоваться от класса Pet.
4. Класс Pet должен содержать один метод getName().
5. Класс Cat должен переопределять метод getName().
6. Программа должна выводить на экран результат метода getName() объекта pet.
*/
public class Solution {
    public static void main(String[] args) {
        Pet pet = new Cat();

        System.out.println(pet.getName());
    }

    public static class Pet {
        public String getName() {
            return "Я - пушистик";
        }
    }

    public static class Cat extends Pet {
        @Override
        public String getName() { return "Я - кот"; }
    }
}
/*public class Solution {
    public static void main(String[] args) {
        Pet pet = new Cat();

        System.out.println(pet.getName());
    }

    public static class Pet {
        public String getName() {
            return "Я - пушистик";
        }
    }

    public static class Cat extends Pet { }
}*/
