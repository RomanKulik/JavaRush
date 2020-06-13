package com.javarush.task.task20.task2021;

import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
Сериализация под запретом
Запрети сериализацию класса SubSolution используя NotSerializableException.
Сигнатуры классов менять нельзя.


Требования:
1. Класс Solution должен поддерживать интерфейс Serializable.
2. Класс SubSolution должен быть создан внутри класса Solution.
3. Класс SubSolution должен быть потомком класса Solution.
4. При попытке сериализовать объект типа SubSolution
должно возникать исключение NotSerializableException.
5. При попытке десериализовать объект типа SubSolution
должно возникать исключение NotSerializableException.
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {
        private void writeObject(ObjectOutputStream obj) throws NotSerializableException {
            throw new NotSerializableException();
        }

        private void readObject(ObjectInputStream obj) throws NotSerializableException {
            throw new NotSerializableException();
        }
    }

    public static void main(String[] args) {

    }
}

/*
package com.javarush.task.task20.task2021;

import java.io.Serializable;

/*
Сериализация под запретом
Запрети сериализацию класса SubSolution используя NotSerializableException.
Сигнатуры классов менять нельзя.


Требования:
1. Класс Solution должен поддерживать интерфейс Serializable.
2. Класс SubSolution должен быть создан внутри класса Solution.
3. Класс SubSolution должен быть потомком класса Solution.
4. При попытке сериализовать объект типа SubSolution должно возникать исключение NotSerializableException.
5. При попытке десериализовать объект типа SubSolution должно возникать исключение NotSerializableException.
*/
/*
public class Solution implements Serializable {
    public static class SubSolution extends Solution {
    }

    public static void main(String[] args) {

    }
}

 */