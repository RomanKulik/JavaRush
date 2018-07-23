package com.javarush.task.task19.task1904;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
В классе адаптере создать приватное финальное поле Scanner fileScanner.
Поле инициализировать в конструкторе с одним аргументом типа Scanner.

Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950
Петров Петр Петрович 31 12 1957

В файле хранится большое количество людей,
данные одного человека находятся в одной строке.
Метод read() должен читать данные только одного человека.


Требования:
1. PersonScanner должен быть интерфейсом.
2. Класс PersonScannerAdapter должен реализовывать интерфейс PersonScanner.
3. Класс PersonScannerAdapter должен содержать приватное поле fileScanner типа Scanner.
4. Класс PersonScannerAdapter должен содержать конструктор с параметром Scanner.
5. Метод close() класса PersonScannerAdapter
должен делегировать полномочие такому же методу fileScanner.
6. Метод read() класса PersonScannerAdapter
должен читать строку с файла, парсить её,
и возвращать данные только одного человека, в виде объекта класса Person.
*/
public class Solution {

    public static void main(String[] args) throws IOException, ParseException {
        new PersonScannerAdapter(new Scanner(new FileInputStream("d:/1.txt"),"UTF-8")).read();
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
            //Иванов Иван Иванович 31 12 1950
           /* String lastName = this.fileScanner.next();
            String firstName = this.fileScanner.next();
            String middleName = this.fileScanner.next();
            int day = this.fileScanner.nextInt();
            int month = this.fileScanner.nextInt();
            int year = this.fileScanner.nextInt();
            Date date = new SimpleDateFormat("dd/MM/yyyy").
                    parse(String.format("%d/%d/%d", day, month, year));*/
            String str = "";
            if (this.fileScanner.hasNext())
                str = this.fileScanner.nextLine();
            System.out.println(str);
            String[] strs = str.split("\\s");
            System.out.println(Arrays.toString(strs));
            Date date = new SimpleDateFormat("dd/MM/yyyy").
                    parse(String.format("%s/%s/%s", strs[3], strs[4], strs[5]));
            return new Person(strs[1], strs[2], strs[0], date);
        }

        @Override
        public void close() throws IOException {
            this.fileScanner.close();
        }
    }
}
/*public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter {

    }
}*/
