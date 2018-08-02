package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени.
Закрыть потоки.

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое файла (используй FileReader).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна выводить в консоль каждое имя и сумму всех его значений,
все данные должны быть отсортированы в возрастающем порядке по имени.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        String fileName = args.length == 0 ? "d:/1.txt" : args[0];
        Map<String, Double> map = new TreeMap<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fr = new BufferedReader(new FileReader(fileName))) {
            while (fr.ready()) {
                String[] ss = fr.readLine().split(" ");
                if (map.containsKey(ss[0])) {
                    double val = map.get(ss[0]);
                    val += Double.parseDouble(ss[1]);
                    map.put(ss[0], val);
                } else {
                    map.put(ss[0], Double.parseDouble(ss[1]));
                }
            }
            map.forEach((k, v) -> System.out.println(k + " " + v));
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
