package com.javarush.task.task15.task1518;

/* 
Статики и котики
Добавим котов в мир статичекских блоков.
Для начала создадим класс Cat в классе Solution с публичным полем name типа String,
но без конструктора с параметрами.
Затем в статическом блоке создадим кошачий объект и выведем имя созданного кота на экран.

Статики и котики
1. В классе Solution создай класс Cat с публичным полем name типа String.
2. В статическом блоке создай объект типа Cat и присвой
его переменной cat(не забудь инициализировать поле name).
3. В классе Cat не создавай конструкторы с параметрами.
4. В статическом блоке выведи имя созданного кота на экран.


Требования:
1. Класс Cat должен быть создан внутри класса Solution и быть публичным и статическим.
2. В классе Cat должно присутствовать публичное поле name типа String.
3. Переменная cat должна быть инициализирована в статическом блоке.
4. В статическом блоке на экран должно быть выведено имя созданного кота.
5. Класс Cat не должен содержать конструкторы с параметрами.
*/
public class Solution {
    public static Cat cat;

    static {
        cat = new Cat();
        cat.name = "Tom";
        System.out.println(cat.name);
    }

    public static class Cat {
        public String name = "Kitty";
    }

    public static void main(String[] args) {

    }
}
/*public class Solution {
    public static Cat cat;

    public static void main(String[] args) {

    }
}*/
