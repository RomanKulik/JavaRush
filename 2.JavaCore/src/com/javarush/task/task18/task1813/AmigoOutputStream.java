package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* 
AmigoOutputStream
AmigoOutputStream
1 Измени класс AmigoOutputStream так, чтобы он стал Wrapper-ом для класса FileOutputStream. Используй наследование.
2 При вызове метода close() должны выполняться следующая последовательность действий:
2.1 Вызвать метод flush().
2.2 Дописать следующий текст "JavaRush © All rights reserved.", используй метод getBytes().
2.3 Закрыть поток методом close().


Требования:
1. Метод main изменять нельзя.
2. Класс AmigoOutputStream должен наследоваться от класса FileOutputStream.
3. Класс AmigoOutputStream должен принимать в конструкторе обьект типа FileOutputStream.
4. Все методы write(), flush(), close() в классе AmigoOutputStream должны делегировать
свое выполнение объекту FileOutputStream.
5. Метод close() должен сначала вызвать метод flush(),
затем дописать текст, затем закрыть поток.
*/

public class AmigoOutputStream extends FileOutputStream {

    private FileOutputStream fos;
    public static String fileName = "C:/tmp/result.txt";

    public AmigoOutputStream(FileOutputStream fos) throws FileNotFoundException {
        super(fileName);
        this.fos = fos;
    }

    @Override
    public void write(int b) throws IOException {
        this.fos.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        this.fos.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        this.fos.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        this.fos.flush();
    }

    @Override
    public void close() throws IOException {
        this.flush();
        this.fos.write("JavaRush © All rights reserved.".getBytes());
        if (this.fos != null)
            this.fos.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
