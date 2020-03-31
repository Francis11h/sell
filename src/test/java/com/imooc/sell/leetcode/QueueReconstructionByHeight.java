package com.imooc.sell.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionByHeight {
    public static void main(String[] args) {
        int[][] people = new int[][] {
                {7, 0},{4,4},{7,1},{5,0},{6,1},{5,2}
        };
        reconstructQueue(people);
    }
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o2[0] - o1[0];
                }
            }
        }));
        List<int[]> resultList = new LinkedList<>();
        for(int[] cur : people){
            resultList.add(cur[1], cur);
        }
        return resultList.toArray(new int[people.length][]);
    }
}
