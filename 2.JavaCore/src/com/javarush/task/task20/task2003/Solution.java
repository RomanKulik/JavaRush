package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполни
карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуй логику записи в файл и чтения из файла для карты properties.


Требования:
1. Метод fillInPropertiesMap должен считывать данные с консоли.
2. Метод fillInPropertiesMap должен создавать FileInputStream,
передавая считанную строку в качестве параметра.
3. Метод fillInPropertiesMap должен вызывать метод load передавая
только что созданный FileInputStream в качестве параметра.
4. Метод save должен сохранять карту properties в полученный
в качестве параметра объект типа OutputStream.
5. Метод load должен восстанавливать состояние карты properties
из полученного в качестве параметра объекта типа InputStream.
*/

public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        load(new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine()));
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties p = new Properties();
        properties.forEach((k, v) -> p.setProperty(k, v));
        p.store(outputStream, null);
        outputStream.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties p = new Properties();
        p.load(inputStream);
        p.forEach((k, v) -> properties.put(String.valueOf(k), String.valueOf(v)));
        inputStream.close();
    }

    public static void main(String[] args) throws Exception {
    }
}

/*public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() {
        //implement this method - реализуйте этот метод
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            this.load(new FileInputStream(reader.readLine()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        try (PrintWriter pw = new PrintWriter(outputStream)) {
            properties.forEach((k, v) -> pw.print(k + "=" + v + System.lineSeparator()));
        }
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        try (FileInputStream fis = (FileInputStream) inputStream;
             BufferedReader fr = new BufferedReader(new FileReader(fis.getFD()))) {
            while (fr.ready()) {
                String s = fr.readLine();
                int delimPosEq = s.indexOf('=');
                int delimPosCol = s.indexOf(':');
                int delimPos = (delimPosEq != -1 && delimPosCol != -1) ?
                        Math.min(delimPosEq, delimPosCol) :
                        (delimPosEq == -1 && delimPosCol == -1) ?
                                -1 : Math.max(delimPosEq, delimPosCol);
                if (delimPos == -1) return; // разделитель не = или :
                String key = s.substring(0, delimPos).trim();
                String value = s.substring(delimPos + 1).trim();
                properties.put(key, value);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        sol.fillInPropertiesMap();
        System.out.println(properties);
        OutputStream fos = new FileOutputStream("d:/2.txt");
        sol.save(fos);
    }
}*/

/*public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() {
        //implement this method - реализуйте этот метод
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
    }

    public static void main(String[] args) {

    }
}*/
