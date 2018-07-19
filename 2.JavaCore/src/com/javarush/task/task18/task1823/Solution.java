package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit".
Передайте имя файла в нить ReadThread.
Нить ReadThread должна найти байт,
который встречается в файле максимальное число раз,
и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки.


Требования:
1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "exit".
2. Для каждого файла создай нить ReadThread и запусти ее.
3. После запуска каждая нить ReadThread должна создать свой поток для чтения из файла.
4. Затем нити должны найти максимально встречающийся байт в своем файле и добавить его в словарь resultMap.
5. Поток для чтения из файла в каждой нити должен быть закрыт.
*/
public class Solution {
    public volatile static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
           startProgram(reader);
        } catch (IOException e) {
            System.out.println(e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void startProgram(BufferedReader reader) throws IOException, InterruptedException {
        for (String fileName = reader.readLine();
             !fileName.equals("exit");
             fileName = reader.readLine())
       /* String fileName;
        while (!(fileName = reader.readLine()).equals("exit"))*/ {
            ReadThread rt = new ReadThread(fileName);
            rt.start();
            rt.join();
        }
    }

    public static class ReadThread extends Thread {
        private FileInputStream in;
        private String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
            try {
                this.in = new FileInputStream(fileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            int maxByte = 0;
            try {
                maxByte = findMaxByte();
                addToMap(fileName, maxByte);
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                closeQuietly();
            }
        }

        private int findMaxByte() throws IOException {
            Map<Integer, Integer> map = new TreeMap<>(); // сортирует уникальные ключи
            List<Integer> bytes = fileToByteList(); // Получить коллекцию байт

           for (Integer oneByte : bytes){ // записать байты в map и их частоты
               int freq = Collections.frequency(bytes, oneByte);
               map.put(freq, oneByte);
           }
            // найти max в частотах
            int maxFreq = ((TreeMap<Integer, Integer>) map).lastKey();

            return map.get(maxFreq); // получить байт, соответствующий max частоте
        }

        private List<Integer> fileToByteList() throws IOException {
            List<Integer> list = new ArrayList<>();
            while (in.available() > 0)
                list.add(in.read());
            return list;
        }

        private void addToMap(String fileName, int maxByte) {
            synchronized (resultMap) {
                resultMap.put(fileName, maxByte);
            }
        }

        private void closeQuietly() {
            if (this.in != null) {
                try {
                    this.in.close();
                } catch (IOException ignore) {
                    /*NOP*/
                }
            }
        }
    }
}
/*public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {

    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) {
            //implement constructor body
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}*/
