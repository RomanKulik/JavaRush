package com.javarush.task.task11.task1118;

/* 
ООП позволяет фантазировать, но порой полезно оставаться в рамках здравого смысла.
Скажем, вы очень любите свою машину, но стоит ли считать её своим домашним питомцем или, того хуже, — возлюбленной?
Давайте в программе составим наследование исходя из здравого смысла.

Городское хозяйство
Расставь правильно «цепочку наследования» в классах: Pet (домашнее животное), Cat (кот), Dog (собака), Car (машина).


Требования:
1. В классе Solution должен быть public класс Pet (домашнее животное).
2. В классе Solution должен быть public класс Cat (кот).
3. В классе Solution должен быть public класс Dog (собака).
4. В классе Solution должен быть public класс Car (машина).
5. Класс Cat должен быть унаследован от класса Pet.
6. Класс Dog должен быть унаследован от класса Pet.
7. Класс Pet не должен быть унаследован от наших классов.
8. Класс Car не должен быть унаследован от наших классов.
*/
public class Solution {
    public static void main(String[] args) {
    }

    public class Pet {

    }

    public class Cat extends Pet {

    }

    public class Car {

    }

    public class Dog extends Pet {

    }
}
/*public class Solution {
    public static void main(String[] args) {
    }

    public class Pet {

    }

    public class Cat {

    }

    public class Car {

    }

    public class Dog {

    }
}*/
