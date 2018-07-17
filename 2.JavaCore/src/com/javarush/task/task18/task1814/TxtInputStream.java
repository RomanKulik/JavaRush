package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* 
UnsupportedFileName
UnsupportedFileName
Измени класс TxtInputStream так, чтобы он работал только с txt-файлами (*.txt).
Например, first.txt или name.1.part3.txt.
Если передан не txt-файл, например, file.txt.exe,
то конструктор должен выбрасывать исключение UnsupportedFileNameException.
Подумай, что еще нужно сделать, в случае выброшенного исключения.


Требования:
1. Класс TxtInputStream должен наследоваться от класса FileInputStream.
2. Если в конструктор передан txt-файл, TxtInputStream должен вести себя,
как обычный FileInputStream.
3. Если в конструктор передан не txt-файл,
должно быть выброшено исключение UnsupportedFileNameException.
4. В случае выброшенного исключения, так же должен быть вызван super.close().
*/
public class TxtInputStream extends FileInputStream {
    private static final String EXTENSION = "txt";

    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);
        if (!fileExtension(fileName).equals(EXTENSION)){
            super.close();
            throw new UnsupportedFileNameException();
        }
    }

    private static String fileExtension(String fileName) {
        int indexOfLastPoint = fileName.lastIndexOf('.');
        fileName.endsWith(EXTENSION);
        return fileName.substring(indexOfLastPoint + 1);
    }

    public static void main(String[] args) {
    }
}
/*public class TxtInputStream extends FileInputStream {

    public TxtInputStream(String fileName) {
    }

    public static void main(String[] args) {
    }
}*/

