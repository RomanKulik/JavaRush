package com.javarush.task.task15.task1513;

/* 
Максимально простой код-3
И снова лишний код, и снова нам нужно с ним разобраться.
Проще говоря, убрать. Убрать все те наследования и конструкторы,
что и без вмешательства программиста будут генерироваться автоматически при компиляции.

Максимально простой код-3
Упрости код:
- убери всё то, что будет генерироваться автоматически при компиляции
- убери все наследования классов, которые и так будут добавлены автоматически при компиляции
- убери все конструкторы, которые создаются и добавляются автоматически.


Требования:
1. В классе Car не должно быть явно реализованных конструкторов без параметров.
2. В классе Machine не должно быть явно реализованных конструкторов без параметров.
3. Класс Car должен быть потомком класса Machine.
4. В коде не должно быть явного наследования от Object(extends Object).
5. Класс Car не должен явно наследовать интерфейс Runnable.
*/
public class Solution {
    public static void main(String[] args) {
    }

    public interface Runnable {

    }

    public class Machine implements Runnable {

    }

    public class Car extends Machine {

    }
}
/*public class Solution {
    public static void main(String[] args) {
    }

    public interface Runnable {

    }

    public class Machine extends Object implements Runnable {
        public Machine() {
            super();
        }
    }

    public class Car extends Machine implements Runnable {
        public Car() {
            super();
        }
    }
}*/
