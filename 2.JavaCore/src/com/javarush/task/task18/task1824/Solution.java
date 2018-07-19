package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
Файлы и исключения
Читайте с консоли имена файлов.
Если файла не существует (передано неправильное имя файла),
то перехватить исключение FileNotFoundException,
вывести в консоль переданное неправильное имя файла и завершить работу программы.
Закрыть потоки.
Не используйте System.exit();


Требования:
1. Программа должна считывать имена файлов с консоли.
2. Для каждого файла нужно создавать поток для чтения.
3. Если файл не существует, программа должна перехватывать исключение FileNotFoundException.
4. После перехвата исключения, программа должна вывести имя файла в консоль и завершить работу.
5. Потоки для чтения из файла должны быть закрыты.
6. Команду "System.exit();" использовать нельзя.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<FileInputStream> list = new ArrayList();
        String fileName = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while ((fileName = reader.readLine()) != null)
                list.add(new FileInputStream(fileName));
        } catch (FileNotFoundException e) {
            System.out.println(fileName);
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            for (FileInputStream f : list) {
                try {
                    f.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

/*public class Solution {
    public static void main(String[] args) {
    }
}*/
