package com.javarush.task.task14.task1410;

/* 
Дегустация вин
У 30% роботического населения планеты Сото наблюдается одна зависимость,
которая вызывает опасения у остальных 70% роботического населения планеты Сото: алкоголь.
Точнее, программирование алкоголя, речь о роботах всё-таки.
Наконец-то вы сможете это сделать!

Дегустация вин
1. Создать абстрактный класс Drink с реализованным методом public void taste(),
который выводит в консоль "Вкусно".
2. Создать класс Wine, который наследуется от Drink,
с реализованным методом public String getHolidayName(),
который возвращает строку "День Рождения".
3. Создать класс BubblyWine, который наследуется от Wine,
с реализованным методом public String getHolidayName(),
который возвращает строку "Новый Год".
4. Написать реализацию методов getDeliciousDrink, getWine, getBubblyWine.
5. Все классы должны находиться в отдельных файлах.


Требования:
1. Абстрактный класс Drink должен быть создан в отдельном файле.
2. В классе Drink должен быть реализован метод public void taste(),
который выводит на экран строку - "Вкусно".
3. Класс Wine должен быть создан в отдельном файле и быть потомком класса Drink.
4. В классе Wine должен быть реализован метод public String getHolidayName(),
который возвращает строку - "День Рождения".
5. Класс BubblyWine должен быть создан в отдельном файле и быть потомком класса Wine.
6. В классе BubblyWine должен быть реализован метод public String getHolidayName(),
который возвращает строку - "Новый Год".
7. В классе Solution должен быть реализован метод getDeliciousDrink(),
который возвращает объект типа Wine.
8. В классе Solution должен быть реализован метод getWine(),
который возвращает объект типа Wine.
9. В классе Solution должен быть реализован метод getBubblyWine(),
который возвращает объект типа BubblyWine.
*/


public class Solution {
    public static void main(String[] args) {
        getDeliciousDrink().taste();
        System.out.println(getWine().getHolidayName());
        System.out.println(getBubblyWine().getHolidayName());
    }

    public static Drink getDeliciousDrink() {
        return new Wine();
    }

    public static Wine getWine() {
        return new Wine();
    }

    public static Wine getBubblyWine() {
        return new BubblyWine();
    }
}
