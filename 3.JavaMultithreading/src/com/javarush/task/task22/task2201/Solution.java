package com.javarush.task.task22.task2201;

/* 
Строки нитей или строковые нити? Вот в чем вопрос
Строки нитей или строковые нити? Вот в чем вопрос
1. Метод getPartOfString должен возвращать
подстроку между первой и последней табуляцией.
2. На некорректные данные getPartOfString
должен бросить исключение:
а) StringForFirstThreadTooShortException,
если имя трэда FIRST_THREAD_NAME.
б) StringForSecondThreadTooShortException,
если имя трэда SECOND_THREAD_NAME.
в) RuntimeException в других случаях.
3. Реализуй логику трех protected методов
в OurUncaughtExceptionHandler используя вызовы соответствующих
методов согласно следующим шаблонам:
a) 1# : StringForFirstThreadTooShortException :
java.lang.StringIndexOutOfBoundsException: String index out of range: -1
б) java.lang.StringIndexOutOfBoundsException:
String index out of range: -1 : StringForSecondThreadTooShortException : 2#
в) RuntimeException : java.lang.StringIndexOutOfBoundsException:
 String index out of range: -1 : 3#


Requirements:
1. Метод getPartOfString() должен возвращать подстроку
между первой и последней табуляцией строки string
 ему в качестве первого параметра.
2. В случае некорректных данных метод getPartOfString()
 должен бросить исключение StringForFirstThreadTooShortException,
 если имя трэда(threadName) Solution.FIRST_THREAD_NAME.
3. В случае некорректных данных метод getPartOfString()
должен бросить исключение StringForSecondThreadTooShortException,
если имя трэда(threadName) Solution.SECOND_THREAD_NAME.
4. В случае некорректных данных метод getPartOfString()
должен бросить исключение RuntimeException, если имя трэда(threadName)
не Solution.FIRST_THREAD_NAME или Solution.SECOND_THREAD_NAME.
5. Метод getFormattedStringForFirstThread()
должен возвращать строку сформированную из переданных параметров
 по шаблону указанному в задании.
6. Метод getFormattedStringForSecondThread()
должен возвращать строку сформированную из переданных параметров
по шаблону указанному в задании.
7. Метод getFormattedStringForOtherThread() должен возвращать строку
сформированную из переданных параметров по шаблону указанному в задании.

https://java-course.ru/articles/exceptions/ - Исключения – советы по использованию
*/

public class Solution {
    public static void main(String[] args) {
        new Solution();
    }

    public static final String FIRST_THREAD_NAME = "1#";
    public static final String SECOND_THREAD_NAME = "2#";

    private Thread thread1;
    private Thread thread2;
    private Thread thread3;

    public Solution() {
        initThreads();
    }

    protected void initThreads() {
        this.thread1 = new Thread(new Task(this,
                        "A\tB\tC\tD\tE\tF\tG\tH\tI"), FIRST_THREAD_NAME);
        this.thread2 = new Thread(
                new Task(this,
                        "J\tK\tL\tM\tN\tO\tP\tQ\tR\tS\tT\tU\tV\tW\tX\tY\tZ"), SECOND_THREAD_NAME);
        this.thread3 = new Thread(
                new Task(this,
                        "\t\t"), "3#");

        Thread.setDefaultUncaughtExceptionHandler(new OurUncaughtExceptionHandler());

        this.thread1.start();
        this.thread2.start();
        this.thread3.start();
    }

    public static synchronized String getPartOfString(String string, String threadName) {
        String result = null;
        try {
            if (threadName.equals(FIRST_THREAD_NAME))
                throw new StringForFirstThreadTooShortException();
            if (threadName.equals(SECOND_THREAD_NAME))
                throw new StringForSecondThreadTooShortException();

            if (string != null) {
                int firstTab = string.indexOf("\t");
                int lastTab = string.lastIndexOf("\t");
                result = string.substring(firstTab + 1, lastTab);
            }
        } catch (Exception o) {
            throw new RuntimeException();
        }

        return result;
    }
}


//package com.javarush.task.task22.task2201;

/*
Строки нитей или строковые нити? Вот в чем вопрос
Строки нитей или строковые нити? Вот в чем вопрос
1. Метод getPartOfString должен возвращать
подстроку между первой и последней табуляцией.
2. На некорректные данные getPartOfString
должен бросить исключение:
а) StringForFirstThreadTooShortException,
если имя трэда FIRST_THREAD_NAME.
б) StringForSecondThreadTooShortException,
если имя трэда SECOND_THREAD_NAME.
в) RuntimeException в других случаях.
3. Реализуй логику трех protected методов
в OurUncaughtExceptionHandler используя вызовы соответствующих
методов согласно следующим шаблонам:
a) 1# : StringForFirstThreadTooShortException :
java.lang.StringIndexOutOfBoundsException: String index out of range: -1
б) java.lang.StringIndexOutOfBoundsException:
String index out of range: -1 : StringForSecondThreadTooShortException : 2#
в) RuntimeException : java.lang.StringIndexOutOfBoundsException:
 String index out of range: -1 : 3#


Requirements:
1. Метод getPartOfString() должен возвращать подстроку
между первой и последней табуляцией строки string
 ему в качестве первого параметра.
2. В случае некорректных данных метод getPartOfString()
 должен бросить исключение StringForFirstThreadTooShortException,
 если имя трэда(threadName) Solution.FIRST_THREAD_NAME.
3. В случае некорректных данных метод getPartOfString()
должен бросить исключение StringForSecondThreadTooShortException,
если имя трэда(threadName) Solution.SECOND_THREAD_NAME.
4. В случае некорректных данных метод getPartOfString()
должен бросить исключение RuntimeException, если имя трэда(threadName)
не Solution.FIRST_THREAD_NAME или Solution.SECOND_THREAD_NAME.
5. Метод getFormattedStringForFirstThread()
должен возвращать строку сформированную из переданных параметров
 по шаблону указанному в задании.
6. Метод getFormattedStringForSecondThread()
должен возвращать строку сформированную из переданных параметров
по шаблону указанному в задании.
7. Метод getFormattedStringForOtherThread() должен возвращать строку
сформированную из переданных параметров по шаблону указанному в задании.


public class Solution {
    public static void main(String[] args) {
        new Solution();
    }

    public static final String FIRST_THREAD_NAME = "1#";
    public static final String SECOND_THREAD_NAME = "2#";

    private Thread thread1;
    private Thread thread2;
    private Thread thread3;

    public Solution() {
        initThreads();
    }

    protected void initThreads() {
        this.thread1 = new Thread(new Task(this, "A\tB\tC\tD\tE\tF\tG\tH\tI"), FIRST_THREAD_NAME);
        this.thread2 = new Thread(new Task(this, "J\tK\tL\tM\tN\tO\tP\tQ\tR\tS\tT\tU\tV\tW\tX\tY\tZ"), SECOND_THREAD_NAME);
        this.thread3 = new Thread(new Task(this, "\t\t"), "3#");

        Thread.setDefaultUncaughtExceptionHandler(new OurUncaughtExceptionHandler());

        this.thread1.start();
        this.thread2.start();
        this.thread3.start();
    }

    public synchronized String getPartOfString(String string, String threadName) {
        return null;
    }
}
*/