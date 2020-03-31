package com.imooc.sell.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Sum3 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) return ans;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;			//这就处理了这种 corner case [0, 0, 0, 0]
            int left = i + 1, right = nums.length - 1, target = 0 - nums[i];
            while (left < right) {

                if (nums[left] + nums[right] == target) {
                    ans.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[left], nums[right])));        			//这里面也可能会有重复 比如 [0, 0, 0, 0, 0] 第一次 l,r match 了 后面l or r 必须得有一个不一样 否则会重复
                    // [0, 1, 1, -1, -1]这种一样的 corner case 所以左右都要走到和之前不一样的数字
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    //正常的match都该向里面缩 这是必须的 上面的两个while是去重
                    left++;
                    right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return ans;
    }
}



// [-1, 0, 1, 2, -1, -4]   target = 0

// no duplicates;
// [
//     [-1, 0, 1],
//     [-1, -1, 2]
// ]

// first, => Arrays.sort();    [-4, -1, -1, 0, 1, 2]

// choose one element as the new target,
// which means that a = b + c, and just iterate a  and bc

// //find a
// for (0 -> nums.length - 2) third last ele
// if (i > 0 && nums[i] == nums[i - 1]) continue;

// int l = i + 1, r = nums.length - 1;
// //find apporiate b and c
// while (l < r) {
//     if ( == ) {
//         ans.add();
//         l++;
//         r--;
//         while( nums[l] == nums[l - 1]) l++;
//         while (nums[r] == nums[r + 1]) r--;
//     } else if ( < ) {
//         l++;
//     } else {
//         r--;
//     }
// }

// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         List<List<Integer>> ans = new ArrayList<>();
//         Arrays.sort(nums);
//         for (int i = 0; i < nums.length - 2; i++) {
//             if (i > 0 && nums[i] == nums[i - 1])
//                 continue;
//             int target = -nums[i];
//             int left = i + 1, right = nums.length - 1;

//             while (left < right) {
//                 if (nums[left] + nums[right] == target) {
//                     ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
//                     left++;
//                     right--;
//                     while (left < right && nums[left] == nums[left - 1]) left++;
//                     while (left < right && nums[right] == nums[right + 1]) right--;
//                 }
//                 if (nums[left] + nums[right] < target)
//                     left++;
//                 if (nums[left] + nums[right] > target)
//                     right--;
//             }
//         }
//         return ans;
//     }
// }



















