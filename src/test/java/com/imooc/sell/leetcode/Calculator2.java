package com.imooc.sell.leetcode;

import java.util.Stack;

public class Calculator2 {



    public static int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();

        int number = 0;
        char sign = '+';

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                number = number * 10 + ch - '0';
            }
            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {
                switch(sign) {
                    case '+' :
                        stack.push(number);
                        break;
                    case '-' :
                        stack.push(-number);
                        break;
                    case '*' :
                        stack.push(stack.pop() * number);
                        break;
                    case '/' :
                        stack.push(stack.pop() / number);
                        break;
                }
                sign = ch;
                number = 0;
            }
        }
        int result = 0;
        for (int num : stack) {
            result += num;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(calculate("1 + 1"));
    }
}
