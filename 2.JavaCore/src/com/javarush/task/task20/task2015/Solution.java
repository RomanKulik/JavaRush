package com.javarush.task.task20.task2015;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
Переопределение сериализации
"Serialization: Переопределение Сериализации + пояснения и статьи"

Изучите секреты Java Serialization API
http://ccfit.nsu.ru/~deviv/courses/oop/java_ser_rus.html

Вопрос на интервью:
Можно ли настроить процесс сериализации или переопределить
"процесс сериализации по умолчанию" в Java?
(по умолчанию имеется ввиду - implements Serializable).

Ответ: Да, вы можете это сделать.
Мы все знаем, что для сериализации объекта вызывается
ObjectOutputStream.writeObject (saveThisobject)
и для чтения объекта вызывается ObjectInputStream.readObject() ,
но есть еще одна вещь, которую предоставляет вам виртуальная машина Java, -
это переопределение этих двух методов в вашем классе.
Если вы определяете эти два метода в своем классе,
то JVM вызовет эти два метода вместо применения механизма сериализации по умолчанию.
Здесь можно настроить поведение сериализации и десериализации объектов,
выполнив любую задачу предварительной или последующей обработки.
Важно отметить, что эти методы являются private (прямо как в нашей задаче),
чтобы избежать наследования, переопределения или перегрузки.
Поскольку только виртуальная машина Java может вызвать private метод,
целостность вашего класса сохранится, и сериализация Java будет работать как обычно.

когда мы вызываем метод для десериализации
objectInputStream.readObject() - где-то в этот момент создается сам объект
при помощи Reflection API. при этом поля его пустые.
Внутри тела метода private void readObject(ObjectInputStream in)
этот объект уже существует и на него ссылается this,
но поля этого объекта заполнены значениями по умолчанию.
при вызове метода defaultReadObject() заполняются поля объекта.
это можно проверить, вывев на печать this до и после метода defaultReadObject().
При этом toString не должен быть переопределен - тогда будут видны ссылки,
которые идентичны.


Переопределение сериализации
Сделайте так, чтобы после десериализации нить runner продолжила работать.
Ключевые слова объекта runner менять нельзя.

Hint/Подсказка:
Конструктор не вызывается при десериализации, только инициализируются все поля.


Требования:
1. Класс Solution должен поддерживать интерфейс Serializable.
2. Класс Solution должен поддерживать интерфейс Runnable.
3. Поле runner в классе Solution должно быть объявлено с модификатором transient.
4. В методе readObject должен быть создан новый объект
типа Thread с текущим объектом в качестве параметра.
5. В методе readObject должен быть вызван метод start у нового объекта типа Thread.
*/
/**
 * private void writeObject(ObjectOutputStream out){
 * in.defaultWriteObject();}
 * private void readObject(ObjectInputStream in){
 * in.defaultReadObject();}
 *
 * write/Read the non-static and non-transient fields of the current class from
 * this stream.
 * This may only be called from the readObject method of the class being deserialized.
 */

public class Solution implements Serializable, Runnable {
    transient private Thread runner;
    private int speed;

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        // do something here, doesn't matter what
    }

    /**
     * Переопределяем сериализацию.
     * Для этого необходимо объявить методы:
     * private void writeObject(ObjectOutputStream out) throws IOException
     * private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     * Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        Thread runner = new Thread(this);
        runner.start();
    }

    public static void main(String[] args) {

    }
}

/*
package com.javarush.task.task20.task2015;

        import java.io.IOException;
        import java.io.ObjectInputStream;
        import java.io.ObjectOutputStream;

Переопределение сериализации
Переопределение сериализации
Сделайте так, чтобы после десериализации нить runner продолжила работать.
Ключевые слова объекта runner менять нельзя.

Hint/Подсказка:
Конструктор не вызывается при десериализации, только инициализируются все поля.


Требования:
1. Класс Solution должен поддерживать интерфейс Serializable.
2. Класс Solution должен поддерживать интерфейс Runnable.
3. Поле runner в классе Solution должно быть объявлено с модификатором transient.
4. В методе readObject должен быть создан новый объект типа Thread с текущим объектом в качестве параметра.
5. В методе readObject должен быть вызван метод start у нового объекта типа Thread.
*/
/*
public class Solution implements {
    private Thread runner;
    private int speed;

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        // do something here, doesn't matter what
    }

    /**
     * Переопределяем сериализацию.
     * Для этого необходимо объявить методы:
     * private void writeObject(ObjectOutputStream out) throws IOException
     * private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     * Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    /*
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
    }

    public static void main(String[] args) {

    }
}
*/