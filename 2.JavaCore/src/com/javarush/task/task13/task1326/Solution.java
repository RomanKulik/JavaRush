package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
Сортировка четных чисел из файла
Если упорядоченный изоморф не уверен в трезвости другого упорядоченного изоморфа,
он просит его пройти простенький тестик:
сначала ввести имя файла с консоли,
прочитать из него набор чисел, а затем вывести на консоль только четные,
отсортированные по возрастанию.
Получится?

Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.

Пример ввода:
5
8
11
3
2
10

Пример вывода:
2
8
10


Требования:
1. Программа должна считывать данные с консоли.
2. Программа должна создавать FileInputStream для введенной с консоли строки.
3. Программа должна выводить данные на экран.
4. Программа должна вывести на экран все четные числа считанные из файла отсортированные по возрастанию.
5. Программа должна закрывать поток чтения из файла(FileInputStream).
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        /*FileOutputStream fileOutputStream = new FileOutputStream("D:\\file1.txt");
        for (int i = 0; i < 11; i++) {
            fileOutputStream.write(i);
        }*/

        //String fileName = new Scanner(System.in).nextLine();    //D:\\file.txt
                                                                //D:\\file.doc
                                                                //fileName = "D:\\file1.txt";

        //BufferedReader fileInputStream = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        /*FileInputStream fileInputStream = new FileInputStream(new Scanner(System.in).nextLine());
        ArrayList <Integer> arrEven = new ArrayList<>();

        while (fileInputStream.available() != 0) {
            int num = fileInputStream.read();
            if (num % 2 == 0) {
                arrEven.add(num);
            }
        }

        Collections.sort(arrEven);
        for (Integer integer : arrEven) {
            System.out.println(integer);
        }
        //arrEven.forEach(System.out::println);

        fileInputStream.close();*/

        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        reader=new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));
        ArrayList<Integer> numbs=new ArrayList<>();
        /*for(int i=Integer.parseInt(reader.readLine());;i=Integer.parseInt(reader.readLine())){
            if(i%2==0)numbs.add(i);
            if(!reader.ready())break;
        }*/
        for ( ; reader.ready(); ){
           int i = Integer.parseInt(reader.readLine());
            if(i % 2 == 0) {
                numbs.add(i);
            }
        }

        Collections.sort(numbs);
        for(int i : numbs)
            System.out.println(i);
        reader.close();
    }
}
/*public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
    }
}*/
