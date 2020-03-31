package com.imooc.sell.leetcode;

import java.util.*;

class TrieNode {
    String word = "";
    Map<Character, TrieNode> children;
    public TrieNode() {
        // this.word = "";
        this.children = new HashMap<>();
    }
}

class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new TrieNode());
            }
            node = node.children.get(ch);
        }
        node.word = word;
    }

    public boolean search(String word) {
        if (searchNode(word) == null || !searchNode(word).word.equals(word)) return false;
        return true;
    }

    public boolean startWith(String prefix) {
        if (searchNode(prefix) != null) return true;
        return false;
    }

    public TrieNode searchNode(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.children.containsKey(ch)) {
                return null;
            } else {
                node = node.children.get(ch);
            }
        }
        return node;
    }
}


public class WordSearch2 {


    //use set to eliminate duplication
    Set<String> ans = new HashSet<>();
    //main function to build Trie and begin dfs search at every node
    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || board[0].length == 0) return null;
        //build trie
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                dfs("", i, j, board, visited, trie);
            }
        }
        return new ArrayList<>(ans);
    }

    //dfs
    public void dfs(String str, int x, int y, char[][] board, boolean[][] visited, Trie trie) {
        //corner case that dfs end
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y]) return;

        //important statement to stop dfs earlier
        if (!trie.startWith(str)) return;
        //if we find the whole str add it to ans
        if (trie.search(str)) {
            ans.add(str);
        }

        visited[x][y] = true;
        dfs(str, x + 1, y, board, visited, trie);
        dfs(str, x - 1, y, board, visited, trie);
        dfs(str, x, y + 1, board, visited, trie);
        dfs(str, x, y - 1, board, visited, trie);
        visited[x][y] = false;
    }
}
