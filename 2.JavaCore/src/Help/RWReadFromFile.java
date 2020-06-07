package Help;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class RWReadFromFile {
    public static void main(String[] args) throws FileNotFoundException {
        // https://www.youtube.com/watch?v=j3I-jLGW8yU&list=PLAma_mKffTOSUkXp26rgdnC0PicnmnDak&index=37

        // Статическая константа-сепаратор файловой системы, который подставится в зависимости от ОС
        String path0 = "d:\\User\\Рабочий стол\\RWReadFromFileTest.txt"; // с привязкой к Windows

        // без привязки к ОС
        String separator = File.separator;
        String path = separator + "d:" + separator + "User" + separator + "Рабочий стол" + separator + "RWReadFromFileTest.txt";

        // абстракция, которая позволяет работать с реальным файлом
        File file = new File(path);

        // Если файл в корневом каталоге (JavaRushTasks) проекта
        File file2 = new File("RWReadFromFileTest");
        Scanner scannerFile2 = new Scanner(file2);
        System.out.println(scannerFile2.nextLine());
        scannerFile2.close();

        // Классу Scanner нет разницы с работать с входным потоком или файлом.
        // Ему важно, чтобы был поток данных
        // in - константа, которая содержит в себе информацию,
        // которую передали в консоль (стандартный поток ввода)
        Scanner scanner1 = new Scanner(System.in);
        // add FileNotFoundException
        Scanner scanner2 = new Scanner(file);
        // Считать строки из файла, пока есть следующая строка (Line one endl Line Two endl...)
        while (scanner2.hasNextLine()) {
            // Вывести строку в консоль
            System.out.println(scanner2.nextLine());
        }

        // Закрыть Scanner и освободить ресурсы
        scanner1.close();
        scanner2.close();


        // Считать строку из файла ("1 2 3") 3 числа и поместить их в переменные int
        Scanner scanner = new Scanner(file);
        String line = scanner.nextLine(); // получить строку из файла
        String[] strings = line.split(" ");  // каждое число в отдельности.
        System.out.println(Arrays.toString(strings)); // вывести массив

        int[] numbers = new int[3];
        int counter = 0;
        for (String number : strings) {
            numbers[counter++] = Integer.parseInt(number);
        }

        // Т.к. массив - объект и у него не переопределн метод ToString,
        System.out.println(numbers); // такой вывод даст адрес ячейки памяти
        System.out.println(Arrays.toString(numbers));

        scanner.close();

    }
}
