package com.wchb.mj.dreamG;

import java.util.*;

/**
 * @date 3/21/19 9:43 AM
 */
public class General {

    // 给出aa{b,c}dd，输出 aabdd aacdd，给出{aa,b}{c,dd}{e,g}，输出 "aace aacg aadde aaddg bce bcg bdde bdddg"
    public List<String> solution1(List<List<String>> list) {
        List<String> ans = new LinkedList<>();
        if (list.size() == 0) return ans;
        if (list.size() == 1) return list.get(0);
        dfs(list, 0, "", ans);
        return ans;
    }

    private void dfs(List<List<String>> list, int idx, String s, List<String> ans) {
        if (idx == list.size()) {
            ans.add(s);
            return;
        }

        for (String cur : list.get(idx)) {
            dfs(list, idx + 1, s + cur, ans);
        }
    }


    //A:abc，B：ababc = True，A：abc， B：acbdc = False.
    public boolean oneAdd(String from, String to) {

        String left = "";
        String right = "";
        int l = 0;

        int r = 0;

        while (l < from.length() && from.charAt(l) == to.charAt(l)) {
            l++;
        }
        if (l == from.length()) return true;

        while (r < from.length() && from.charAt(from.length() - 1 - r) == to.charAt(to.length() - 1 - r)) {
            r++;
        }
        if (r == from.length()) return true;

        left = to.substring(0, l + 1);
        right = to.substring(to.length() - r, to.length());


        return (left + right).equals(from);
    }


    /*
    iterator to release the number
    比如[3, 1, 5, 2, 6, 4]，1, 2, 4是element； 3, 5, 6是frequency。
    3556666
     */

    public void iterator(int[] arr) {
        int i = 0;
        int num = -1;

        for (; i < arr.length; i++) {
            if (i % 2 == 0) {
                num = arr[i];
            } else {
                int freq = arr[i];
                while (freq > 0) {
                    freq--;
                    System.out.println(num);
                }
            }
        }
    }


    // aaaaabbbbbbbbccc  ->5xa8xb3xc
    public void encoding(String s) {
        char c = s.charAt(0);
        int count = 1;

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            } else {
                sb.append(count).append(c);
                count = 1;
                c = s.charAt(i);
            }
        }

        sb.append(count).append(c);

        System.out.println(sb);

        String t = "15a8b3c";
        sb.setLength(0);

        int numStart = 0;
        int numEnd = 0;
        int p = 0;
        while (numStart < t.length()) {
            while (Character.isDigit(t.charAt(numEnd))) {
                numEnd++;
            }

            int freq = Integer.parseInt(t.substring(numStart, numEnd));

            p = numEnd;
            while (freq > 0) {
                freq--;
                sb.append(t.charAt(p));
            }
            numStart = p + 1;
            numEnd = p + 1;
        }


        System.out.println(sb);
    }


    public int[] find(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap();
        int max = 0;
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            //int cnt = 1;
            int key = arr[i];
            int value = map.getOrDefault(key - 3, 0) + 1;
            value = Math.max(map.getOrDefault(key, 0), value);
            if (value > cnt) {
                cnt = value;
                max = key;
            }
            map.put(key, value);
        }
        int[] ans = new int[cnt];
        int target = max - (cnt - 1) * 3;
        int i = 0;
        for (int n : arr) {
            if (n == target) {
                ans[i++] = n;
                target += 3;
            }
        }


        return ans;
    }


    // len(source)*log(len(target))
    // 存每个字母出现的位置 然后用BS 查找 1 找到好说. 更新index . 2 没找到 增加copy 更新index 为最小.
    public int getMinCopies(String source, String target) {
        // store source's index list with same value
        Map<Character, TreeSet<Integer>> valueIndexMap = new HashMap<>();

        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            valueIndexMap.putIfAbsent(c, new TreeSet<>());
            valueIndexMap.get(c).add(i);
        }

        int indexOfSource = 0;
        int res = 1;

        for (int i = 0; i < target.length(); i++) {
            char cur = target.charAt(i);
            if (!valueIndexMap.containsKey(cur)) return -1;
            TreeSet<Integer> set = valueIndexMap.get(cur);

            indexOfSource = set.ceiling(indexOfSource);
            indexOfSource++;
            if (indexOfSource == source.length()) {
                res++;
                indexOfSource = 0;
            }
        }

        return res;
    }


}
