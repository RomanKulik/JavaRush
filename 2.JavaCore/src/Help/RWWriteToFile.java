package Help;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class RWWriteToFile {
    public static void main(String[] args) throws FileNotFoundException {
        // https://www.youtube.com/watch?v=nmxeAO7CYVg&list=PLAma_mKffTOSUkXp26rgdnC0PicnmnDak&index=45
        File file = new File("RWWriteToFile.txt");
        // PrintWriter - записывает только текстовые значения.
        // Байты (звук), например, записать не может
        PrintWriter printWriter = new PrintWriter(file);

        // Вывод в консоль
        //System.out.println(System.in);

        printWriter.println("First Line");
        printWriter.println("Second Line");

        printWriter.close();
    }
}
