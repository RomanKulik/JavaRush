package com.javarush.task.task19.task1926;

import java.util.Stack;

/**
 * @author Sergey Lugovoy <svlugovoy@gmail.com> 05.02.2016.
 */
public class ReverseString_5Ways {
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
}
