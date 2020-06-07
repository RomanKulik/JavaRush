package Help;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
/**
 *  Класс для считывания объектов из файла, в котором будут лежать эти объекты -
 *  запустить этот main()
 *  https://www.youtube.com/watch?v=dBcqizwOWLg&list=PLAma_mKffTOSUkXp26rgdnC0PicnmnDak&index=46
 *
 *  FileInputStream fis = new FileInputStream("filename.bin");
 *  ObjectInputStream ois = new ObjectInputStream(fis);
 *  ois.close();
 *  fis.close();
 *
 *  IOException e = FileNotFoundException, ClassNotFoundException
 *
 *  ois.readObject()
*/
public class SerializationReadObject {
    public static void main(String... args) {
        try {
            FileInputStream fis = new FileInputStream("SerializationPerson.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            // Object readObject(). Поэтому нужно сделать DownCasting до SerializationPerson
            try {
                SerializationPerson person1 = (SerializationPerson) ois.readObject();
                SerializationPerson person2 = (SerializationPerson) ois.readObject();
                ois.close();
                fis.close();

                System.out.println(person1);
                System.out.println(person2);
            } catch (ClassNotFoundException e) {
                // Допустим, мы упаковали класс и передали его по почте другому человеку.
                // У него не оказалось этого класса - Exception
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
