package com.javarush.task.task20.task2018;

import java.io.*;

/* 
Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.

Найди проблему и исправь ее.

Класс A не должен реализовывать интерфейсы Serializable и Externalizable.

В сигнатуре класса В ошибки нет :).

В методе main ошибок нет.


Требования:
1. Класс B должен быть потомком класса A.
2. Класс B должен поддерживать интерфейс Serializable.
3. Класс A не должен поддерживать интерфейс Serializable.
4. Класс A не должен поддерживать интерфейс Externalizable.
5. Программа должна выполняться без ошибок.
6. При десериализации должны корректно восстанавливаться значение полей nameA и nameB.
*/

/**
 * Отличное видео по сериализации
 * https://www.youtube.com/watch?v=PcwXTCWRGvY
 * Write
 * Метаданные родителя - метаданные моего класса
 * Поля родителя - поля моего класса
 *
 * Read
 * Метаданные моего класса - метаданные родителя - throw ClassNotFoundException
 * Записываются значения моих полей
 * Конструктор родительского класса - значения полей родителя
 *
 *
 * https://ru.stackoverflow.com/questions/513300/%D0%9D%D1%8E%D0%B0%D0%BD%D1%81%D1%8B-%D0%BC%D0%B5%D1%82%D0%BE%D0%B4%D0%BE%D0%B2-%D0%BF%D1%80%D0%B8-%D1%81%D0%B5%D1%80%D0%B8%D0%B0%D0%BB%D0%B8%D0%B7%D0%B0%D1%86%D0%B8%D0%B8-%D0%B4%D0%B5%D1%81%D0%B5%D1%80%D0%B8%D0%B0%D0%BB%D0%B8%D0%B7%D0%B0%D1%86%D0%B8%D0%B8-%D0%B2-java
 * <p>
 * Никаких особенных нюансов у defaultWriteObject и defaultReadObject нет.
 * Если вы оставите ваш код как есть, то будет обычная сериализация/десериализация.
 * Если вы хотите написать полностью свой способ сериализации/десериализации,
 * то уберите использование defaultWriteObject и defaultReadObject,
 * и потом напишите в методах writeObject/readObject свой код.
 * Если хотите дополнить, или сериализовать несериализуемое (извините за тавтологию) поле,
 * то оставляете defaultWriteObject и defaultReadObject
 * и дописываете сериализацию этого поля.
 * <p>
 * При десериализации "по умолчанию" (равно как и методом defaultReadObject)
 * выполняется конструктор без параметров первого (в иерархии наследования)
 * несериализованного родительского класса.
 * Т.е. если у класса А нет конструктора без параметров, то будет ошибка.
 */
public class Solution implements Serializable {

    public Solution() {
    }

    public static class A {

        public A() {
        }

        protected String nameA = "A";

        public A(String nameA) {
            this.nameA += nameA;
        }
    }

    public class B extends A implements Serializable {

        private String nameB;

        public B(String nameA, String nameB) {
            super(nameA);
            this.nameA += nameA;
            this.nameB = nameB;
        }

        private void writeObject(ObjectOutputStream oos) throws IOException {
            oos.defaultWriteObject();
            oos.writeObject(this.nameA);
        }

        private void readObject(ObjectInputStream ois)throws IOException, ClassNotFoundException {
            ois.defaultReadObject();
            this.nameA = String.valueOf(ois.readObject());
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(arrayOutputStream);

        Solution solution = new Solution();
        B b = solution.new B("B2", "C33");
        System.out.println("nameA: " + b.nameA + ", nameB: " + b.nameB);

        oos.writeObject(b);

        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(arrayOutputStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(arrayInputStream);

        B b1 = (B) ois.readObject();
        System.out.println("nameA: " + b1.nameA + ", nameB: " + b1.nameB);
    }
}

/*
package com.javarush.task.task20.task2018;

import java.io.Serializable;

/*
Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.

Найди проблему и исправь ее.

Класс A не должен реализовывать интерфейсы Serializable и Externalizable.

В сигнатуре класса В ошибки нет :).

В методе main ошибок нет.


Требования:
1. Класс B должен быть потомком класса A.
2. Класс B должен поддерживать интерфейс Serializable.
3. Класс A не должен поддерживать интерфейс Serializable.
4. Класс A не должен поддерживать интерфейс Externalizable.
5. Программа должна выполняться без ошибок.
6. При десериализации должны корректно восстанавливаться значение полей nameA и nameB.
*/
/*
public class Solution {
    public static class A {

        protected String nameA = "A";

        public A(String nameA) {
            this.nameA += nameA;
        }
    }

    public class B extends A implements Serializable {

        private String nameB;

        public B(String nameA, String nameB) {
            super(nameA);
            this.nameA += nameA;
            this.nameB = nameB;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(arrayOutputStream);

        Solution solution = new Solution();
        B b = solution.new B("B2", "C33");
        System.out.println("nameA: " + b.nameA + ", nameB: " + b.nameB);

        oos.writeObject(b);

        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(arrayOutputStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(arrayInputStream);

        B b1 = (B) ois.readObject();
        System.out.println("nameA: " + b1.nameA + ", nameB: " + b1.nameB);
    }
}

 */