package com.imooc.sell.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] array = new int[] {1, 1, 1, 2, 2};
        int target = 4;

        combinationSum2(array, target);
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        dfs(0, target, candidates, new ArrayList<>(), res);
        return res;
    }

    //level 的意义 是取candidates数组中的下标为level的数
    public static void dfs(int level, int target, int[] candidates, List<Integer> cur, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = level; i < candidates.length; i++) {
            if (i > level && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] > target) return;
            cur.add(candidates[i]);
            //因为不能重复使用 所以这里 i 加 1 表示选下一个数字
            dfs(i + 1, target - candidates[i], candidates, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}
