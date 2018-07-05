package com.javarush.task.task06.task0613;

/* 

Кот и статика

Солнце встает. Задачи всё сложнее: изучаем static’и.
В этот раз нам нужно в классе Cat создать статическую переменную catCount и конструктор [public Cat()].
Пусть при каждом создании кота (нового объекта Cat) статическая переменная catCount увеличивается на 1.
Нам нужно создать десяток котов и вывести значение переменной catCount на экран.

Кот и статика
В классе Cat создай статическую переменную public int catCount.
Создай конструктор [public Cat()]. Пусть при каждом создании кота (нового объекта Cat)
статическая переменная catCount увеличивается на 1.
Создать 10 объектов Cat и вывести значение переменной catCount на экран.


Требования:
1. В классе Cat создай статическую переменную public int catCount.
2. В классе Cat создай создай конструктор public Cat().
3. Конструктор должен увеличивать значение статической переменной catCount на 1.
4. В методе main создай 10 котов.
5. В методе main, после создания котов, выведи значение переменной catCount.
*/

public class Solution {
    public static void main(String[] args) {
        //создай 10 котов
        int size = 10;
        Cat[] cats = new Cat[size];

        for (int i = 0; i < size; i++) {
            cats[i] = new Cat();
        }

        //выведи значение переменной catCount
        System.out.println(Cat.catCount);
    }

    public static class Cat {
        //создай статическую переменную catCount
        public static int catCount = 0;

        //создай конструктор
        public Cat() {
            catCount++;
        }
    }
}

/*
public class Solution {
    public static void main(String[] args) {
        //создай 10 котов

        //выведи значение переменной catCount
    }

    public static class Cat {
        //создай статическую переменную catCount

        //создай конструктор
    }
}
*/
