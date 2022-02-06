package com.javarush.task.task23.task2310;

/* 
Напряги извилины!
Напряги извилины! - Метод printName должен выводить имя собственного объекта,
т.е. "The Darkside Hacker"
Сделайте минимум изменений.


Requirements:
1. Вывод на экран должен соответствовать условию.
2. В классе Solution должен присутствовать метод sout без параметров.
3. В классе Solution должно присутствовать поле name.
4. Модификатор доступа метода getName должен быть расширен.
*/

public class Solution {
    private String name;

    Solution(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    private void sout() {
        new Solution("The Darkside Hacker") {
            void printName() {
                System.out.println(getName());
            }
        }.printName();
    }


    public static void main(String[] args) {
        new Solution("Риша").sout();
    }
}

/*
package com.javarush.task.task23.task2310;

/*
Напряги извилины!
Напряги извилины!
Метод printName должен выводить имя собственного объекта,
т.е. "The Darkside Hacker"
Сделайте минимум изменений.


Requirements:
1. Вывод на экран должен соответствовать условию.
2. В классе Solution должен присутствовать метод sout без параметров.
3. В классе Solution должно присутствовать поле name.
4. Модификатор доступа метода getName должен быть расширен.


public class Solution {
    private String name;

    Solution(String name) {
        this.name = name;
    }

    private String getName() {
        return name;
    }

    private void sout() {
        new Solution("The Darkside Hacker") {
            void printName() {
                System.out.println(getName());
            }
        }.printName();
    }

    public static void main(String[] args) {
        new Solution("Риша").sout();
    }
}

 */