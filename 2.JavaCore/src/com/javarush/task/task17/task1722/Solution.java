package com.javarush.task.task17.task1722;

/* 
Посчитаем
Посчитаем
1. Сделай так, чтобы результат успел посчитаться
для всех элементов массива values НЕ используя
Thread.sleep в методе main(String[] args)
2. Исправь synchronized блок так, чтобы массив values заполнился значением 1


Требования:
1. Класс Solution должен содержать класс Counter.
2. Класс Counter должен быть нитью.
3. Метод run() класса Counter должен содержать synchronized блок.
4. Synchronized блок метода run() не должен блокировать мьютекс this.
5. Метод main(String[] args) класса Solution не должен использовать Thread.sleep().
6. Для каждой нити, в методе main(String[] args) класса Solution
используй метод, который ожидает завершение нити.

Потому, что работа потоков завязана только на values.
Словами можно представить так:
"(Массив все 0, счетчик 0)
Прибежал первый поток, занял массив(остальные ждут в очереди),
увеличил счетчик и значение из массива[счетчик],
отпустил массив и уснул (итог: массив[0] = 1; счетчик = 1);
Второй поток в очереди тут же занял массив увеличил все что надо,
отпустил и уснул (итог: массив[1] = 1; счетчик = 2);
Третий в очереди - занял, увеличил,
отпустил, уснул (итог: массив[2] = 1; счетчик = 3);
Четвертый - аналогично (итог: массив[3] = 1; счетчик = 4);
Снова дошла очередь до 1го и т.д.
пока не упремся в счетчик == 100.
Основной поток все это время просто ждет пока все эти потоки сделают свои дела."
Имхо суть в том, чтобы научить
всегда блокировать только ключевой для потоков объект.
Т.е. вывод как и в прошлых задачках.
А так одним потоком это же действие выполнится в ~25 раз быстрее, замерил :)
Поправьте если не так ;)
*/
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        Counter counter3 = new Counter();
        Counter counter4 = new Counter();

        counter1.start();
        counter2.start();
        counter3.start();
        counter4.start();

        counter1.join();
        counter2.join();
        counter3.join();
        counter4.join();

        for (int i = 1; i <= 100; i++) {
            if (values[i] != 1) {
                System.out.println("Массив values содержит элементы неравные 1");
                break;
            }
        }
    }

    public static Integer count = 0;
    public static int[] values = new int[105];

    static {
        for (int i = 0; i < 105; i++) {
            values[i] = 0;
        }
    }

    public static void incrementCount() {
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static class Counter extends Thread {
        @Override
        public  void run() {
            do {
                synchronized(values) {
                    incrementCount();
                    values[getCount()]++;
                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                }
            } while (getCount() < 100);
        }
    }
}
/*public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        Counter counter3 = new Counter();
        Counter counter4 = new Counter();

        counter1.start();
        counter2.start();
        counter3.start();
        counter4.start();

        for (int i = 1; i <= 100; i++) {
            if (values[i] != 1) {
                System.out.println("Массив values содержит элементы неравные 1");
                break;
            }
        }
    }

    public static Integer count = 0;
    public static int[] values = new int[105];

    static {
        for (int i = 0; i < 105; i++) {
            values[i] = 0;
        }
    }

    public static void incrementCount() {
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static class Counter extends Thread {
        @Override
        public void run() {
            do {
                synchronized (this) {
                    incrementCount();
                    values[getCount()]++;
                }

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                }
            } while (getCount() < 100);
        }
    }
}*/
