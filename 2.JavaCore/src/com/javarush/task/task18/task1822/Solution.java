package com.javarush.task.task18.task1822;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Hashtable;
import java.util.List;

/*
Поиск данных внутри файла
Поиск данных внутри файла
Считать с консоли имя файла.
Найти в файле информацию, которая относится к заданному id,
и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int).
Закрыть потоки.

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity
где id - int.
productName - название товара, может содержать пробелы, String.
price - цена, double.
quantity - количество, int.

Информация по каждому товару хранится в отдельной строке.


Требования:
1. Программа должна считать имя файла с консоли.
2. Создай для файла поток для чтения.
3. Программа должна найти в файле и вывести информацию о id, который передается первым параметром.
4. Поток для чтения из файла должен быть закрыт.

точка в начале файла UTF8
https://ru.stackoverflow.com/questions/614622/%D0%BB%D0%B8%D1%88%D0%BD%D0%B8%D0%B9-%D1%81%D0%B8%D0%BC%D0%B2%D0%BE%D0%BB-%D0%BF%D1%80%D0%B8-%D1%87%D1%82%D0%B5%D0%BD%D0%B8%D0%B8-%D0%B8%D0%B7-utf-8-%D1%84%D0%B0%D0%B9%D0%BB%D0%B0-%D0%B2-set-java
1.точка что мне не нравилась называется \uFEFF
2.в начале UTF-8 файла есть символ BOM(Byte Order Mark)
и с помощью Notepad++(в Windows) или Notepadqq(в Linux)
можно сохранить файл в UTF без BOM.
(Меню Encoding > Convert to UTF-8 without BOM)
*/


public class Solution {
    private static final int ID = 2;
    private static final String FILE_NAME = "d:/db.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream in = new FileInputStream(reader.readLine()/*FILE_NAME*/)) {
            int id = args.length == 0 ? ID : Integer.parseInt(args[0]);
            Hashtable<Integer, String> map = getProductMapFromFile(in);
            System.out.println(id + map.get(id));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static Hashtable<Integer, String> getProductMapFromFile(FileInputStream in) throws IOException {
        Hashtable<Integer, String> map = new Hashtable<>();
        //BufferedReader reader = new BufferedReader(new FileReader(in.getFD()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        Product product;
        String string;
        while ((string = reader.readLine()) != null) {
            product = parceString(string); // считать строку из файла и распарсить ее
            map.put(product.getId(), product.getInfo()); // добавить Product в map
        }
        reader.close();
        return map;
    }

    private static Product parceString(String string) throws UnsupportedEncodingException {
        int firstSpaceIndex = string.indexOf(' ');
        String idString = string.substring(0, firstSpaceIndex).trim();
        int id = Integer.parseInt(idString);

        String info = string.substring(firstSpaceIndex);
        info = new String(info.getBytes(), StandardCharsets.UTF_8);
        return new Product(id, info);
    }

    private static class Product {
        private int id;
        private String info;

        public Product(int id, String info) {
            this.id = id;
            this.info = info;
        }

        public int getId() {
            return id;
        }

        public String getInfo() {
            return info;
        }
    }

    /*private class Product1 {
        // id productName price quantity
        private int id;
        private String productName;
        double price;
        int quantity;

        public Product1(int id, String productName, double price, int quantity) {
            this.id = id;
            this.productName = productName;
            this.price = price;
            this.quantity = quantity;
        }

        public int getId() {
            return id;

        }

        public String getProductName() {
            return productName;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }

        @Override
        public String toString() {
            // id productName price quantity
            return "id: " + this.getId() +
                    "name: " + this.getProductName() +
                    "price: " + this.getPrice() +
                    "quantity: " + this.getQuantity();
        }
    }*/
}

/*public class Solution {
    public static void main(String[] args) {
    }
}*/
