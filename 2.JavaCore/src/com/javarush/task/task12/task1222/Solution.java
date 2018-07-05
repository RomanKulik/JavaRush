package com.javarush.task.task12.task1222;

/* 
Итак, оказалось, что рыжую бестию, месяцами воевавшую за власть в объединении
Семи Дворов и Пятой Проходной, хозяева назвали Пушистиком.
Бестия не хочет быть Пушистиком. Нужно поменять исходные данные и переопределить метод setName.
Иначе не видать Бестии власти, как своего отражения в зеркале.

Больше не Пушистик
Переопредели метод setName в классе Cat так, чтобы программа выдавала на экран надпись

«Я - кот»


Требования:
1. Класс Solution должен содержать класс Pet.
2. Класс Solution должен содержать класс Cat.
3. Класс Cat должен наследоваться от класса Pet.
4. Класс Pet должен содержать два метода getName() и setName().
5. Класс Cat должен переопределять метод setName().
6. Программа должна выводить на экран результат метода getName() объекта pet.
*/
public class Solution {
    public static void main(String[] args) {
        Pet pet = new Cat();
        pet.setName("Я - пушистик");

        System.out.println(pet.getName());
    }

    public static class Pet {
        protected String name;

        public Pet() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    public static class Cat extends Pet {
        @Override
        public void setName(String name) {
            this.name = "Я - кот";
        }
    }
}
/*public class Solution {
    public static void main(String[] args) {
        Pet pet = new Cat();
        pet.setName("Я - пушистик");

        System.out.println(pet.getName());
    }

    public static class Pet {
        protected String name;

        public Pet() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    public static class Cat extends Pet {

    }
}*/
