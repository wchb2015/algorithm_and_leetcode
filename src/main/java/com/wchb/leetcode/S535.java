package com.wchb.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @date 7/28/18 10:06 PM
 */
public class S535 {

    Map<Integer, String> map = new HashMap<>();
    int i = 0;

    public String encode(String longUrl) {
        map.put(i, longUrl);
        return "http://tinyurl.com/" + i++;
    }

    public String decode(String shortUrl) {
        return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
    }

}
