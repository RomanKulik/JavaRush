package com.javarush.task.task06.task0602;

/* 
Пустые кошки, пустые псы

Пустые кошки, пустые псы

Минутка деструктива на JavaRush.
На предыдущем уровне мы часто «конструировали» котов и псов (конструкторы для классов Cat и Dog)
и создавали новых конкретных котов и псов (объекты). Теперь пришло время уничтожения объектов,
на которые никто не ссылается. В классах Cat и Dog пишем метод finalize,
который выводит на экран текст об уничтожении объектов.

Пустые кошки, пустые псы
В каждом классе Cat и Dog написать метод finalize,
который выводит на экран текст о том, что такой-то объект уничтожен.


Требования:
1. В классе Cat должен быть void метод finalize.
2. В классе Dog должен быть void метод finalize.
3. Метод finalize класса Cat должен выводить на экран "Cat was destroyed".
4. Метод finalize класса Dog должен выводить на экран "Dog was destroyed".
*/

/*public class Cat {
    public static void main(String[] args) {

    }

    //напишите тут ваш код

}

class Dog {
    //напишите тут ваш код
}*/


public class Cat {
    public static void main(String[] args) {

    }

    //напишите тут ваш код
    protected void finalize() throws Throwable {
        System.out.println("Cat was destroyed");
    }
}

class Dog {
    //напишите тут ваш код
    protected void finalize() throws Throwable {
        System.out.println("Dog was destroyed");
    }
}