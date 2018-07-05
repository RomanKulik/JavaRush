package com.javarush.task.task11.task1110;

/* 
«Инкапсулировать» — это вроде как помещать в капсулы, чтобы сберечь целостность объекта.
При написании этой задачи мы сначала создали капсулы, то есть, специальные методы, а вот поля,
которые нужно инкапсулировать — позабыли.
Изучите код и исправьте эту оплошность, наполните капсулы смыслом.

Не забываем инкапсулировать
Посмотри внимательно на методы и добавь недостающие поля.


Требования:
1. В классе Cat должно быть поле типа String с именем name.
2. В классе Cat должно быть поле типа int с именем age.
3. В классе Cat должно быть поле типа int с именем weight.
4. В классе Cat должно быть поле типа int с именем speed.
5. В классе Cat должны быть 4 поля.
6. Все поля класса Cat должны быть private.
*/
public class Solution {
    public static void main(String[] args) {
    }

    public class Cat {
        private String name;
        private int age;
        private int weight;
        private int speed;

        public Cat(String name, int age, int weight) {

        }

        public String getName() {
            return null;
        }

        public int getAge() {
            return 0;
        }

        public void setWeight(int weight) {

        }

        public void setSpeed(int speed) {

        }
    }
}
/*public class Solution {
    public static void main(String[] args) {
    }

    public class Cat {

        public Cat(String name, int age, int weight) {

        }

        public String getName() {
            return null;
        }

        public int getAge() {
            return 0;
        }

        public void setWeight(int weight) {

        }

        public void setSpeed(int speed) {

        }
    }
}*/
