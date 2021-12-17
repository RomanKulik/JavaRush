package com.javarush.task.task21.task2101;                                                  
                                                  
/*                                                   
Определяем адрес сети
Определяем адрес сети
1. Даны IP-адрес и маска подсети,
необходимо вычислить адрес сети - реализуй метод getNetAddress.
Используй операцию поразрядной конъюнкции (логическое И).

Пример:
IP-адрес:      11000000 10101000 00000001 00000010 (192.168.1.2)
Маска подсети: 11111111 11111111 11111110 00000000 (255.255.254.0)
Адрес сети:    11000000 10101000 00000000 00000000 (192.168.0.0)

2. Реализовать метод print, который выведет в консоль данные в двоичном коде.
Для IP-адреса
(192.168.1.2)
должна быть выведена строка
"11000000 10101000 00000001 00000010"

3. Метод main не участвует в тестировании

Требования:
    • Метод getNetAddress должен вычислять и возвращать адрес
    сети согласно переданным параметрам(IP-адрес и маска подсети).
    • Метод getNetAddress должен быть статическим и публичным.
    • Метод print должен быть статическим и публичным.
    • Метод print должен преобразовывать переданный ему
    IP адрес в двоичный код и выводить на экран(как в условии).
*/                                                  
                                                  
public class Solution {                                                  
    public static void main(String[] args) {                                                  
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};                                                  
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};                                                  
        byte[] netAddress = getNetAddress(ip, mask);                                                  
        print(ip);          //11000000 10101000 00000001 00000010                                                  
        print(mask);        //11111111 11111111 11111110 00000000                                                  
        print(netAddress);  //11000000 10101000 00000000 00000000                                                  
    }                                                  
                                                  
    public static byte[] getNetAddress(byte[] ip, byte[] mask) {                                                  
         byte[] b = new byte[4];
        for (int i = 0; i < ip.length; i++) {
           b[i] = (byte)(ip[i] & mask[i]);
        }
        return b;                                                 
    }                                                  
                                                  
    public static void print(byte[] bytes) {
        String currentBinary;
        for (byte aByte : bytes) {
            currentBinary = Integer.toBinaryString(256 + (int) aByte);
            System.out.print(currentBinary.substring(currentBinary.length() - 8) + " ");
        }
        System.out.println();

      /*  String result = "";
        for (int i = 0, num; i < bytes.length; i++) {
            num = Byte.toUnsignedInt(bytes[i]);
            result += String.format("%8s", Integer.toBinaryString(num).replace(' ', '0'));
            result += ' ';
        }
        System.out.println(result.trim());*/

        // System.out.println(String.format("%8s", Integer.toBinaryString(1)).replace(' ', '0')); //00000001

          /*for (int i = 0; i < bytes.length; i++) {
            System.out.print(Integer.toBinaryString(bytes[i]));
            //1111111111111111111111111100000011111111111111111111111110101000110
        }
        for (int i = 0; i < bytes.length; i++) {
            System.out.print(Byte.toString(bytes[i])); // -64-8812
        }
        for (int i = 0, num; i < bytes.length; i++) {
            //System.out.println(Byte.toUnsignedInt(bytes[i])); // 19216812
        }
        */
    }
}

/*
package com.javarush.task.task21.task2101;

/*
Определяем адрес сети
1. Даны IP-адрес и маска подсети, необходимо вычислить адрес сети - реализуй метод getNetAddress.
Используй операцию поразрядной конъюнкции (логическое И).

Пример:
IP-адрес: 11000000 10101000 00000001 00000010 (192.168.1.2)
Маска подсети: 11111111 11111111 11111110 00000000 (255.255.254.0)
Адрес сети: 11000000 10101000 00000000 00000000 (192.168.0.0)

2. Реализовать метод print, который выведет в консоль данные в двоичном коде.
Для IP-адреса(192.168.1.2)
должна быть выведена строка "11000000 10101000 00000001 00000010"
3. Метод main не участвует в тестировании
Требования:
    • Метод getNetAddress должен вычислять и возвращать адрес
    сети согласно переданным параметрам(IP-адрес и маска подсети).
    • Метод getNetAddress должен быть статическим и публичным.
    • Метод print должен быть статическим и публичным.
    • Метод print должен преобразовывать переданный ему
    IP адрес в двоичный код и выводить на экран(как в условии).


public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        return new byte[4];
    }

    public static void print(byte[] bytes) {
    }
}
 */