package com.javarush.task.task17.task1721;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/* 
Транзакционность
Транзакционность
Сделать метод joinData транзакционным,
т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов.
Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines,
то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если условие из п.3 не выполнено, то:
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main.
Все исключения обработайте в методе main.
Не забудь закрыть потоки.


Требования:
1. Класс Solution должен содержать public static поле allLines типа List.
2. Класс Solution должен содержать public static поле forRemoveLines типа List.
3. Класс Solution должен содержать public void метод joinData() который может бросать исключение CorruptedDataException.
4. Программа должна считывать c консоли имена двух файлов.
5. Программа должна считывать построчно данные из первого файла в список allLines.
6. Программа должна считывать построчно данные из второго файла в список forRemoveLines.
7. Метод joinData должен удалить в списке allLines все строки из списка forRemoveLines, если в allLines содержаться все строки из списка forRemoveLines.
8. Метод joinData должен очистить список allLines и выбросить исключение CorruptedDataException, если в allLines не содержаться все строки из списка forRemoveLines.
9. Метод joinData должен вызываться в main.
*/
public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            File file1 = new File(reader.readLine());
            File file2 = new File(reader.readLine());
            reader.close();

            //Files.readAllLines(Paths.get(file.getAbsolutePath()), StandardCharsets.UTF_8).forEach(System.out::println);

            readFromFileWriteToList(file1, allLines);
            printList(allLines);
            readFromFileWriteToList(file2, forRemoveLines);
            printList(forRemoveLines);

            new Solution().joinData();
            printList(allLines);
            printList(forRemoveLines);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void printList(List<String> list) {
        for (String s :
                list) {
            System.out.println(s);
        }
    }

    private static void readFromFileWriteToList(File file, List<String> list) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(file), Charset.forName("UTF-8")));

        //list.addAll(Files.readAllLines(Paths.get(file.getAbsolutePath()), StandardCharsets.UTF_8));
        //list.addAll(reader.lines().collect(Collectors.toList()));

        String str;
        while ((str = reader.readLine()) != null) {
            list.add(str);
        }

        reader.close();
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
/*public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
    }

    public void joinData () throws CorruptedDataException {

    }
}*/
