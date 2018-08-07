package com.wchb.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @date 8/6/18 4:08 PM
 */
public class S76 {
    public String minWindow(String s, String t) {

        int[] tFreq = new int[256];
        for (int i = 0; i < t.length(); i++) {
            tFreq[t.charAt(i)]++;
        }

        int[] sFreq = new int[256];
        int sCnt = 0;

        int minLength = s.length() + 1;
        int startIndex = -1;

        int l = 0, r = -1;

        while (l < s.length()) {
            if (r + 1 < s.length() && sCnt < t.length()) {
                sFreq[s.charAt(r + 1)]++;
                if (sFreq[s.charAt(r + 1)] <= tFreq[s.charAt(r + 1)])
                    sCnt++;
                r++;
            } else {
                assert (sCnt <= t.length());
                if (sCnt == t.length() && r - l + 1 < minLength) {
                    minLength = r - l + 1;
                    startIndex = l;
                }

                sFreq[s.charAt(l)]--;
                if (sFreq[s.charAt(l)] < tFreq[s.charAt(l)])
                    sCnt--;
                l++;
            }
        }


        if (startIndex != -1)
            return s.substring(startIndex, startIndex + minLength);

        return "";
    }
//    int ret = nums.length+1;
//
//    int l=0,r=-1,sum=0;
//
//        while(l<nums.length){
//
//        if(r+1<nums.length && sum<s){
//        sum += nums[++r];
//        } else{
//        sum -= nums[l++];
//        }
//
//        if(sum>=s){
//        ret = Math.min(ret,r-l+1);
//        }
//        }
//        if(ret == nums.length+1){
//        return 0;
//        }
//
//
//        return ret;


    public String minWindowV2(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> wordDict = new HashMap<>();

        for (Character c : t.toCharArray()) {
            if (wordDict.containsKey(c)) {
                wordDict.put(c, wordDict.get(c) + 1);
            } else {
                wordDict.put(c, 1);
            }
        }

        int slow = 0, minLen = Integer.MAX_VALUE, matchCount = 0, index = 0;
        for (int fast = 0; fast < s.length(); fast++) {
            char ch = s.charAt(fast);
            Integer count = wordDict.get(ch);
            if (Objects.isNull(count)) continue;

            wordDict.put(ch, count - 1);

            if (count == 1) {
                //1-->0;
                matchCount++;
            }


            while (matchCount == wordDict.size()) {
                //find a valid subString
                if (fast - slow + 1 < minLen) {
                    minLen = fast - slow + 1;
                    index = slow;
                }

                char leftMost = s.charAt(slow++);
                Integer leftMostCount = wordDict.get(leftMost);
                if (leftMostCount == null) continue;
                wordDict.put(leftMost, leftMostCount + 1);
                if (leftMostCount == 0) {
                    //0->1
                    matchCount--;
                }
            }

        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(index, index + minLen);
    }

}