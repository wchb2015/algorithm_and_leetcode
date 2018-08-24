package com.wchb.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @date 8/23/18 2:00 PM
 */
public class AutocompleteSystem642 {

    String cur_sent = "";
    Trie root;

    class Node {
        Node(String st, int t) {
            sentence = st;
            times = t;
        }

        String sentence;
        int times;
    }

    class Trie {
        int times;
        Trie[] branches = new Trie[27];
    }

    public AutocompleteSystem642(String[] sentences, int[] times) {
        root = new Trie();
        for (int i = 0; i < sentences.length; i++) {
            insert(root, sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        if (c == '#') {
            insert(root, cur_sent, 1);
            cur_sent = "";
        } else {
            cur_sent += c;
            List<Node> list = lookup(root, cur_sent);
            Collections.sort(list, (a, b) -> a.times == b.times ? a.sentence.compareTo(b.sentence) : b.times - a.times);
            for (int i = 0; i < Math.min(3, list.size()); i++)
                res.add(list.get(i).sentence);
        }
        return res;
    }

    public int int_(char c) {
        return c == ' ' ? 26 : c - 'a';
    }

    public void insert(Trie t, String s, int times) {
        for (int i = 0; i < s.length(); i++) {
            if (t.branches[int_(s.charAt(i))] == null) {
                t.branches[int_(s.charAt(i))] = new Trie();
            }
            t = t.branches[int_(s.charAt(i))];
        }
        t.times += times;
    }

    public List<Node> lookup(Trie t, String s) {
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (t.branches[int_(s.charAt(i))] == null)
                return new ArrayList<>();
            t = t.branches[int_(s.charAt(i))];
        }
        traverse(s, t, list);
        return list;
    }

    public void traverse(String s, Trie t, List<Node> list) {
        if (t.times > 0)
            list.add(new Node(s, t.times));
        for (char i = 'a'; i <= 'z'; i++) {
            if (t.branches[i - 'a'] != null)
                traverse(s + i, t.branches[i - 'a'], list);
        }
        if (t.branches[26] != null)
            traverse(s + ' ', t.branches[26], list);
    }


}
