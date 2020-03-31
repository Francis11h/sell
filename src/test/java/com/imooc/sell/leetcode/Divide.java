package com.imooc.sell.leetcode;

public class Divide {

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, 1));
    }

    public static int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return dividend >= 0? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isNegative = (dividend < 0 && divisor > 0) ||
                (dividend > 0 && divisor < 0);

        int a = dividend < 0 ? dividend : - dividend;
        int b = divisor < 0 ? divisor : - divisor;


        int result = 0;
        while (a <= b) {
            int shift = 0;
            // 如果 a = -2147483648 的时候 就永远 是最小的 因为它是 int的最小值 这就越界了
            // 所以
            int c = 0;
            while (a < (b << shift)  && (b << shift) < 0 && shift < 31) {
                c = b << shift;
                shift++;
            }
            a -= b << (shift - 1);
            result -= 1 << (shift - 1);
        }
        return isNegative? result: -result;
    }
}
