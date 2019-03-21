package com.wchb.leetcode;

import java.util.*;

/**
 * @date 8/23/18 2:00 PM
 */
public class AutocompleteSystem {

    StringBuilder curInput;

    Trie t;

    PriorityQueue<Trie.Node> pq;

    public AutocompleteSystem(String[] sentences, int[] times) {
        t = new Trie();
        pq = new PriorityQueue<>((n1, n2) -> n1.times == n2.times ? n1.content.compareTo(n2.content) : n2.times - n1.times);
        curInput = new StringBuilder();
        for (int i = 0; i < sentences.length; i++) {
            t.insert(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        pq.clear();

        List<String> res = new LinkedList<>();

        if (c == '#') {
            String cur = curInput.toString();
            if (t.contains(cur)) {
                t.insert(cur, t.get(cur).times + 1);
            } else {
                t.insert(cur, 1);
            }
            curInput.setLength(0);
        } else {
            curInput.append(c);
            List<Trie.Node> nodes = t.beginWith(curInput.toString());

            for (Trie.Node n : nodes) {
                pq.offer(n);
            }

            int k = 0;

            while (k < 3 && !pq.isEmpty()) {
                k++;
                res.add(pq.poll().content);
            }
        }

        return res;
    }


    class Trie {

        class Node {
            Map<Character, Node> next;
            boolean isEnd;
            String content;
            int times;

            public Node(boolean isEnd) {
                this.isEnd = isEnd;
                content = "";
                times = 0;
                next = new HashMap<>();
            }
        }

        public Trie() {
            this.root = new Node(false);
        }

        Node root;

        public boolean contains(String s) {
            return get(s) != null;
        }

        public Node get(String s) {
            Node p = root;
            for (int i = 0; i < s.length(); i++) {
                char cur = s.charAt(i);
                if (!p.next.containsKey(cur)) return null;
                p = p.next.get(cur);
            }
            return p.isEnd ? p : null;
        }

        public List<Node> beginWith(String prefix) {
            List<Node> res = new LinkedList<>();
            Node p = root;

            for (int i = 0; i < prefix.length(); i++) {
                char cur = prefix.charAt(i);
                if (!p.next.containsKey(cur)) return res;

                p = p.next.get(cur);

            }

            search(p, res);
            return res;
        }

        private void search(Node p, List<Node> res) {
            if (p.isEnd) res.add(p);
            if (p.next.size() == 0) return;
            for (Map.Entry<Character, Node> en : p.next.entrySet()) {
                search(en.getValue(), res);
            }
        }


        public void insert(String sentence, int time) {

            Node p = root;

            for (int i = 0; i < sentence.length(); i++) {
                char cur = sentence.charAt(i);
                if (!p.next.containsKey(cur)) {
                    p.next.put(cur, new Node(false));
                }
                p = p.next.get(cur);
            }

            p.content = sentence;
            p.times = time;
            p.isEnd = true;
        }
    }
}
