package com.javarush.task.task21.task2112;

/*
AutoCloseable и try-with-resources
В классе FakeConnection реализуй интерфейс AutoCloseable,
чтобы объекты этого типа можно было использовать в try-with-resources.

Метод close() должен выводить на экран фразу "Closing database connection..."
В блоке try последовательно вызови методы usefulOperation() и unsupportedOperation().

Вывод на экран должен быть следующим:
Establishing database connection...
Entering body of try block.
Executing useful operation.
Operation is not supported yet!
Closing database connection...

Обрати внимание на то, что ресурсы были освобождены
автоматически несмотря на исключение брошенное методом unsupportedOperation.


Requirements:
1. Класс FakeConnection должен поддерживать интерфейс AutoCloseable.
2. Метод close класса FakeConnection
должен выводить на экран фразу "Closing database connection...".
3. В методе main класса Solution должны быть
вызваны методы usefulOperation и unsupportedOperation у объекта класса FakeConnection.
4. Вывод на экран должен соответствовать условию задачи.
5. Метод close класса FakeConnection не должен быть вызван явно.
*/

public class Solution {
    public static void main(String[] args) {
        DBConnectionManager dbConnectionManager = new DBConnectionManager();
        try (FakeConnection fakeConnection = dbConnectionManager.getFakeConnection()) {
            System.out.println("Entering body of try block.");
            fakeConnection.usefulOperation();
            fakeConnection.unsupportedOperation();
        } catch (Exception e) {
            // UnsupportedOperation!
            // (throw new RuntimeException("UnsupportedOperation!");)
            // System.out.println(e.getMessage());
        }
    }
}

/*
package com.javarush.task.task21.task2112;

AutoCloseable и try-with-resources
В классе FakeConnection реализуй интерфейс AutoCloseable, чтобы объекты этого типа можно было использовать в try-with-resources.
Метод close() должен выводить на экран фразу "Closing database connection..."
В блоке try последовательно вызови методы usefulOperation() и unsupportedOperation().

Вывод на экран должен быть следующим:
Establishing database connection...
Entering body of try block.
Executing useful operation.
Operation is not supported yet!
Closing database connection...

Обрати внимание на то, что ресурсы были освобождены автоматически несмотря на исключение брошенное методом unsupportedOperation.


Requirements:
1. Класс FakeConnection должен поддерживать интерфейс AutoCloseable.
2. Метод close класса FakeConnection должен выводить на экран фразу "Closing database connection...".
3. В методе main класса Solution должны быть вызваны методы usefulOperation и unsupportedOperation у объекта класса FakeConnection.
4. Вывод на экран должен соответствовать условию задачи.
5. Метод close класса FakeConnection не должен быть вызван явно.


public class Solution {
    public static void main(String[] args) {
        DBConnectionManager dbConnectionManager = new DBConnectionManager();
        try (FakeConnection fakeConnection = dbConnectionManager.getFakeConnection()) {
            System.out.println("Entering body of try block.");
        } catch (Exception e) {
        }
    }
}

package com.javarush.task.task21.task2112;

public class DBConnectionManager {
    public FakeConnection getFakeConnection() {
        return new FakeConnection();
    }
}

package com.javarush.task.task21.task2112;

public class FakeConnection {

    public FakeConnection() {
        System.out.println("Establishing database connection...");
    }

    public void unsupportedOperation() {
        System.out.println("Operation is not supported yet!");
        throw new RuntimeException("UnsupportedOperation!");
    }

    public void usefulOperation() {
        System.out.println("Executing useful operation.");
    }
}

*/