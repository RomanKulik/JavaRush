package com.javarush.task.task14.task1406;

/* 
Без ошибок
И снова что-то не так в этой задаче.
Так что вам предстоит кое-что исправить,
а именно — инициализировать объект obj таким классом, чтобы метод main выполнился без ошибок.

Без ошибок
Инициализировать объект obj таким классом, чтобы метод main выполнился без ошибок.


Требования:
1. Класс GreyMouse должен наследоваться от класса Mouse.
2. Класс Jerry должен наследоваться от класса GreyMouse.
3. В переменной obj должен храниться объект который будет
одновременно являться и Mouse, и GreyMouse, и Jerry.
4. Метод main должен вызывать метод printClasses.
*/
public class Solution {
    public static void main(String[] args) {
        Object obj = new Jerry();//Add your code here

        Mouse mouse = (Mouse) obj;
        GreyMouse greyMouse = (GreyMouse) mouse;
        Jerry jerry = (Jerry) greyMouse;

        printClasses(obj, mouse, greyMouse, jerry);

    }

    public static void printClasses(Object obj, Mouse mouse, GreyMouse greyMouse, Jerry jerry) {
        System.out.println(jerry.getClass().getSimpleName());
        System.out.println(greyMouse.getClass().getSimpleName());
        System.out.println(mouse.getClass().getSimpleName());
        System.out.println(obj.getClass().getSimpleName());
    }

    static class Mouse {
    }

    static class GreyMouse extends Mouse {
    }

    static class Jerry extends GreyMouse {
    }
}
/*public class Solution {
    public static void main(String[] args) {
        Object obj = //Add your code here

                Mouse mouse = (Mouse) obj;
        GreyMouse greyMouse = (GreyMouse) mouse;
        Jerry jerry = (Jerry) greyMouse;

        printClasses(obj, mouse, greyMouse, jerry);

    }

    public static void printClasses(Object obj, Mouse mouse, GreyMouse greyMouse, Jerry jerry) {
        System.out.println(jerry.getClass().getSimpleName());
        System.out.println(greyMouse.getClass().getSimpleName());
        System.out.println(mouse.getClass().getSimpleName());
        System.out.println(obj.getClass().getSimpleName());
    }

    static class Mouse {
    }

    static class GreyMouse extends Mouse {
    }

    static class Jerry extends GreyMouse {
    }
}*/
