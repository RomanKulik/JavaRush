package com.javarush.task.task07.task0724;

/*

Семейная перепись

Попробуем создать программу для семейной переписи.
Для этого пишем класс Human с полями имя(String), пол(boolean), возраст(int), отец(Human), мать(Human).
Для тренировки создайте объекты и заполните их данные так, чтобы получилось два дедушки,
две бабушки, отец, мать, трое детей. Выведите объекты на экран.

Семейная перепись
Семейная перепись
Создай класс Human с полями имя(String), пол(boolean), возраст(int), отец(Human), мать(Human).
Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей.
Вывести объекты на экран.

Примечание:
Если написать свой метод String toString() в классе Human,
то именно он будет использоваться при выводе объекта на экран.

Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. Добавить в класс Human поля: имя(String), пол(boolean), возраст(int), отец(Human), мать(Human).
3. Добавить в класс конструктор public Human(String name, boolean sex, int age).
4. Добавить в класс конструктор public Human(String name, boolean sex, int age, Human father, Human mother).
5. Создай 9 разных объектов типа Human (4 объекта без отца и матери и 5 объектов с ними)).
6. Выведи созданные объекты на экран.
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human h1 = new Human("name1", true, 20);
        Human h2 = new Human("name2", false, 21);
        Human h3 = new Human("name3", true, 22);
        Human h4 = new Human("name4", false, 23);

        Human h5 = new Human("name11", false, 10, h1, h2);
        Human h6 = new Human("name12", false, 11, h3, h4);
        Human h7 = new Human("name13", false, 12, h1, h4);
        Human h8 = new Human("name14", false, 13, h3, h2);
        Human h9 = new Human("name15", false, 14, null, h1);

        System.out.println(h1);
        System.out.println(h2);
        System.out.println(h3);
        System.out.println(h4);
        System.out.println(h5);
        System.out.println(h6);
        System.out.println(h7);
        System.out.println(h8);
        System.out.println(h9);
    }

    public static class Human {
        //напишите тут ваш код
        private String name = new String();
        private boolean sex;
        private int age = 0;
        private Human father;
        private Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this(name, sex, age);
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}

/*
public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
    }

    public static class Human {
        //напишите тут ваш код

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}
*/

