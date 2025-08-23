package com.test;

public class LongestRepeatingSubstringLength {

    public static void main(String[] args) {
        String s = "aaabbbcaaaabbbbbccccccccabcddd";
        System.out.println(findLongestRepeatingCharacterSubstring(s));
    }

    private static int findLongestRepeatingCharacterSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int maxLength = 1;
        int count = 1;
        for (int i=1; i<s.length(); i ++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                count ++;
            } else {
                count = 1;
            }
            maxLength = Math.max(count, maxLength);
        }
        return maxLength;
    }
}
