package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.*;

/* 
Писатель в файл с консоли
Итак, вам нужно записать кое-что в файл.
Для этого первым делом вы читаете с консоли имя файла,
затем считываете строки до тех пор, пока пользователь не введёт слово exit и,
наконец, выводите абсолютно все введённые строки в файл, каждую строчку с новой строки.

Писатель в файл с консоли
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку «exit«.
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой строки.


Требования:
1. Программа должна считывать c консоли имя файла.
2. Создай и используй объект типа BufferedWriter.
3. Программа не должна ничего читать из файловой системы.
4. Программа должна читывать строки с консоли, пока пользователь не введет строку "exit".
5. Программа должна записать абсолютно все введенные строки (включая "exit") в файл, каждую строчку с новой строки.
6. Метод main должен закрывать объект типа BufferedWriter после использования.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        BufferedWriter writer = new BufferedWriter(new FileWriter(scanner.nextLine()));

        String s;

        do {
            s = scanner.nextLine();
            writer.write(s);
            writer.newLine();
        } while (!s.equals("exit"));

       /* BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> strings = new LinkedList<String>();
       *//* strings.add("fifa");
        strings.add("olga");
        strings.add("Dedushka");
        strings.add("exit");*//*

        String fileName = reader.readLine();
        //String fileName = "d:\\file.txt";
        //fileName = "d:\\file.doc";

        while (true) {
            String string = reader.readLine();
            strings.add(string);
            if (string.equals("exit"))
                break;
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));

        if (writer != null) {
            strings.forEach(s -> {
                try {
                    writer.write(s);
                    //writer.append('\n');
                    writer.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
*/

      //  writer.write("Хокку \nПодобен лучу самурайский клинок \nИ тот затупился \nПроклятая килька в томате!!");


        //strings.forEach(s -> System.out.println(s)); //вывод

        //reader.close();
        writer.close();


        /*
        d:\\file.txt
fifa
olga
Dedushka
exit
        */
    }
}
/*public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
    }
}*/
