package com.javarush.task.task18.task1820;

/* 
Округление чисел
Округление чисел
Считать с консоли 2 имени файла.
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415.
Округлить числа до целых и записать через пробел во второй файл.
Закрыть потоки.

Принцип округления:
3.49 => 3
3.50 => 4
3.51 => 4
-3.49 => -3
-3.50 => -3
-3.51 => -4


Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Для первого файла создай поток для чтения. Для второго - поток для записи.
3. Считать числа из первого файла, округлить их и записать через пробел во второй.
4. Должны соблюдаться принципы округления, указанные в задании.
5. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             InputStream in = new FileInputStream(reader.readLine()/*"d:/11.txt"*/); // 3.49 3.50 3.51 -3.49 -3.50 -3.51
             FileOutputStream out = new FileOutputStream(reader.readLine()/*"d:/12.txt"*/)) { // empty
            copyDoubleFromIn_ToIntInOut(in, out);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static void copyDoubleFromIn_ToIntInOut(InputStream in, FileOutputStream out) throws IOException {
        byte[] inBuff = new byte[in.available()];
        in.read(inBuff);

        for (double d : byteArrToDoubleList(inBuff)) {
            Integer number = (int) Math.round(d);
            out.write((number.toString() + " ").getBytes());
        }
        out.flush();
    }

    private static List<Double> byteArrToDoubleList(byte[] buff) {
        List<Double> doubles = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (byte b : buff) {
            if (b != (byte) ' ') {
                sb.append((char) b);
            } else {
                doubles.add(Double.parseDouble(sb.toString()));
                sb = new StringBuilder();
            }
        }
        doubles.add(Double.parseDouble(sb.toString()));
        return doubles;
    }
}

/*public class Solution {
    public static void main(String[] args) {

    }
}*/
