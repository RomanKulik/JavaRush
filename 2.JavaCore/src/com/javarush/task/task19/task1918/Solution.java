package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат.

Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>

Первым параметром в метод main приходит тег. Например, "span".
Вывести на консоль все теги, которые соответствуют заданному тегу.
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле.
Количество пробелов, \n, \r не влияют на результат.
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нет.
Тег может содержать вложенные теги.

Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>
text1, text2 могут быть пустыми

Требования:
1. Программа должна считывать имя файла с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое файла (используй FileReader).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна выводить в консоль все теги, которые соответствуют тегу, заданному в параметре метода main.

3 примера JSoup https://javarush.ru/groups/posts/10ф86-3-primera-kak-razobratjh-html-fayl-v-java-ispoljhzuja-jsoup
http://developer.alexanderklimov.ru/android/library/jsoup.php
*/

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String tag = args.length == 0 ? "span" : args[0];
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fr = new BufferedReader(new FileReader(reader.readLine()))) {
           //Document doc = Jsoup.connect("http://developer.alexanderklimov.ru/android/library/jsoup.php").get();
            //Document doc = Jsoup.parse(new File("D:/0.html"), "UTF-8");
            //System.out.println(doc.select(tag));
            StringBuilder sb = new StringBuilder();
            while (fr.ready())
                sb.append(fr.readLine());
            Document //doc = Jsoup.parse(sb.toString());
            doc = Jsoup.parse(sb.toString(), "", Parser.xmlParser());
            System.out.println(doc.select(tag));
        } catch (IOException e) {
            System.out.println(e);
        } catch (NullPointerException e){
            System.out.println(e);
        }
    }

}
/*
public class Solution {
    public static void main(String[] args) {

    }
}*/
