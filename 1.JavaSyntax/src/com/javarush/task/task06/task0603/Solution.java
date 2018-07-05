package com.javarush.task.task06.task0603;

/* 
По 50 000 объектов Cat и Dog

Если вы еще не прониклись прелестью циклов в программировании,
можете попробовать решить эту самую задачу без них.
Хотя тут речь не столько о циклах, сколько об уничтожении незадействованных объектов.
Итак, создайте в цикле по 50 000 объектов Cat и Dog.
Этим действием мы провоцируем Java-машину вызвать хотя бы разочек метод finalize.

По 50 000 объектов Cat и Dog
Создать в цикле по 50 000 объектов Cat и Dog.
(Java-машина должна начать уничтожать неиспользуемые, и метод finalize хоть раз да вызовется).


Требования:
1. В классе Cat должен быть void метод finalize.
2. В классе Dog должен быть void метод finalize.
3. Метод finalize класса Cat должен выводить на экран "Cat was destroyed".
4. Метод finalize класса Dog должен выводить на экран "Dog was destroyed".
5. Метод main должен создавать 50000 объектов типа Cat и 50000 объектов типа Dog.
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        for (int i = 0; i < 50000; i++) {
            Cat cat = new Cat();
        }
        for (int i = 0; i < 50000; i++) {
            Dog dog = new Dog();
        }

        /*Cat[] cat = new Cat[50000];
        Dog[] dogs = new Dog[50000];
        for (int i = 0; i < 50000; i++) {
            cat[i] = new Cat();
            dogs[i] = new Dog();
        }*/
    }
}

class Cat {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Cat was destroyed");
    }
}

class Dog {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Dog was destroyed");
    }
}
