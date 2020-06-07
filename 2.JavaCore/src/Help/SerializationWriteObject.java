package Help;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Класс для записи объектов - запустить этот main()
 * https://www.youtube.com/watch?v=dBcqizwOWLg&list=PLAma_mKffTOSUkXp26rgdnC0PicnmnDak&index=46
 *
 * FileOutputStream fos  = new FileOutputStream("filename.bin");
 * ObjectOutputStream oos = new ObjectOutputStream(fos);
 * oos.close();
 * fos.close();
 *
 * IOException e = FileNotFoundException, ClassNotFoundException
 *
 * oos.writeObject(object)
 */
public class SerializationWriteObject {
    public static void main(String... args) {
        // После завершения программы, доступ к этим объектам, находящимся в ОЗУ прекратится
        SerializationPerson person1 = new SerializationPerson(1, "Bob");
        SerializationPerson person2 = new SerializationPerson(2, "Mike");

        // Чтобы доступ было возможен, нужно записать эти 2 объета в файл => Сериализация
        // SerializationPerson.bin - файл, куда записать.
        // Расширение роли не играет. Можно осавить без расширения.
        try {
            // Для записи последовательности байт в файл.
            // Т.е. неважно, что это: картинка, звук, объект и т.д.
            FileOutputStream fos  = new FileOutputStream("SerializationPerson.bin");
            // Узкоспециализированный класс для записи объектов.
            // Для работы нужен объект FileOutputStream
            // Преобразовывает объекты в последовательность байт, и передает в fos, для записи
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(person1);
            oos.writeObject(person2);

            // обязательно поток нужно закрывать, иначе ничего не запишется
            oos.close();
            fos.close();
        } catch (IOException e) {
            // Checked exception
            e.printStackTrace();
        }

    }
}
