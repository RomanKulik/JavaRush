package com.javarush.task.task20.task2017;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;


/* 
Десериализация
На вход подается поток, в который записан
сериализованный объект класса A либо класса B.
Десериализуй объект в методе getOriginalObject так,
чтобы в случае возникновения исключения
было выведено сообщение на экран и возвращен null.
Реализуй интерфейс Serializable где необходимо.


Требования:
1. Класс B должен быть потомком класса A.
2. Класс A должен поддерживать интерфейс Serializable.
3. Класс B не должен явно поддерживать интерфейс Serializable.
4. Метод getOriginalObject
должен возвращать объект типа A полученный из потока ObjectInputStream.
5. Метод getOriginalObject
должен возвращать null, если при попытке десериализации не был получен объект типа A.
6. Метод getOriginalObject должен возвращать null,
если при попытке десериализации возникло исключение.

*/
public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream) {
        try {
            A a = (A) objectStream.readObject();
            if (a instanceof A)
                return a;
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public class A implements Serializable {
        public A() {
            System.out.println("inside A");
        }
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }


    public static void main(String[] args) throws IOException {

    }
}
