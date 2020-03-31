package com.imooc.sell.leetcode;

/**
 *      s = "aab"
 *      p = "c*a*b"
 */

public class RegularExpressionMatching {

    public static void main(String[] args) {
        String s = "aab", p = "a*aab";
        if (isMatch(s, p)) {
            System.out.println("isMatch !!");
        } else {
            System.out.println("not match ....");
        }
    }
    /**
     *
     * @param s inputString
     * @param p pattern
     * @return isMatch
     *
     */
    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) return true;

        if (s.length() == 0) {
            return isEmpty(p);
        }

        if (p.length() == 0) {
            return false;
        }

        char s1 = s.charAt(0);
        char p1 = p.charAt(0);
        char p2 = '0';
        if (p.length() > 1) {
            p2 = p.charAt(1);
        }
        if (p2 == '*') {
            if (isCompared(s1, p1)) {
                return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
            } else {
                return isMatch(s, p.substring(2));
            }
        } else {
            if (isCompared(s1, p1)) {
                return isMatch(s.substring(1), p.substring(1));
            } else {
                return false;
            }
        }
    }

    private static boolean isCompared(char ch1, char ch2) {
        return ch1 == ch2 || ch2 == '.';
    }

    private static boolean isEmpty(String p) {
        if ((p.length() & 1) == 1) return false;
        for (int i = 1; i < p.length(); i += 2) {
            if (p.charAt(i) != '*')
                return false;
        }
        return true;
    }
}
