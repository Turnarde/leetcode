package com.drturner.leetcode.problem76;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MinWindow {
    private boolean matches(Map<Character,Integer> window,Map<Character,Integer> needs){
        if (window.size()<needs.size()) return false;
        for (char key:needs.keySet()) if (!window.containsKey(key)||(window.get(key)<needs.get(key))) return false;
        return true;
    }
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0
                || t.length() == 0 || t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> needs = new HashMap<>();
        for (char ch : t.toCharArray()) {
            int nums = needs.getOrDefault(ch, 0);
            needs.put(ch, nums + 1);
        }
        int left = 0;//左指针
        int right = 0;//右指针
        int resLeftRight = Integer.MAX_VALUE;//保存最小的left、right的间隔
        int minLeft = 0;//保存间隔最小的符合条件的left
        Map<Character, Integer> windows = new HashMap<>();
        while (right < s.length()) {
            char curChar = s.charAt(right);
            int curNum = windows.getOrDefault(curChar, 0);
            windows.put(curChar, curNum + 1);
            right++;
        //    while (right - left >= t.length() && matches(windows, needs)) {
            while (matches(windows, needs)) {
                int curLeftRight = right - left;
                if (curLeftRight < resLeftRight) {
                    //可能有很多符合条件的，比较出left、right间隔最小的
                    minLeft = left;
                    resLeftRight = curLeftRight;
                }
                char leftChar = s.charAt(left);
                int leftCharNum = windows.get(leftChar);
                if (leftCharNum == 1) {
                    windows.remove(leftChar);
                } else {
                    windows.put(leftChar, leftCharNum - 1);
                }
                left++;
            }
        }
        return resLeftRight == Integer.MAX_VALUE ? ""
                : s.substring(minLeft, minLeft + resLeftRight);
    }

    public static void main(String[] args) {
        String s="ADOBECODEBANC";
        String t="AOD";
        MinWindow minWindow = new MinWindow();
        String s1 = minWindow.minWindow(s, t);
        System.out.println(s1);
    }
}
