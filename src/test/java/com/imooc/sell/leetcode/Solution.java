package com.imooc.sell.leetcode;
import java.util.*;

class Solution {

    public static void main(String[] args) {
        List<String> wordList = new ArrayList<String>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        findLadders("hit", "cog", wordList);
    }

    //图
    static Map<String, List<String>> graph = new HashMap<>();
    static List<List<String>> ans = new ArrayList<>();
    //至少需要多少步，其下限
    static Map<String, Integer> lb = new HashMap<>();

    // limit 层数限制是多少, x:即将做第几次变换，word ：当前即将要做变换的词
    private static void dfs(int limit, int x, String word, String end, List<String> path) {
        //退出条件
        if (x == limit + 1) { //+1是因为 x是我即将要做的那一次变换，即前面limit次变换已经做完
            if (word.equals(end)) {

                ans.add(new ArrayList<>(path));
            }
            return;
        }

        //前面已经做了x-1步
        //再加上剩余的至少步数，还大于limit 直接剪枝
        if (x - 1 + lb.get(word) > limit) {
            return;
        }

        for (String next : graph.get(word)) {
            path.add(next);
            dfs(limit, x + 1, next, end, path);
            path.remove(path.size() - 1);
        }

        //让 lb动态更新。走到这里时，从word出发的所有的路已经试完了且还没找到结果的话
        // ans 是空 表示 从word出发还没没到达终点, word 已经走了 limit-(x-1) 步

        if (ans.isEmpty()) {
            // 已经走了limit-(x-1) 步 还没到终点，那么至少要走limit - (x - 1) + 1步
            //动态更新lb，下界不断提高！
            lb.put(word, Math.max(lb.get(word), limit - (x - 1) + 1));
        }

    }

    //找与每个word 连接的 且在字典中的所有边
    private static List<String> getNext(String word, Set<String> dict) {
        List<String> res = new ArrayList<>();

        //改变单词每一位的个数
        for (int i = 0; i < word.length(); i++) {
            char[] sc = word.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                sc[i] = c;
                String next = String.valueOf(sc);
                if (dict.contains(next) && !word.equals(next)) {
                    res.add(next);
                }
            }
        }
        return res;
    }

    private static int getDiff(String a, String b) {
        int ret = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                ret++;
            }
        }
        return ret;
    }

    public static List<List<String>> findLadders(String start, String end, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        //建图的过程
        dict.add(start);
        dict.add(end);
        for (String word : dict) {
            graph.put(word, getNext(word, dict));
            lb.put(word, getDiff(word, end));
        }

        //加深，深度
        int limit = 0;

        List<String> path = new ArrayList<>();
        path.add(start);


        while (ans.isEmpty()) {
            dfs(limit, 1, start, end, path); //即将做第一次变换
            limit++;
        }
        return ans;
    }

//    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        Set<String> wordList_set = new HashSet<>(wordList);
//        List<List<String>> res = new ArrayList<>();
//        Map<String, ArrayList<String>> next_word_map = new HashMap<>();
//        Map<String, Integer> distance = new HashMap<>();
//
//        bfs(beginWord, endWord, next_word_map, distance, wordList_set);
//        dfs(beginWord, endWord, next_word_map, 0, res, new ArrayList<String>(Arrays.asList(beginWord)), distance);
//        return res;
//    }
//
//    private static void dfs(String beginWord, String endWord, Map<String, ArrayList<String>> next_word_map, int step, List<List<String>> res, ArrayList<String> tmp, Map<String, Integer> distance) {
//
//        if (tmp.get(tmp.size() - 1).equals(endWord)) res.add(new ArrayList<>(tmp));
//        for (String word : next_word_map.get(tmp.get(tmp.size() - 1))) {
//            tmp.add(word);
//            if (distance.get(word) == step + 1) dfs(word, endWord, next_word_map, step + 1, res, tmp, distance);
//            tmp.remove(tmp.size() - 1);
//        }
//    }
//
//    private static void bfs(String beginWord, String endWord, Map<String, ArrayList<String>> next_word_map, Map<String, Integer> distance, Set<String> wordList_set) {
//        for (String s : wordList_set) next_word_map.put(s, new ArrayList<String>());
//        next_word_map.put(beginWord, new ArrayList<>());
//        Queue<String> queue = new LinkedList<>();
//        queue.offer(beginWord);
//        distance.put(beginWord, 0);
//        boolean flag = false;
//        int step = 0;
//        while (!queue.isEmpty()) {
//            step++;
//            int n = queue.size();
//            for (int i = 0; i < n; i++) {
//                String word = queue.poll();
//                for (String nw : next_word(word, wordList_set)
//                ) {
//                    next_word_map.getOrDefault(word, new ArrayList<>()).add(nw);
//                    if (nw.equals(endWord)) flag = true;
//                    if (!distance.containsKey(nw)){
//                        distance.put(nw, step);
//                        queue.offer(nw);
//                    }
//
//                }
//            }
//            if (flag) break;
//        }
//    }
//
//    private static ArrayList<String> next_word(String word, Set<String> wordList_set) {
//        ArrayList<String> ans = new ArrayList<>();
//
//        for (int i = 0; i < word.length(); i++) {
//            char[] chars = word.toCharArray();
//            for (char ch = 'a'; ch <= 'z'; ch++) {
//                chars[i] = ch;
//                String tmp = new String(chars);
//                if (!tmp.equals(word) && wordList_set.contains(tmp)) ans.add(tmp);
//            }
//        }
//        return ans;
//    }
}

