package com.javarush.task.task19.task1906;

/* 
Четные символы
Четные символы
Считать с консоли 2 имени файла.
Вывести во второй файл все символы с
четным порядковым номером (нумерация начинается с 1).

Пример первого файла:
text in file
Вывод во втором файле:
eti ie
Закрыть потоки ввода-вывод


Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла
(используй FileReader c конструктором String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна записывать во второй файл
все байты из первого файла с четным порядковым номером (используй FileWriter).
6. Поток записи в файл (FileWriter) должен быть закрыт.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fr = new FileReader(reader.readLine());
        FileWriter fw = new FileWriter(reader.readLine());
        reader.close();

        int count = 1;
        while (fr.ready()) {
            int b = fr.read();
            if (count % 2 == 0)
                fw.write(b);
            count++;
        }

        fw.flush();
        fr.close();
        fw.close();

    }
}

/*public class Solution {
    public static void main(String[] args) {
    }
}*/
