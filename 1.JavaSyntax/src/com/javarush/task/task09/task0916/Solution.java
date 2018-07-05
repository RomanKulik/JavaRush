package com.javarush.task.task09.task0916;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*

Перехват checked-исключений

На лекциях секретного центра JavaRush нас учили,
что если в методе выбрасываются (возникают) исключения
ClassNotFoundException
и
FileNotFoundException,
программист просто обязан указать их в сигнатуре метода (в заголовке метода).
Это и есть checked исключения.
Давайте обработаем их в методе processExceptions и выведем их на экран.

Перехват checked-исключений
В методе processExceptions обработайте все checked исключения.
Нужно вывести на экран каждое возникшее checked исключение.
Можно использовать только один блок try..catch


Требования:
1. Метод processExceptions должен вызывать метод method1.
2. Метод processExceptions должен вызывать метод method2.
3. Метод processExceptions должен вызывать метод method3.
4. Метод processExceptions должен использовать только один блок try..catch.
5. Метод processExceptions должен отлавливать и выводить на экран все возникающие checked исключения.
6. Программа должна выводить на экран текст.
*/

public class Solution {
    public static void main(String[] args) {
        processExceptions(new Solution());

    }

    public static void processExceptions(Solution obj) {
        try {
            obj.method1();
            obj.method2();
            obj.method3();
        } catch (Exception e) {
            if (e instanceof ReflectiveOperationException ||
                    e instanceof IOException) {
                System.out.println(e);
            } else if (e instanceof RuntimeException){
                // RuntimeException extends Exception
                throw (RuntimeException)e;
            } else {
                System.out.println(e);
            }
        }
    }

    public void method1() throws IOException {
        throw new IOException(); // extends Exception
    }

    public void method2() throws NoSuchFieldException {
                  // ClassNotFoundException extends ReflectiveOperationException extends Exception
        throw new NoSuchFieldException(); //extends ReflectiveOperationException extends Exception
    }

    public void method3() throws RemoteException {
                              // FileNotFoundException extends IOException extends Exception
        throw new RemoteException(); //RemoteException extends IOException extends Exception

    }
}
