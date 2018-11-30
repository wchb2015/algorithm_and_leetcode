package com.wchb.mj.dreamG;

import java.util.HashMap;
import java.util.Map;

/**
 * @date 11/29/18 8:46 AM
 */
public class Email {
    public int solution(String[] emails) {

        int ans = 0;

        if (emails == null || emails.length <= 1) return 0;

        Map<String, Integer> map = new HashMap<>();


        for (String email : emails) {
            String afterProcess = helper(email);
            map.put(afterProcess, map.getOrDefault(afterProcess, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) ans++;
        }

        return ans;
    }

    private String helper(String email) {

        String[] emailArr = email.split("@");

        char[] domainEmail = emailArr[0].toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < domainEmail.length; i++) {
            if (domainEmail[i] == '.') continue;
            if (domainEmail[i] == '+') break;
            sb.append(domainEmail[i]);
        }

        sb.append("@");
        return sb.toString() + emailArr[1];
    }
}
