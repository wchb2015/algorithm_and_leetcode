package com.wchb.leetcode;

/**
 * @date 6/6/18 4:33 PM
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TreeMap;

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
public class WordDictionary211 {

    private static final Logger logger = LoggerFactory.getLogger(WordDictionary211.class);

    private class Node {

        public boolean isWord;

        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Node { isWord: ").append(isWord).append(", next: ");
            sb.append(next);
            return sb.toString();
        }
    }

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary211() {
        root = new Node();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        // 避免添加的单词已经存在 更新size错误
        if (!cur.isWord) {
            cur.isWord = true;
        }
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return match(root, word, 0);
    }

    private boolean match(Node node, String word, int index) {
        logger.info("  word: {},index:{}", word, index);

        if (index == word.length()) {
            return node.isWord;
        }

        char c = word.charAt(index);

        if (c != '.') {
            if (node.next.get(c) == null) {
                return false;
            }
            return match(node.next.get(c), word, index + 1);
        } else {
            for (char nextChar : node.next.keySet()) {
                logger.info(" keySet:{}", node.next.keySet());
                if (match(node.next.get(nextChar), word, index + 1)) {
                    return true;
                }
            }
            return false;
        }
    }
}
