package com.imooc.sell.leetcode;

public class PermutationSequence {
    public static  void main(String[] args) {
        System.out.println(getPermutation(1, 1));
    }
    public static String getPermutation(int n, int k) {

        boolean[] visited = new boolean[n];

        int factorial = 1;
        int x = 1;
        while (x <= n) {
            factorial *= x;
            x++;
        }

        k %= factorial;

        StringBuilder ans = new StringBuilder();

        while (n > 0) {
            factorial /= n;
            int now = k / factorial;
            if (k % factorial == 0) now--;
            int count = 0;
            int digit = 0;
            for (int i = 0; i < x - 1; i++) {
                if (!visited[i]) count++;
                if (count == now + 1) {
                    visited[i] = true;
                    digit = i + 1;
                    break;
                }
            }
            ans.append(digit);
            k -= now * factorial;
            n--;
        }

        return ans.toString();
    }
}
