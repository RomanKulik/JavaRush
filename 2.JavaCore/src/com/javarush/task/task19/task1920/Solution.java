package com.javarush.task.task19.task1920;

/* 
Самый богатый
Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Вывести в консоль имена в алфавитном порядке, у которых максимальная сумма.
Имена разделять пробелом либо выводить с новой строки.
Закрыть потоки.

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое файла (используй FileReader).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна выводить в консоль имена, у которых максимальная сумма.
*/

import java.io.*;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        String fileName = args.length == 0 ? "d:/1.txt" : args[0];
        Map<String, Double> map = new TreeMap<>();
        try (BufferedReader fr = new BufferedReader(new FileReader(fileName))) {
            while (fr.ready()) {
                String[] ss = fr.readLine().split(" ");
                if (map.containsKey(ss[0])) {
                    double val = map.get(ss[0]) + Double.parseDouble(ss[1]);
                    map.put(ss[0], val);
                } else {
                    map.put(ss[0], Double.parseDouble(ss[1]));
                }
            }
            double max = Collections.max(map.values());
            for (Map.Entry<String, Double> entry : map.entrySet()) {
                if (entry.getValue() == max)
                    System.out.println(entry.getKey());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
