package com.javarush.task.task18.task1826;

/* 
Шифровка
Шифровка
Придумать механизм шифровки/дешифровки.

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName

где:
fileName - имя файла, который необходимо зашифровать/расшифровать.
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования.
-e - ключ указывает, что необходимо зашифровать данные.
-d - ключ указывает, что необходимо расшифровать данные.


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток для чтения из файла, который приходит вторым параметром ([fileName]).
3. Создай поток для записи в файл, который приходит третьим параметром ([fileOutputName]).
4. В режиме "-e" программа должна зашифровать [fileName] и записать в [fileOutputName].
5. В режиме "-d" программа должна расшифровать [fileName] и записать в [fileOutputName].
6. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    private static String fileName = "d:/et.txt";
    private static String fileOutputName = "d:/et_.txt";

    public static void main(String[] args) throws IOException {
        if (args.length != 0) { // 1 параметр
            if(args.length == 3){ // 3 параметра
                fileName = args[1];
                fileOutputName = args[2];
            }
            if (args[0].equals("-e")) {
                encryption(true);
            } else if (args[0].equals("-d")) {
                decryption(true);
            } else {
                System.out.println("Wrong key");
            }
        } else { // без параметров
            encryption(true);
            //decryption(true);
        }
    }

    private static void encryption(boolean flag) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);
        FileOutputStream fos = new FileOutputStream(fileOutputName);
        while (fis.available() > 0){
            fos.write(fis.read());
            fos.write(3);
        }
        fis.close();
        fos.close();
    }

    private static void decryption(boolean flag) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);
        FileOutputStream fos = new FileOutputStream(fileOutputName);
        while (fis.available() > 0){
            fos.write(fis.read());
            fis.read();
        }
        fis.close();
        fos.close();
    }

    private static void encryption() throws IOException {
        FileOutputStream out = new FileOutputStream(fileOutputName);
        List<Byte> list = getByteListFromFile();
        Collections.reverse(list);
        out.write(getBytesArrayFromList(list));
        out.close();
    }

    private static void decryption() throws IOException {
        encryption();
    }

    private static byte[] getBytesArrayFromList(List<Byte> list) throws IOException {
        FileInputStream in = new FileInputStream(fileName);
        byte[] bytes = new byte[in.available()];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = list.get(i);
        }
        in.close();
        return bytes;
    }

    private static List<Byte> getByteListFromFile() throws IOException {
        FileInputStream in = new FileInputStream(fileName);
        List<Byte> list = new ArrayList<>();

        byte[] buff = new byte[in.available()];
        in.read(buff);

        for (byte b : buff)
            list.add(b);
        in.close();

        return list;
    }

}

/*public class Solution {
    public static void main(String[] args) {

    }

}*/
