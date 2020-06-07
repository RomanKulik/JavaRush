package Help;

import java.io.*;

/**
 * try with resources
 * https://www.youtube.com/watch?v=nr4_JRKCGBU&list=PLAma_mKffTOSUkXp26rgdnC0PicnmnDak&index=48
 * c 10:08
 * <p>
 * Появилось в Java 7
 * Позволяет закрывать открытые потоки чтения и записи автоматически,
 * т.е. без использования метода close()
 * <p>
 * Относится ко всем потокам
 * <p>
 * Класс-поток, который можно закрыть автоматически, implements Closeable
 * Все классы-наследники такого класса, наследуют этот функционал,
 * переопределяя метод close() у себя, если это абстрактный метод
 * <p>
 * ObjectInputStream extends InputStream
 * abstract InputStream implements Closeable
 * то же с OutputStream
 * <p>
 * try (ObjectInputStream ois = new ObjectInputStream(
 * new FileInputStream("filename.bin")))
 * <p>
 * FileNotFoundException, IOException, ClassNotFoundException
 */
public class SerializationTryWithResources {
    public static void main(String[] args) {
        // Можно создать одну переменную потока
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("filename.bin"))) {
            SerializationPerson person1 = (SerializationPerson) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Можно создать 2 переменных потока
        try (FileOutputStream fos = new FileOutputStream("filename");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            SerializationPerson person = new SerializationPerson(1, "Bob");
            oos.writeObject(person);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
