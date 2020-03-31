package com.imooc.sell.leetcode;

public class Power {
    public static  void  main(String[] args) {
        System.out.println(myPow(2, 5));
    }

    public static double myPow(double x, int n) {
        double ans = 1;
        Long absN = Math.abs((long) n);
        while (absN > 0) {
            if ((absN & 1) == 1) {
                ans *= x;
            }
            absN >>= 1;
            x *= x;
        }
        return n < 0 ? 1 / ans : ans;
    }
}
