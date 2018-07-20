package com.javarush.task.task18.task1827;

/* 
Прайсы
Прайсы
CrUD для таблицы внутри файла.
Считать с консоли имя файла для операций CrUD.

Программа запускается со следующим набором параметров:
-c productName price quantity

Значения параметров:
id - 8 символов.
productName - название товара, 30 символов.
price - цена, 8 символов.
quantity - количество, 4 символа.
-c - добавляет товар с заданными параметрами в конец файла,
генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле.

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity

Данные дополнены пробелами до их длины.

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234


Требования:
1. Программа должна считать имя файла для операций CrUD с консоли.
2. В классе Solution не должны быть использованы статические переменные.
3. При запуске программы без параметров список товаров должен остаться неизменным.
4. При запуске программы с параметрами "-c productName price quantity"
в конец файла должна добавится новая строка с товаром.
5. Товар должен иметь следующий id, после максимального, найденного в файле.
6. Форматирование новой строки товара должно четко совпадать с указанным в задании.
7. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        String filename = "d:/file.txt";
        String resultString = "Шорты пляжные розовенькие с рисунко174.00  18";
        if (args.length != 0) {
            filename = new BufferedReader(new InputStreamReader(System.in)).readLine();
        } else {return;}

        try (BufferedReader reader = new BufferedReader(new FileReader(filename));
             BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            ArrayList<String> fileContent = getFileContent(reader);
            int maxID = getMaxId(fileContent);
            Product p = new Product(Product.generateNextID(String.valueOf(maxID)),
                    args[1], args[2], args[3]);
            writer.newLine();
            writer.write(p.toString());
            writer.flush();
        }
    }

    private static ArrayList<String> getFileContent(BufferedReader reader) throws IOException {
        ArrayList<String> arrayList = new ArrayList<>();
        String next;
        while ((next = reader.readLine()) != null) {
            arrayList.add(next);
        }
        return arrayList;
    }

    private static int getId(ArrayList<String> arrayList) {
        String lastString = arrayList.get(arrayList.size() - 1);
        String ids = lastString.substring(0, 8);
        return Integer.parseInt(ids.trim());
    }

    private static int getMaxId(ArrayList<String> arrayList) {
        int max = 0;
        for (String s : arrayList) {
            if ("".equals(s))continue;
            if (s.contains("\uFEFF")) // проверка на начальный символ BOM в UTF файле
                s = s.substring(1, s.length());
            int id = Integer.parseInt(s.substring(0, 8).trim());
            max = Math.max(max, id);
        }
        return max;
    }
}

/*public class Solution {
    public static void main(String[] args) throws Exception {
    }
}*/
