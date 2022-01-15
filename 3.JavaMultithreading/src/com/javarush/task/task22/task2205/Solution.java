package com.javarush.task.task22.task2205;

/* 
МНЕ нравится курс JavaRush
МНЕ нравится курс JavaRush: String.format, перемена параметров, width - left padding -width - right padding
    String.format return "%3$S%4$s %2$s %1$s"
    %[argument_index$][flags][width][.precision]conversion
    width - left padding
    -width - right padding


Исправить метод getFormattedString так,
чтобы он возвращал строку с параметрами для форматирования.
Параметры должны меняться местами.

Должен быть вывод:
МНЕ нравится курс JavaRush


Requirements:
1. Метод getFormattedString должен быть публичным.
2. Метод getFormattedString должен быть статическим.
3. Вывод на экран должен соответствовать условию задачи.
4. Метод getFormattedString должен возвращать
строку с параметрами для форматирования согласно условию задачи.
*/

public class Solution {
    public static void main(String[] args) {
        //должен быть вывод
        //"МНЕ нравится курс JavaRush"
        //System.out.println(String.format(getFormattedString(),
        // "JavaRush", "курс", "мне", "нравится"));

        // %[argument_index$][flags][width][.precision]conversion
        // The optional width is a non-negative decimal integer
        // indicating the minimum number of characters to be written to the output.
        // The width is the minimum number of characters to be written to the output.
        // If the length of the converted value is less than the width then
        // the output will be padded by '  ' ('\u0020') until the total number of characters
        // equals the width. The padding is on the left by default.
        // If the '-' flag is given, then the padding will be on the right.
        // If the width is not specified then there is no minimum.
        // https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html
        System.out.println(String.format("%3$S%4$s %2$s%1$s", "JavaRush", "00курс", "00мне", "нравится"));
        System.out.println(String.format("%3$S%4$s %2$s%1$s", "JavaRush", "00курс", "00мне", "нравится"));
        System.out.println(String.format("%3$S%4$1s %2$-1s%1$s", "JavaRush", "-01курс", "01мне", "нравится"));
        System.out.println(String.format("%3$S%4$2s %2$-2s%1$s", "JavaRush", "-02курс", "02мне", "нравится"));
        System.out.println(String.format("%3$S%4$3s %2$-3s%1$s", "JavaRush", "-03курс", "03мне", "нравится"));
        System.out.println(String.format("%3$S%4$4s %2$-4s%1$s", "JavaRush", "-04курс", "04мне", "нравится"));
        System.out.println(String.format("%3$S%4$5s %2$-5s%1$s", "JavaRush", "-05курс", "05мне", "нравится"));
        System.out.println(String.format("%3$S%4$6s %2$-6s%1$s", "JavaRush", "-06курс", "06мне", "нравится"));
        System.out.println(String.format("%3$S%4$7s %2$-7s%1$s", "JavaRush", "-07курс", "07мне", "нравится"));
        System.out.println(String.format("%3$S%4$8s %2$-8s%1$s", "JavaRush", "-08курс", "08мне", "нравится"));
        System.out.println(String.format("%3$S%4$9s %2$-9s%1$s", "JavaRush", "-09курс", "09мне", "нравится"));
        System.out.println(String.format("%3$S%4$10s %2$-10s%1$s", "JavaRush", "-10курс", "10мне", "нравится"));
        System.out.println(String.format("%3$S%4$15s %2$-15s%1$s", "JavaRush", "-15курс", "15мне", "нравится"));
        System.out.println(String.format("%3$S%4$20s %2$-20s%1$s", "JavaRush", "-20курс", "20мне", "нравится"));

        /*
            00МНЕнравится 00курсJavaRush
            01МНЕнравится -01курсJavaRush
            02МНЕнравится -02курсJavaRush
            03МНЕнравится -03курсJavaRush
            04МНЕнравится -04курсJavaRush
            05МНЕнравится -05курсJavaRush
            06МНЕнравится -06курсJavaRush
            07МНЕнравится -07курсJavaRush
            08МНЕнравится -08курс JavaRush
            09МНЕ нравится -09курс  JavaRush
            10МНЕ  нравится -10курс   JavaRush
            15МНЕ       нравится -15курс        JavaRush
            20МНЕ            нравится -20курс             JavaRush
         */

        System.out.printf("String     |%d| %n", 123);
        System.out.printf("String -10 |%-10s| \n", 123);
        System.out.printf("String  10 |%10s| %n", 123);
        System.out.printf("String   5 |%5s| \n", 123);
        System.out.printf("String  -5 |%-5s| %n", 123);
        System.out.printf("String  10 |%10d| \n", 5);
        System.out.printf("String  10 |%10d| %n", 100000);
        System.out.printf("String -10 |%-10d| \n", 100000);
        System.out.printf("String  10 |%10d| %n", 1234567890123L);
        System.out.printf("String   5 |%5d| \n", 1234567890123L);
        System.out.printf("String     |%s| \n", "abc");
        System.out.printf("String -10 |%-10s| %n", "abc");
        System.out.printf("String  10 |%10s| \n", "abc");
        System.out.printf("String   5 |%5s| \n", "abc");
        System.out.printf("String  -5 |%-5s| %n", "abc");
        System.out.printf("String   5 |%5s| \n", "abcefghijklmnop");
        /*  String     |123|
            String -10 |123       |
            String  10 |       123|
            String   5 |  123|
            String  -5 |123  |
            String  10 |         5|
            String  10 |    100000|
            String -10 |100000    |
            String  10 |1234567890123|
            String   5 |1234567890123|
            String     |abc|
            String -10 |abc       |
            String  10 |       abc|
            String   5 |  abc|
            String  -5 |abc  |
            String   5 |abcefghijklmnop|*/
    }

    public static String getFormattedString() {
        // МНЕ нравится курс JavaRush
        //"%3$2S %4$2s %2$2s %1$2s"
        return "%3$S%4$s %2$s %1$s";
    }
}
