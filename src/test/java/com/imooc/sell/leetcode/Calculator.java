package com.imooc.sell.leetcode;

import java.util.Stack;

public class Calculator {
    public static void main (String[] args) {
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
    }

    public static int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int number = 0, sign = 1, result = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                number = 0;     //这句话可以不加 为什么？
                sign = 1;
            } else if (ch == ')') {
                int prevSign = stack.pop();
                int prevResult = stack.pop();
                result += number * sign;
                result = prevResult + result * prevSign;
                number = 0;
            } else if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            } else if (ch == '+') {
                result += number * sign;
                number = 0;
                sign = 1;
            } else if (ch == '-') {
                result += number * sign;
                number = 0;
                sign = -1;
            }
        }
        return number != 0 ? result += number * sign : result;
    }
}
