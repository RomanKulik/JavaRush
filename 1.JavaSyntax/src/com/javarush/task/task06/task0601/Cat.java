package com.javarush.task.task06.task0601;

/*

Метод finalize класса Cat

Случайно потерять объект сложно: пока у вас есть на него хотя бы одна ссылка,
это значит, что он жив. Но если нет… Тогда к объекту приходит метод finalize,
этот непредсказуемый ассасин, состоящий на службе у Java-машины.
Давайте создадим такой же метод сами: protected void finalize() throws Throwable.
Последние два слова станут понятны чуть позднее.

Метод finalize класса Cat
В классе Cat создать метод protected void finalize() throws Throwable.


Требования:
1. В классе Cat должен быть метод с именем finalize.
2. Метод finalize ничего не должен возвращать (void).
3. Метод finalize должен быть protected.
4. Метод finalize может кидать исключение Throwable, укажи это при объявлении метода.
*/

/*
public class Cat {
    //напишите тут ваш код
    public static void main(String[] args) {

    }
}
*/
/*public class Cat {
    //напишите тут ваш код
    protected void finalize() throws Throwable {

    }

    public static void main(String[] args) {

    }
}*/

public class Cat {
    //напишите тут ваш код
    protected void finalize() throws Throwable {

    }

    public static void main(String[] args) {

    }
}