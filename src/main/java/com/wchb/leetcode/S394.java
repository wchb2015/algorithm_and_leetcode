package com.wchb.leetcode;

import java.util.Stack;

/**
 * @date 8/18/18 9:08 AM
 */
public class S394 {

    //递归解法
    public String decodeString(String s) {
        int i = 0;
        return decode(s, i);
    }

    private String decode(String s, int i) {
        String res = "";
        int n = s.length();
        while (i < n && s.charAt(i) != ']') {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                res += s.charAt(i++);
            } else {
                int cnt = 0;
                while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    cnt = cnt * 10 + s.charAt(i++) - '0';
                }
                ++i;
                String t = decode(s, i);
                ++i;
                while (cnt-- > 0) {
                    res += t;
                }
            }
        }
        return res;
    }

    /************************************************************/

    // Stack
    // 如果遇到数字,我们更新计数变量cnt
    // 如果遇到左中括号,我们把当前cnt压入数字栈中，把当前t压入字符串栈中
    // 如果遇到右中括号时,我们取出数字栈中顶元素,存入变量k,然后给字符串栈的顶元素循环加上k个t字符串,然后取出顶元素存入字符串t中
    // 如果遇到字母,我们直接加入字符串t中即可
    public String decodeStringV2(String s) {

        String ans = "";
        Stack<Integer> sNum = new Stack<>();
        Stack<String> sStr = new Stack<>();


        int index = 0;

        while (index < s.length()) {
            char cur = s.charAt(index);

            if (Character.isDigit(cur)) {

                int count = 0;

                int start = index;
                while (Character.isDigit(s.charAt(index))) {
                    index++;
                }
                count = Integer.parseInt(s.substring(start, index));
                sNum.push(count);
            } else if (cur == '[') {
                sStr.push(ans);
                ans = "";
                index++;
            } else if (cur == ']') {
                int freq = sNum.pop();
                String str = sStr.pop();

                while (freq > 0) {
                    str += ans;
                    freq--;
                }
                sStr.push(str);
                index++;

            } else {

                ans += cur;
                index++;
            }
        }


        return sStr.pop();
    }
}
