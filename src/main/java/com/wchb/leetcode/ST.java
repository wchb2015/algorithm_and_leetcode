package com.wchb.leetcode;

import java.util.*;


/**
 * @date 12/29/18 12:27 PM
 */
public class ST {

    public String strWithout3a3b(int A, int B) {

        char[] arr = new char[A + B];
        char first = A > B ? 'a' : 'b';
        char second = first == 'a' ? 'b' : 'a';

        int i = 0;
        while (first > 0) {
            if (i != 0 && arr[i - 1] == first) {
                i++;
            } else {
                arr[i++] = first;
            }
            first--;
        }

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != first) {
                arr[j] = second;
            }
        }

        return new String(arr);
    }

    int max = -1;

    public int solution(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        if (arr.length == 1) return arr[0];
        if (arr.length == 2) return Math.max(arr[0], arr[1]);

        dfs(arr, 0, arr.length - 1, 0, true);

        System.out.println(Arrays.toString(arr) + " max: " + max);
        return max;
    }


    private void dfs(int[] arr, int left, int right, int sum, boolean isMe) {
        if (left > right) {
            max = Math.max(sum, max);
            return;
        }
        if (left == right) {
            if (isMe) {
                sum += arr[left];
            }
            max = Math.max(sum, max);
            return;
        }

        if (isMe) {
            dfs(arr, left + 1, right, sum + arr[left], !isMe);
            dfs(arr, left, right - 1, sum + arr[right], !isMe);
        } else {
            boolean pickLeft = arr[left] > arr[right];
            dfs(arr, pickLeft ? left + 1 : left, pickLeft ? right : right - 1, sum, !isMe);
        }
    }

    List<List<String>> ans = new LinkedList<>();
    int min = Integer.MAX_VALUE;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) return ans;
        if (!wordList.contains(endWord)) return ans;

        Set<String> set = new HashSet<>(wordList);
        Map<String, List<String>> g = new HashMap<>();
        set.add(beginWord);
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        q.add(beginWord);
        visited.add(beginWord);

        while (!q.isEmpty()) {
            int levelCount = q.size();

            while (levelCount > 0) {
                String cur = q.poll();
                levelCount--;
                if (!g.containsKey(cur)) g.put(cur, new LinkedList<>());


                char[] arr = cur.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char old = arr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) continue;
                        arr[i] = c;
                        String temp = new String(arr);

                        if (set.contains(temp) && !visited.contains(temp)) {
                            q.add(temp);
                            visited.add(temp);
                            g.get(cur).add(temp);
                        }
                    }
                    arr[i] = old;
                }
            }
        }


        visited.clear();
        LinkedList<String> path = new LinkedList<>();
        visited.add(beginWord);
        path.add(beginWord);
        dfs(beginWord, endWord, g, visited, path);
        if (min == Integer.MAX_VALUE) return ans;
        List<List<String>> ret = new LinkedList<>();

        for (List<String> list : ans) {
            if (list.size() == min) {
                ret.add(list);
            }
        }


        return ret;
    }


    private void dfs(String start, String end, Map<String, List<String>> g, HashSet<String> visited, LinkedList<String> path) {
        if (start.equals(end)) {
            ans.add(new LinkedList<>(path));
            min = Math.min(min, path.size());
            return;
        }
        if (path.size() > min) {
            return;
        }

        List<String> neis = g.get(start);
        if (neis == null) return;
        for (String nei : neis) {
            if (visited.contains(nei)) continue;
            visited.add(nei);
            path.add(nei);

            dfs(nei, end, g, visited, path);
            visited.remove(nei);
            path.remove(path.size() - 1);
        }
    }

}
