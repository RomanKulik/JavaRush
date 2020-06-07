package Help;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 2 способа записи массива объектов в файл
 * https://www.youtube.com/watch?v=7QZ6oZ51o0U&list=PLAma_mKffTOSUkXp26rgdnC0PicnmnDak&index=47
 *
 * 1. Вначале записать количество всехо объектов в файле, потом сами объекты
 * 2. Записать, как объект
 *
 * FileOutputStream fos  = new FileOutputStream("filename.bin");
 * ObjectOutputStream oos = new ObjectOutputStream(fos);
 * fos.close();
 * oss.close();
 *
 * IOException e = FileNotFoundException, ClassNotFoundException
 *
 * int oos.writeInt(people.length)
 * oos.writeObject(p);
 */

public class SerializationArrayWriteObject {
    public static void main(String[] args) {
        SerializationPerson[] people = {
                new SerializationPerson(1, "Mike"),
                new SerializationPerson(1, "Bob"),
                new SerializationPerson(1, "Pit")
        };

        try {
            FileOutputStream fos = new FileOutputStream("SerializationPerson1.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            // 1. Сначала в файл запишется количество объектов в массиве,
            // потом сами объекты
            oos.writeInt(people.length); // число объектов в массиве
            for (SerializationPerson p : people) {
                oos.writeObject(p);
            }

            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. Примим то, что массив - это тоже объект
        try {
            FileOutputStream fos = new FileOutputStream("SerializationPerson2.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(people);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
