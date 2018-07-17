package com.javarush.task.task18.task1819;

/* 
Объединение файлов
Объединение файлов
Считать с консоли 2 имени файла.
В начало первого файла записать содержимое второго файла так,
чтобы получилось объединение файлов.
Закрыть потоки.


Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Для первого файла создай поток для чтения и считай его содержимое.
3. Затем, для первого файла создай поток для записи. Для второго - для чтения.
4. Содержимое первого и второго файла нужно объединить в первом файле.
5. Сначала должно идти содержимое второго файла, затем содержимое первого.
6. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

//        file1 = "d:/3-3.txt";
//        file2 = "d:/2-2.txt";

        InputStream file1In = new FileInputStream(file1);
        byte[] buffFile1 = new byte[file1In.available()];
        file1In.read(buffFile1);
        // System.out.println(Arrays.toString(buffFile1));

        InputStream file2In = new FileInputStream(file2);
        byte[] buffFile2 = new byte[file2In.available()];
        file2In.read(buffFile2);
        //System.out.println(Arrays.toString(buffFile2));

        OutputStream file1Out = new FileOutputStream(file1);
        byte[] result = concatAll(buffFile2, buffFile1);
        file1Out.write(result);
        //System.out.println(Arrays.toString(result));

        reader.close();
        file1In.close();
        file1Out.close();
        file2In.close();
    }

    private static byte[] concatAll(byte[] first, byte[]... rest) {
        int totalLenght = first.length;
        for (byte[] t : rest) {
            totalLenght += t.length;
        }

        byte[] resultArray = Arrays.copyOf(first, totalLenght);
        int offset = first.length;

        for (byte[] t : rest) {
            System.arraycopy(t, 0, resultArray, offset, t.length);
        }

        return resultArray;
    }

    // return new array, that contains all arrays in params
    private static <T> T[] concatAll(T[] first, T[]... rest) {
        int totalLenght = first.length;
        for (T[] t : rest) {
            totalLenght += t.length;
        }

        T[] resultArray = Arrays.copyOf(first, totalLenght);
        int offset = first.length;

        for (T[] t : rest) {
            System.arraycopy(t, 0, rest, offset, t.length);
        }

        return resultArray;
    }
}

/*public class Solution {
    public static void main(String[] args) {
    }
}*/
