package com.imooc.sell.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderLogFiles {

    public static void main(String[] args) {
        String[] test = "a b b".split(" ", 2);
    }

    public static String[] reorderLogFiles(String[] logs) {

        Comparator<String> myComparator = new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                //先把标识符和正文分开
                String[] split1 = str1.split(" ", 2);
                String[] split2 = str2.split(" ", 2);
                //判断是 字符log 还是 数字 log
                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
                //都不是数字, 即都是字符型就直接lexicographically比, 相同在比 identifer
                if (!isDigit1 && !isDigit2) {
                    int difference = split1[1].compareTo(split2[1]);
                    if (difference != 0)
                        return difference;
                    return split1[0].compareTo(split2[0]);
                }
                return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
            }
        };

        Arrays.sort(logs, myComparator);
        return logs;
    }
}
