package com.javarush.task.task19.task1926;

import java.util.Stack;

/**
 * ReverseString_7_Ways:StringBuffer.reverse,forr.str.toCharArray(),forrStringBuilder,recursiveReverse,reverseByStack,reverseWithXOR,reverseWithVar
 * @author Sergey Lugovoy <svlugovoy@gmail.com> 05.02.2016.
 * @author Практика применения XOR в программировании https://habr.com/post/183462/
 * XOR or '^'   https://stackoverflow.com/questions/1991380/what-does-the-operator-do-in-java
 */
public class ReverseString_7_Ways {
    public static void main(String[] args) {
        String str = "I love Java";
        // 1
        StringBuffer sbf = new StringBuffer(str);
        System.out.println("1) " + sbf.reverse());
        // 2
        char[] array = str.toCharArray();
        System.out.print("2) ");
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i]);
        }
        System.out.println();
        // 3
        System.out.println("3) " + recursiveReverse(str));
        // 4
        StringBuilder newStr = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            newStr.append(str.charAt(i));
        }
        System.out.println("4) " + newStr);
        // 5
        System.out.println("5) " + reverseByStack(str));
        // 6
        System.out.println("6) " + reverseWithXOR(str));
        // 7
        System.out.println("7) " + reverseWithVar(str));

    }

    static String recursiveReverse(String s) {
        if ((null == s) || (s.length() <= 1)) {
            return s;
        }
        return recursiveReverse(s.substring(1)) + s.charAt(0);
    }

    public static String reverseByStack(String s) {
        Stack<Character> st = new Stack<Character>();
        for (Character character : s.toCharArray()) {
            st.add(character);
        }
        StringBuilder sb = new StringBuilder();
        while (st.size() > 0) {
            sb.append(st.pop());
        }
        return sb.toString();
    }

    public static final String reverseWithXOR(String string) {
        char[] array = string.toCharArray();
        int length = array.length;
        int half = (int) Math.floor(array.length / 2);
        for (int i = 0; i < half; i++) {
            array[i] ^= array[length - i - 1];
            array[length - i - 1] ^= array[i];
            array[i] ^= array[length - i - 1];
        }
        return String.valueOf(array);
    }

    public static final String reverseWithVar(String string) {
        char[] array = string.toCharArray();
        int length = array.length;
        int half = (int) Math.floor(array.length / 2);
        for (int i = 0; i < half; i++) {
            char temp = array[i];
            array[i] = array[length - i - 1];
            array[length - i - 1] = temp;
        }
        return String.valueOf(array);
    }
}
