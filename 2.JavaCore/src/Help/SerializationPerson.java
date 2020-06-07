package Help;

import java.io.Serializable;
/**
 * Serialization
 * Сериализация нужна, когда в ходе програссы создаются оъекты
 * и эти объекты нужно сохранить для последующего использования
 * Чтобы класс можно было сериализовать, нужно поставить флаг-разрешение implements Serializable,
 * который позволит java сериализовать этот класс
 *
 * RW Objects
 * https://www.youtube.com/watch?v=dBcqizwOWLg&list=PLAma_mKffTOSUkXp26rgdnC0PicnmnDak&index=46
 * RW Arrays of Objects
 * https://www.youtube.com/watch?v=7QZ6oZ51o0U&list=PLAma_mKffTOSUkXp26rgdnC0PicnmnDak&index=47
 *
 * https://www.youtube.com/watch?v=nr4_JRKCGBU&list=PLAma_mKffTOSUkXp26rgdnC0PicnmnDak&index=48
 *
 * implements Serializable - флаг-разрешение на сериализацию
 * transient - ключевое слово, которое запрещает сериализовать поле класса
 * serialVersionUID
*/
public class SerializationPerson implements Serializable {
    // Поле SerialVersionUID
    // В некоторых средах, может быть предупреждение, что такое поле не создано,
    // если класс имплементит Serializable
    // Включить предупреждение: File - Settings - Editor - Inspections  - Java -
    // - Serializable Issues - Serializable class without 'serialVersionUID'
    // Он нужен для того, чтобы помечать состояние класса.
    // Т.е. если изменилось состояние класса (добавлены/изменены/переименованы поля),
    // то и serialVersionUID тоже будет другим, при новой его генерации
    // Если с состоянием класса происходят изменения, то
    // ОБЯЗАТЕЛЬНО нужно изменить serialVersionUID, иначе будут возникать проблемы
    // при считывании этого класса, т.к. записан был один, а считывается уже другой.
    private static final long serialVersionUID = 7857927959916194045L;

    private int id;
    private String name;
    // поле, помеченное transient - не сериализуется, т.е. вместо
    // ссылочного типа (объект класса, строка и т.д.) в бинарном виде будет null
    // для примитивов - значение по умолчанию, т.е. 0
    private transient int data;

    public SerializationPerson(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return this.id + " : " + this.name;
    }
}


