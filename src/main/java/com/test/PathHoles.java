package com.test;

public class PathHoles {
    public static void main(String[] args) {
        String S= "XXX..XXX..XXX..XXX..XXX..XXX..XXX..XXXXXX";

        int fixes = 0;
        for (int i=0;i<S.length();i++) {
            if(S.charAt(i) == 'X') {
                fixes++;
                i += 2;
            }
        }
        System.out.println(fixes);
    }
}
