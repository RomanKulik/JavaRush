package com.javarush.task.task14.task1421;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class H {
    public static void main(String[] args) {
        // https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
        // https://www.youtube.com/watch?v=WOYyYwNj7TU&index=1&list=PL786bPIlqEjQsE_WAcKpkZ-Q4T-A8j1D2

        // RegEx 1-3:
        Pattern p1 = Pattern.compile("\\Q1+1=2\\E");
        Matcher m1 = p1.matcher("1+1=2"); // true
        Pattern p2 = Pattern.compile("1\\+1=2");
        Matcher m2 = p2.matcher("1+1=2"); // true

        while (m1.find())
            System.out.println(m1.start() + " " + m1.group() + " "); // 0 1+1=2 - в нулевой позиции есть это выражение

        System.out.println("ab.cd".matches("\\w+\\.\\D+")); // true

        Pattern p3 = Pattern.compile("[a-c]"); //[0-9], [a-zA-G!%=]
        Matcher m3 = p3.matcher("abcdc"); // 0 a 1 b 2 c 4 c

        Pattern p4 = Pattern.compile("gr[ae]y"); //
        Matcher m4 = p4.matcher("gray"); // gray = grey

        // []\^$.|?*+() - метасимволы регулярок, которые нужно экранировать.
        // Внутри [] эти символы экранировать не нужно - [$]
        Pattern p5 = Pattern.compile("[+]");
        Matcher m5 = p5.matcher("1+1=2"); // 1 +

        // ]\^-  -  специальные символы
        // ^ - карет. Отрицание - НЕ

        Pattern p6 = Pattern.compile("q[^u]"); // найти символ q за которым следует не u

        Pattern p7 = Pattern.compile("[-x\\\\]"); // найти символ '-' и 'x'
        Matcher m7 = p7.matcher("jx-k-x\\"); // 1 x 2 - 4 - 5 x 6 \
        printRegEx(m7);

        //\Q...\E
        Pattern p8 = Pattern.compile("\\Q[-]\\E"); // найти символы '[' '-' ']'

        // google: java api pattern
        // https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
        /*
        *Character classes
        [abc] 	a, b, or c (simple class)
        [^abc] 	Any character except a, b, or c (negation)
        [a-zA-Z] 	a through z or A through Z, inclusive (range)
        [a-d[m-p]] 	a through d, or m through p: [a-dm-p] (union)
        [a-z&&[def]] 	d, e, or f (intersection)
        [a-z&&[^bc]] 	a through z, except for b and c: [ad-z] (subtraction)
        [a-z&&[^m-p]] 	a through z, and not m through p: [a-lq-z](subtraction)
        */

        /*
        * Predefined character classes
        . 	Any character (may or may not match line terminators)
        \d 	A digit: [0-9]
        \D 	A non-digit: [^0-9]
        \s 	A whitespace character: [ \t\n\x0B\f\r]
        \S 	A non-whitespace character: [^\s]
        \w 	A word character: [a-zA-Z_0-9]
        \W 	A non-word character: [^\w]
        */

        Pattern p9 = Pattern.compile("[0-9]");
        Matcher m9 = p9.matcher("jk3klwk3j5k6j7 45"); // 2 3 7 3 9 5 11 6 13 7 15 4 16 5
        printRegEx(m9);
        Pattern p10 = Pattern.compile("[0-9]+");
        Matcher m10 = p10.matcher("jk3klwk3j5k6j7 45"); //2 3 7 3 9 5 11 6 13 7 15 45
        printRegEx(m10);
        Pattern p11 = Pattern.compile("[^0-9]");
        Matcher m11 = p11.matcher("jk3klwk3j5k6j7 45"); //0 j 1 k 3 k 4 l 5 w 6 k 8 j 10 k 12 j 14
        printRegEx(m11);

        //????????
        Pattern p12 = Pattern.compile("[0-9]{1,6}");
        Matcher m12 = p12.matcher("jk3klwk3j5k6j7 45"); //0 j 1 k 3 k 4 l 5 w 6 k 8 j 10 k 12 j 14
        printRegEx(m12);

        // RegEx 4: точка '.' - заменяет любой символ, кроме "Конец строки"
        // Конец строки: [\n] - unix; [\r\n] - windows
        Pattern p13 = Pattern.compile("\\d\\d.\\d\\d.\\d\\d");
        Matcher m13 = p13.matcher("2241292017"); // за разделитель примет любой знак. Здесь цифра
        Pattern p14 = Pattern.compile("\\d\\d[- /.]\\d\\d[- /.]\\d\\d");
        Matcher m14 = p13.matcher("22.12.2017"); // || 22-12-2017 || 22 12 2017 || 22/12/2017

        // Найти строку между двух символов
        // между кавычками найти любой символ '.', встречающийся любое кол-во раз '*'
        Pattern p15 = Pattern.compile("\".*\""); // greedy оператор - захватит все от первой открывающей до последней
        Matcher m15 = p15.matcher("Put a \"String\" between double quotes");
        // "String one" and "String two"
        Matcher m16 = p15.matcher("Huston, we have a problem with \"String one\" and \"String two\". Please respond!");

        // reluctant quantifier - захватить только 2 строки в кавычках
        Pattern p17 = Pattern.compile("\".*?\"");
        Matcher m17 = p17.matcher("Huston, we have a problem with \"String one\" and \"String two\". Please respond!"); // 32 "String one" 40 "String two"
        // найти строчку между кавычками, в которых не всретятся указанные символы,
        // и таких строчек может быть много '*'
        Pattern p18 = Pattern.compile("\"[^\"\r\n]*\""); // 32 "String one" 40 "String two"
        Matcher m18 = p18.matcher("Huston, we have a problem with \"String one\" and \"String two\". Please respond!");


        // RegEx 5: Word boundaries
        // \bbirdb\ - найдет слово bird
        // \bbird   - найдет слова, начинающиеся с bird
        // \B - ^\b - символы разрыва слов: пробел, табуляция, новая строка и т.д.
        // \w / \W - буквы ([a-zA-Z_0-9]) / не буквы
        // \bw+\b - разделитель слов
        Pattern p19 = Pattern.compile("\bis\b");
        Matcher m19 = p19.matcher("This island is beautiful"); // 12 is - из всех is найдет только то, которое разделено пробелами


        // RegEx 6: Начало и конец строки
        // Начало '^' или '\A' и конец строки '$' или '\Z'(не учитывает \n) '\z'(учитывает \n)
        // [^] - это отрицание!
        Pattern p20 = Pattern.compile("^a");
        Matcher m20 = p20.matcher("abc"); // найдет в начале строки 'a'
        Pattern p21 = Pattern.compile("$c");
        Matcher m21 = p21.matcher("abc"); // найдет в конце строки 'c'
        Pattern p22 = Pattern.compile("$b");
        Matcher m22 = p22.matcher("abc"); // ничего не найдет

        Pattern p23 = Pattern.compile("\\Ane\\Z", Pattern.MULTILINE); // 8 ne 20 ne
        //Pattern p23 = Pattern.compile("\\^ne\\$"); // 20 ne
        Matcher m23 = p23.matcher("First line\nsecond line");

        Pattern p24 = Pattern.compile("^\\d*$");
        Matcher m24 = p24.matcher(""); // 0   - найдет ничего, но выдаст позицию. при обращении к элементы будет Exception

        // RegEx 7: Pipeline '|' - или
        // Ищет вхождение одного или другого слова
        Pattern p25 = Pattern.compile("cat|dog");
        Matcher m25 = p25.matcher("I love my cat"); // 10 cat

        Pattern p26 = Pattern.compile("Get|GetValue|Set|SetValue");
        Matcher m26 = p26.matcher("SetValue"); // 0 Set

        //? - предыдущий элемент необязателен, но по возможности включает его
        Pattern p27 = Pattern.compile("(Get|Set)(Value)?"); // если не будет Value, найдет Set
        Matcher m27 = p27.matcher("SetValue"); // 0 SetValue
        printRegEx(m27);

        // RegExp 9: Символы '*' или '{0,}' и '+' или {1,}
        // '\b' - обрыв слова
        // найти все тэги в html документе
        Pattern p28 = Pattern.compile("<[a-zA-Z][a-zA-Z0-9]*"); // если + - не найдет одиночный тэг
        //Matcher m28 = p28.matcher("<a>"); //
        Matcher m28 = p28.matcher("<h1>"); //

        // Промежутки
        // {2,} от 2 до бесконечности
        // {2} ровно 2
        // {2,4} от 2 до 4 раз
        Pattern p29 = Pattern.compile("\\b[1-9][0-9]{3}\\b");// найти число, в котором первая цифра 1, а 3 последующие от 0 до 9
        Matcher m29 = p29.matcher("10 101 1001 10001 100001"); // 7 1001
        Pattern p30 = Pattern.compile("\\b[1-9][0-9]{2,4}\\b");// найти число, в котором первая цифра 1, а 3 последующие от 0 до 9
        Matcher m30 = p30.matcher("10 101 1001 10001 100001"); // 3 101 7 1001 12 10001
        printRegEx(m30);

        // gridy и lazy (добавляется '?')
        Pattern p31 = Pattern.compile("<.*>");
        Matcher m31 = p31.matcher("<EM> first </EM> test"); //0 <EM> first </EM>
        Pattern p32 = Pattern.compile("<.*?>");
        Matcher m32 = p32.matcher("<EM> first </EM> test"); // 0 <EM> 11 </EM>
        Pattern p33 = Pattern.compile("<[^>]+>");
        Matcher m33 = p33.matcher("<EM> first </EM> test"); // 0 <EM> 11 </EM>
        printRegEx(m33);


        //RegExp 10: Группы
        // backreference = ().
        Pattern p34 = Pattern.compile("(Get|Set)(?:Value)?"); // ?: не будет запомирать и создавать backrefference

        Pattern p35 = Pattern.compile("<([a-zA-z][a-zA-z0-9]*)[^]]*>.*?</\\1>"); // \\1 - подставить то, что было найдено в первой скобке, т.н. EM
        Matcher m35 = p35.matcher("SetValue"); // 0 SetValue
        Pattern p36 = Pattern.compile("([a-c])x([b-c])x\\2x\\1x.*\\2x"); //
        Matcher m36 = p36.matcher("axbxbxaxvasyabx"); // 0 axbxbxaxvasyabx - (ax)= ([a-c])x = \\1x (bx) = ([b-c])x = \\2
        printRegEx(m36);

        Pattern p37 = Pattern.compile("([abc]+)=\\1");
        Matcher m37 = p37.matcher("cab=cab"); // 0 cab=cab
        Pattern p38 = Pattern.compile("([abc])+=\\1");
        Matcher m38 = p38.matcher("cab=b"); // 0 cab=b
        printRegEx(m37);
        printRegEx(m38);

        // \\s - пробел \\b - начало слова
        // найти начало слова, какие-то буквы, пробел, слово в скобках.
        // Заменить на выражение, которое найдено последний раз, соответствующее RegEx в скобках
        System.out.println("the the".replaceAll("\\b(\\w+)\\s+\\1", "$1")); // the

        Pattern p39 = Pattern.compile("[(a)b\1]"); // literal
        Matcher m39 = p39.matcher("abc()\\1"); //0 a 1 b 3 ( 4 )
        printRegEx(m39);


        // RegExp 11: Именованные группы
        System.out.println("abc".replaceAll("(?<Aletter>a)", "${Aletter}-")); //a-bc
        Pattern p40 = Pattern.compile("<(?<tag>[a-zA-Z0-9]*)[^>]*>.*?</\\k<tag>>"); // </\\1> -> </\k<tag>>
        Matcher m40 = p40.matcher("This is <EM>first</EM>test"); //8 <EM>first</EM>
        printRegEx(m40);

        System.out.println("abcd".replaceAll("(a)(?<x>b)(c)(?<y>d)", "$1$2$3$4"));
        System.out.println("abcd".replaceAll("(a)(?<x>b)(c)(?<y>d)", "$1${x}$3${y}"));


        // RegExp 12: Unicode


    }

    protected static void printRegEx(Matcher m) {
        while (m.find())
            System.out.print(m.start() + " " + m.group() + " ");
        System.out.println("");
    }

}
