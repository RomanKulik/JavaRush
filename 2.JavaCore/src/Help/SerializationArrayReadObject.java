package Help;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

/**
 * 2 Способа вычитать массив объектов из файла
 * https://www.youtube.com/watch?v=7QZ6oZ51o0U&list=PLAma_mKffTOSUkXp26rgdnC0PicnmnDak&index=47
 *
 * 1. Вычитать каждый объект отдельно, получив из файла количество этих объектов
 * 2. Вычитать, как объект
 *
 * FileInputStream fis = new FileInputStream("filename.bin");
 * ObjectInputStream ois = new ObjectInputStream(fis);
 * ois.close();
 * fis.close();
 *
 * IOException e = FileNotFoundException, ClassNotFoundException
 *
 * ois.readInt()
 * Object readObject() => DownCast to (SerializationPerson) ois.readObject()
 * Object readObject() => DownCast to (SerializationPerson[]) ois.readObject()
 */
public class SerializationArrayReadObject {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("SerializationPerson1.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            // 1. Вычитать количество объектов и вычитать эти объекты
            int numOfObjectsInArray = ois.readInt();
            SerializationPerson[] people = new SerializationPerson[numOfObjectsInArray];
            for (int i = 0; i < numOfObjectsInArray; i++) {
                //Object readObject() => DownCast to SerializationPerson
                people[i] = (SerializationPerson) ois.readObject();
            }
            System.out.println("SerializationPerson1.bin");
            System.out.println(Arrays.toString(people));

            ois.close();
            fis.close();
        } catch (IOException e) {

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fis = new FileInputStream("SerializationPerson2.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            // Вычитать, как объект
            //Object readObject() => DownCast to SerializationPerson[]
            SerializationPerson[] people = (SerializationPerson[]) ois.readObject();

            System.out.println("SerializationPerson2.bin");
            System.out.println(Arrays.toString(people));

            ois.close();
            fis.close();
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {

        }

    }
}
