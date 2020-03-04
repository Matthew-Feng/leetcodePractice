package com.matthew.feng.other.feb20;

import java.util.LinkedList;

public class PreFixToPostFix {


    private static boolean isOperator(char c) {
        if (c == '+') {
            return true;
        }
        if (c == '-') {
            return true;
        }
        if (c == '*') {
            return true;
        }
        return c == '/';
    }

    public static String prefixToPostFix(String s) {
        LinkedList<String> stack = new LinkedList<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (isOperator(c)) {
                String left = stack.pop();
                String righ = stack.pop();
                stack.push(left + righ + c);
            } else {
                stack.push("" + c);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(prefixToPostFix("++A*BCD"));
    }
}
