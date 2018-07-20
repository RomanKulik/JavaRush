package com.javarush.task.task18.task1819;

import java.io.*;

public class Solution_short {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        FileInputStream inputStream1 = new FileInputStream(file1);
        FileInputStream inputStream2 = new FileInputStream(file2);
        reader.close();
        byte buffer1[] = new byte[inputStream1.available()];
        inputStream1.read(buffer1);
        inputStream1.close();
        byte buffer2[] = new byte[inputStream2.available()];
        inputStream2.read(buffer2);
        inputStream2.close();
        // убрать флаг дозаписи в файл
        FileOutputStream outputStream1 = new FileOutputStream(new File(file1));

        // соединить 2 буфера в 1 и записать его
        byte[] allBuff = new byte[buffer2.length + buffer1.length];
        System.arraycopy(buffer2, 0, allBuff, 0, buffer2.length);
        System.arraycopy(buffer1, 0, allBuff, buffer2.length, buffer1.length);
        outputStream1.write(allBuff);
        outputStream1.close();
    }
}
