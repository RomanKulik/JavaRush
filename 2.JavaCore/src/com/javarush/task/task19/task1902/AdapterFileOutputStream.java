package com.javarush.task.task19.task1902;

import java.io.FileOutputStream;
import java.io.IOException;

/*
Адаптер
Адаптер
Используй класс AdapterFileOutputStream,
чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter.

Требования:
1. AmigoStringWriter должен быть интерфейсом.
2. Класс AdapterFileOutputStream должен реализовывать интерфейс AmigoStringWriter.
3. Класс AdapterFileOutputStream
должен содержать приватное поле fileOutputStream типа FileOutputStream.
4. Класс AdapterFileOutputStream должен содержать конструктор с параметром FileOutputStream.
5. Метод flush() класса AdapterFileOutputStream
должен делегировать полномочие такому же методу fileOutputStream.
6. Метод writeString(String s) класса AdapterFileOutputStream
должен делегировать полномочие такому же методу fileOutputStream.
7. Метод close() класса AdapterFileOutputStream
должен делегировать полномочие такому же методу fileOutputStream.

*/
public class AdapterFileOutputStream implements AmigoStringWriter {
   private FileOutputStream fileOutputStream;

    public AdapterFileOutputStream(FileOutputStream fos) {
        this.fileOutputStream = fos;
    }

    public static void main(String[] args) {

    }

    @Override
    public void flush() throws IOException {
        this.fileOutputStream.flush();
    }

    @Override
    public void writeString(String s) throws IOException {
        byte[] buff = s.getBytes();
        this.fileOutputStream.write(buff);
    }

    @Override
    public void close() throws IOException {
        this.fileOutputStream.close();
    }
}
/*public class AdapterFileOutputStream {

    public static void main(String[] args) {

    }


}*/

