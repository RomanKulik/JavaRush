package com.javarush.task.task19.task1911;

/* 
Ридер обертка
Ридер обертка
В методе main подмени объект System.out написанной тобой
ридер-оберткой по аналогии с лекцией.
Твоя ридер-обертка должна преобразовывать весь текст в заглавные буквы.
Вызови готовый метод printSomething(), воспользуйся testString.
Верни переменной System.out первоначальный поток.
Выведи модифицированную строку в консоль.


Требования:
1. Класс Solution должен содержать класс TestString.
2. Класс Solution должен содержать публичное статическое
поле testString типа TestString, которое сразу проинициализировано.
3. Класс TestString должен содержать публичный void метод printSomething().
4. Метод printSomething() класса TestString должен выводить на экран строку
"it's a text for testing".
5. Метод main(String[] args) класса Solution должен создавать
поток PrintStream (используй PrintStream c конструктором принимающим ByteArrayOutputStream).
6. Метод main(String[] args) класса Solution должен подменять
и восстанавливать поток вывода в консоль объекта System.out.
7. Метод main(String[] args) класса Solution должен вызывать
метод printSomething(),объекта testString.
8. Метод main(String[] args) класса Solution должен модифицировать
строку выведенную методом printSomething() согласно заданию, и выводить её в консоль.
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        //копия out. Поток вывода - консоль
        PrintStream copyOut = System.out;

        // поток, в который выводится инфа = OutputStream(), т.е.
        // поток вывода может быть любой: консоль, файл, URL и т.д.
        // class FilterOutputStream extends OutputStream
        // public class PrintStream extends FilterOutputStream
        // public PrintStream(OutputStream out) {this(out, false)};
        // public PrintStream(String fileName) {this(false, new FileOutputStream(fileName))};
        // public PrintStream(File file) {this(false, new FileOutputStream(file));}

        // поток вывода - динамический массив байт
        // System.out.someMethod() будет записывать в ByteArrayOutputStream
        ByteArrayOutputStream barr = new ByteArrayOutputStream();
        System.setOut(new PrintStream(barr));

        // или
        // поток вывода - файл
        // System.out.someMethod() будет записывать в файл
        System.setOut(new PrintStream(new FileOutputStream("paht")));

        // Пишется это все методом write() (методы print() и println() вызывают у себя write())
        // класса PrintStream в OutputStream через:
        // PrintStream(BufferedWriter && OutputStreamWriter) -> FilterOutputStream -> OutputStream

        // теперь все данные, пока не установится новое значение System.out,
        // отсылаемые в поток вывода System.out,
        // который был переопределен
        // (был: System.out -> консоль:
        // System -> private static native void setOut0(PrintStream out)
        // стал: System.out -> byteArray, или к-л файл)
        // попадают в то место, которое указано в переменной System.out
        testString.printSomething();

        // переопределяем поток вывода на первоначальный - консоль
        System.setOut(copyOut);
        System.out.println(barr.toString().toUpperCase());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
