package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 

Родственные связи кошек

Готовая задача: у кошки есть имя и кошка-мама.
Создать класс, который это описывает.
Создать два объекта: кошку-дочь и кошку-маму.
Вывести их на экран.
Новая задача: У каждой кошки есть имя, кошка-папа и кошка-мама.
Изменить Cat так, чтобы он мог описать эту ситуацию.
Создать 6 объектов: дедушку (папин папа), бабушку (мамина мама), папу, маму, сына, дочь.

Родственные связи кошек
Задача:
У каждой кошки есть имя и кошка-мама.
Создать класс, который бы описывал данную ситуацию.
Создать два объекта: кошку-дочь и кошку-маму.
Вывести их на экран.

Новая задача:
У каждой кошки есть имя, кошка-папа и кошка-мама.
Изменить класс Cat так, чтобы он мог описать данную ситуацию.
Создать 6 объектов:
дедушку (папин папа), бабушку (мамина мама), папу, маму, сына, дочь.
Вывести их всех на экран в порядке: дедушка, бабушка, папа, мама, сын, дочь.

Пример ввода:
дедушка Вася
бабушка Мурка
папа Котофей
мама Василиса
сын Мурчик
дочь Пушинка

Пример вывода:
Cat name is дедушка Вася, no mother, no father
Cat name is бабушка Мурка, no mother, no father
Cat name is папа Котофей, no mother, father is дедушка Вася
Cat name is мама Василиса, mother is бабушка Мурка, no father
Cat name is сын Мурчик, mother is мама Василиса, father is папа Котофей
Cat name is дочь Пушинка, mother is мама Василиса, father is папа Котофей


Требования:
1. Программа должна считывать имена 6 котов в указанном порядке.
2. Метод main должен создавать 6 объектов типа Cat.
3. Программа должна выводить 6 строк с информацией о котах.
4. Строка про дедушку (первая) должна соответствовать условию.
5. Строка про бабушку (вторая) должна соответствовать условию.
6. Строка про папу (третья) должна соответствовать условию.
7. Строка про маму (четвертая) должна соответствовать условию.
8. Строка про сына (пятая) должна соответствовать условию.
9. Строка про дочь (шестая) должна соответствовать условию.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandPaName = reader.readLine();
        Cat catGrandPa = new Cat(grandPaName);

        String grandMaName = reader.readLine();
        Cat catGrandMa = new Cat(grandMaName);

        String paName = reader.readLine();
        Cat catPa = new Cat(paName, null, null, catGrandPa, null);

        String maName = reader.readLine();
        Cat catMa = new Cat(maName, null, null, null, catGrandMa);

        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName, catGrandPa, catGrandMa, catPa, catMa);

        String doughterName = reader.readLine();
        Cat catDoughter = new Cat(doughterName, catGrandPa, catGrandMa, catPa, catMa);

        System.out.println(catGrandPa);
        System.out.println(catGrandMa);
        System.out.println(catPa);
        System.out.println(catMa);
        System.out.println(catSon);
        System.out.println(catDoughter);
    }

    public static class Cat {
        private String name;
        private Cat grandFather;
        private Cat grandMother;
        private Cat father;
        private Cat mother;

        Cat(String name) {
            this.name = name;
        }

        public Cat(String name,
                   Cat grandFather, Cat grandMother,
                   Cat father, Cat mother) {
            this.name = name;
            this.grandFather = grandFather;
            this.grandMother = grandMother;
            this.mother = mother;
            this.father = father;
        }

        @Override
        public String toString() {

            // grands
            if(father == null && mother == null) {
                return "Cat name is " + name + ", no mother, no father";
                // for father
            } else if (mother == null) {
                return "Cat name is " + name + ", no mother, father is " + father.name;
                // for mother
            } else if (father == null) {
                return "Cat name is " + name + ", mother is " + mother.name + ", no father";
                // kids
            } else {
                return "Cat name is " + this.name + ", mother is " + mother.name + ", father is " + father.name;
            }
        }
    }
}
/*public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catMother);

        System.out.println(catMother);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat parent;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat parent) {
            this.name = name;
            this.parent = parent;
        }

        @Override
        public String toString() {
            if (parent == null)
                return "Cat name is " + name + ", no mother ";
            else
                return "Cat name is " + name + ", mother is " + parent.name;
        }
    }

}*/
