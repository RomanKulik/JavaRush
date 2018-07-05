package com.javarush.task.task08.task0824;

/*

Собираем семейство

Попробуем создать программу для семейной переписи.
Для этого пишем класс Human с полями
имя(String), пол(boolean), возраст(int), дети (ArrayList Human).
Для тренировки создайте объекты и заполните их данные так, чтобы получилось
два дедушки, две бабушки, отец, мать, трое детей. Выведите объекты на экран.

Собираем семейство
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.

Требования:
1. Программа должна выводить текст на экран.
2. Класс Human должен содержать четыре поля.
3. Класс Human должен содержать один метод.
4. Класс Solution должен содержать один метод.
5. Программа должна создавать объекты и заполнять их так, чтобы получилось:
два дедушки, две бабушки, отец, мать, трое детей.
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human gp1 = new Human();
        gp1.name = "gp1";
        gp1.sex = true;
        gp1.age = 99;

        Human gp2 = new Human();
        gp2.name = "gp2";
        gp2.sex = true;
        gp2.age = 88;

        Human gm1 = new Human();
        gm1.name = "gm1";
        gm1.sex = false;
        gm1.age = 98;

        Human gm2 = new Human();
        gm2.name = "gm2";
        gm2.sex = false;
        gm2.age = 87;

        Human fa = new Human();
        fa.name = "fa";
        fa.sex = true;
        fa.age = 33;

        Human mo = new Human();
        mo.name = "mo";
        mo.sex = false;
        mo.age = 30;

        Human ch1 = new Human();
        ch1.name = "ch1";
        ch1.sex = false;
        ch1.age = 15;

        Human ch2 = new Human();
        ch2.name = "ch2";
        ch2.sex = true;
        ch2.age = 10;

        Human ch3 = new Human();
        ch3.name = "ch3";
        ch3.sex = true;
        ch3.age = 5;

        gp1.children.add(fa);
        gm1.children.add(fa);

        gp2.children.add(mo);
        gm2.children.add(mo);

        fa.children.add(ch1);
        fa.children.add(ch2);
        fa.children.add(ch3);

        mo.children.add(ch1);
        mo.children.add(ch2);
        mo.children.add(ch3);

        System.out.println(gp1);
        System.out.println(gp2);
        System.out.println(gm1);
        System.out.println(gm2);
        System.out.println(fa);
        System.out.println(mo);
        System.out.println(ch1);
        System.out.println(ch2);
        System.out.println(ch3);
    }

    public static class Human {
        //напишите тут ваш код
        ArrayList<Human> children = new ArrayList<>();
        String name;
        boolean sex;
        int age;

        static {

        }


        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
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

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
*/
