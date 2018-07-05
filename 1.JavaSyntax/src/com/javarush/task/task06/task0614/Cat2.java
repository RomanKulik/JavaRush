package com.javarush.task.task06.task0614;

import java.util.ArrayList;

/* 

Статические коты

Статический кот — всем котам кот. Поэтому в этой задаче в классе Cat добавляем статическую переменную cats.
Пусть при каждом создании кота (нового объекта Cat) в переменную cats добавляется этот новый кот.
Нам нужно создать 10 объектов Cat, а затем метод printCats должен выводить всех котов на экран.

Статические коты
1. В классе Cat добавь public статическую переменную cats (ArrayList<Cat>).
2. Пусть при каждом создании кота (нового объекта Cat) в переменную cats добавляется этот новый кот.
Создать 10 объектов Cat.
3. Метод printCats должен выводить всех котов на экран. Нужно использовать переменную cats.


Требования:
1. Добавь в класс Cat public статическую переменную cats (ArrayList).
2. Переменная cats должна быть проинициализирована.
3. Метод main должен создавать 10 объектов Cat.
4. Метод main должен добавить всех созданных котов в переменную cats.
5. Метод printCats должен выводить всех котов из переменной cats на экран. Каждого с новой строки.
*/

public class Cat2 {
    //напишите тут ваш код
    public static ArrayList cats;
    public static int catCount = 0;

    public int catNumber = 0;

    static {
        cats = new ArrayList<>();
    }

    public Cat2() {
        catCount++;
        this.catNumber = catCount;
        System.out.println("Cat " + catCount + " added to ArrayList!");
    }


    public static void main(String[] args) {
        printCats();
        //напишите тут ваш код
        int size = 10;
        for (int i = 0; i < size; i++) {
            cats.add(i, new Cat2());
        }

        printCats();
    }

    public static void printCats() {
        //напишите тут ваш код
        for (int i = 0; i < cats.size(); i++) {
         //System.out.println("Cat \t№" + cats.get(i).catNumber + "\t\tcame!");
            System.out.println(cats.get(i));
         }
        /*for (Cat2 cat:
                cats) {
            System.out.println(cat);
        }*/
    }
}
