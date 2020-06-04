package com.javarush.task.task20.task2008;

import java.io.*;

/* 
Как сериализовать Singleton?
Как сериализовать Singleton?
Два десериализованных объекта singleton и singleton1
имеют разные ссылки в памяти, а должны иметь одинаковые.
В класс Singleton добавь один метод (погуглите),
чтобы после десериализации ссылки на объекты были равны.
Метод main не участвует в тестировании.


Требования:
1. Класс Solution.Singleton должен поддерживать интерфейс Serializable.
2. В классе Solution.Singleton должен быть реализован метод readResolve без параметров.
3. Метод readResolve должен возвращать синглтон (ourInstance).
4. Метод readResolve должен быть приватным.
5. В классе Solution должен быть публичный статический метод serializeSingletonInstance.
6. После десериализации ссылки на объекты должны быть равны.
*/

public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Singleton instance = Singleton.getInstance();

        ByteArrayOutputStream byteArrayOutputStream = serializeSingletonInstance(instance);

        Singleton singleton = deserializeSingletonInstance(byteArrayOutputStream);
        Singleton singleton1 = deserializeSingletonInstance(byteArrayOutputStream);

        System.out.println("Проверка ourInstance : " + singleton.getInstance());
        System.out.println("Проверка ourInstance : " + singleton1.getInstance());
        System.out.println("=========================================================");
        System.out.println("Проверка singleton : " + singleton);
        System.out.println("Проверка singleton1 : " + singleton1);
    }

    public static ByteArrayOutputStream serializeSingletonInstance(Singleton instance) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream);
        oos.writeObject(instance);
        oos.close();

        return byteArrayOutputStream;
    }

    public static Singleton deserializeSingletonInstance(ByteArrayOutputStream byteArrayOutputStream)
            throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());

        ObjectInputStream ois = new ObjectInputStream(byteArrayInputStream);
        Singleton singleton = (Singleton) ois.readObject();
        ois.close();

        return singleton;
    }

    public static class Singleton implements Serializable {
        private static Singleton ourInstance;

        public static Singleton getInstance() throws ObjectStreamException {
            if (ourInstance == null) {
                ourInstance = new Singleton();
            }
            return ourInstance;
        }

        private Singleton() throws ObjectStreamException {
        }

        private Object readResolve() {
            return this.ourInstance;
        }
    }
}

/*public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Singleton instance = Singleton.getInstance();

        ByteArrayOutputStream byteArrayOutputStream = serializeSingletonInstance(instance);

        Singleton singleton = deserializeSingletonInstance(byteArrayOutputStream);
        Singleton singleton1 = deserializeSingletonInstance(byteArrayOutputStream);

        System.out.println("Проверка ourInstance : " + singleton.getInstance());
        System.out.println("Проверка ourInstance : " + singleton1.getInstance());
        System.out.println("=========================================================");
        System.out.println("Проверка singleton : " + singleton);
        System.out.println("Проверка singleton1 : " + singleton1);
    }

    public static ByteArrayOutputStream serializeSingletonInstance(Singleton instance) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream);
        oos.writeObject(instance);
        oos.close();

        return byteArrayOutputStream;
    }

    public static Singleton deserializeSingletonInstance(ByteArrayOutputStream byteArrayOutputStream) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());

        ObjectInputStream ois = new ObjectInputStream(byteArrayInputStream);
        Singleton singleton = (Singleton) ois.readObject();
        ois.close();

        return singleton;
    }

    public static class Singleton implements Serializable {
        private static Singleton ourInstance;

        public static Singleton getInstance() {
            if (ourInstance == null) {
                ourInstance = new Singleton();
            }
            return ourInstance;
        }

        private Singleton() {
        }
    }
}*/
