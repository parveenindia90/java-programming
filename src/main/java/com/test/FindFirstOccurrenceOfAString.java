package com.test;

public class FindFirstOccurrenceOfAString {

    public static void main(String[] args) {
        System.out.println(findStrIndex("sadbutsad", "dfd"));
    }

    public static int findStrIndex(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
