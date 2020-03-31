package com.imooc.sell.leetcode;

public class RotateArray {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3 ,4 ,5, 6};
        rotate(A, 2);
    }
    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int cur = start;
            int prev = nums[start];
            int next = (cur + k) % nums.length;
            int temp = nums[next];
            nums[next] = prev;
            prev = temp;
            cur = next;
            count++;
            while (cur != start) {
                next = (cur + k) % nums.length;     //next position
                temp = nums[next];
                nums[next] = prev;
                prev = temp;
                cur = next;
                count++;
            }
        }
    }
}