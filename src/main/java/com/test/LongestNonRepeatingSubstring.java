package com.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestNonRepeatingSubstring {
    public static void main(String[] args) {
        String s = "pwwkewxpw";
        System.out.println(findLongestNonRepeatingSubString(s));
    }

    private static int findLongestNonRepeatingSubString(String s) {
        //approach 1 using set
        /*int maxLength = 0;
        Set<Character> charSet = new HashSet<>();
        int left = 0;
        for (int right =0; right < s.length(); right++) {
            while (charSet.contains(s.charAt(right))) {  //remove characters from set until repeating character occurs
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(s.charAt(right));
            maxLength = Math.max(maxLength, right-left +1);
        }
        return maxLength;*/

        //approach 2 using hashmap
        int maxLength = 0;
        Map<Character, Integer> visitedMap = new HashMap<>();
        int left = 0;
        for (int right =0; right < s.length(); right++) {
            char currChar = s.charAt(right);
            if (visitedMap.containsKey(currChar)) {
                left = Math.max(visitedMap.get(currChar)+1, left);
            }
            maxLength = Math.max(maxLength, right -left +1);
            visitedMap.put(s.charAt(right), right);
        }

        return maxLength;

    }
}
