package com.javarush.task.task11.task1120;

/* 
Собаковод и кошковод Андре не умеет программировать.
Он слёзно попросил вас написать программу,
которая помогла бы ему разобраться с его подопечными и нажитым непосильным трудом имуществом.
А вам то что, вам это легко.
Вы как раз изучаете ООП и наследование.

Пятая правильная «цепочка наследования»
Расставь правильно «цепочку наследования» в классах:
House (дом), Cat (кот), Dog (собака), Car (машина), Animal (животное), Assets (имущество).


Требования:
1. Класс House должен быть унаследован от класса Assets.
2. Класс Cat должен быть унаследован от класса Animal.
3. Класс Dog должен быть унаследован от класса Animal.
4. Класс Car должен быть унаследован от класса Assets.
5. Класс Animal не должен быть унаследован от наших классов.
6. Класс Assets не должен быть унаследован от наших классов.
*/
public class Solution {
    public static void main(String[] args) {
    }

    public class House extends Assets {

    }

    public class Cat extends Animal {

    }

    public class Car extends Assets {

    }

    public class Dog extends Animal {

    }

    public class Animal {

    }

    public class Assets {

    }
}
/*public class Solution {
    public static void main(String[] args) {
    }

    public class House {

    }

    public class Cat {

    }

    public class Car {

    }

    public class Dog {

    }

    public class Animal {

    }

    public class Assets {

    }
}*/
