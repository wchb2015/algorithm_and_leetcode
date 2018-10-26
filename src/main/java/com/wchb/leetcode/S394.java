package com.wchb.leetcode;

import java.util.Stack;

/**
 * @date 8/18/18 9:08 AM
 */
public class S394 {

    //递归解法
    public String decodeString(String s) {

        if (s == null || s.length() == 0) return s;
        if (!s.contains("[")) return s;

        Stack<Integer> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();

        char[] arr = s.toCharArray();
        String num = "";
        String temp = "";

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= '0' && arr[i] <= '9') {
                if (temp.length() > 0) {
                    stack2.push(temp);
                }
                temp = "";
                num += arr[i];
            } else {
                temp += arr[i];
                if (num.length() > 0) {
                    stack1.push(Integer.parseInt(num));
                }
                num = "";
            }
        }


        String res = "";
        int firstSquare = s.charAt('[');
        int lastSquare = s.charAt(']');
        int freq = Integer.parseInt(s.substring(0, firstSquare));

        //String temp = decodeString(s.substring(firstSquare + 1, lastSquare));
        while (freq > 0) {
            res += temp;
            freq--;
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
