package com.wchb.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @date 8/7/18 4:06 PM
 */
public class S127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) return 0;

        int level = 0;
        LinkedList<String> queue = new LinkedList<>();
        queue.add(beginWord);

        Set<String> set = new HashSet<>(wordList);
        set.remove(beginWord);

        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String top = queue.removeFirst();

                if (top.equals(endWord)) return level;

                for (int j = 0; j < top.length(); j++) {
                    char[] word = top.toCharArray();
                    for (char ch = 'a'; ch < 'z'; ch++) {
                        word[j] = ch;
                        String check = new String(word);
                        if (set.contains(check)) {
                            queue.add(check);
                            set.remove(check);
                        }
                    }
                }
            }
        }

        return 0;
    }

}
