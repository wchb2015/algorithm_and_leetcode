package com.wchb.leetcode;

/**
 * @date 6/6/18 4:33 PM
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class WordDictionary211 {

    Trie t;

    public WordDictionary211() {
        t = new Trie();
    }


    public void addWord(String word) {
        t.insert(word);
    }

    public boolean search(String word) {
        return t.search(word);
    }


    class Trie {

        class Node {
            boolean isEndOfWord;
            Map<Character, Node> next;

            public Node(boolean isEndOfWord) {
                this.isEndOfWord = isEndOfWord;
                next = new HashMap<>();
            }
        }

        private Node root;

        public Trie() {
            root = new Node(false);
        }

        public void insert(String word) {
            Node p = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!p.next.containsKey(c)) {
                    p.next.put(c, new Node(false));
                }
                p = p.next.get(c);
            }
            p.isEndOfWord = true;
        }

        public boolean search(String word) {
            Node p = root;
             return helper(word, 0, p);
//            Node p = root;
////            for (int i = 0; i < word.length(); i++) {
////                if (word.charAt(i) == '.') {
////
////                } else {
////                    if (!p.next.containsKey(word.charAt(i))) return false;
////                    p = p.next.get(word.charAt(i));
////                }
////            }
////
////            return p.isEndOfWord;
        }

        private boolean helper(String word, int idx, Node p) {
            if (idx == word.length()) return p.isEndOfWord;
            char cur = word.charAt(idx);

            if (cur == '.') {
                for (Node next : p.next.values()) {
                    if (helper(word, idx + 1, next)) return true;
                }
                return false;
            } else {
                if (!p.next.containsKey(cur)) return false;
                return helper(word, idx + 1, p.next.get(cur));
            }

        }
    }
}
