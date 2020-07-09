package com.drturner.leetcode.jianzhioffer.problem19;

/**
 * ClassName: RegexIsMatch
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/4
 * Version: 1.0
 */
public class RegexIsMatch {

    private boolean isMatch(char[] s,int startS, char[] p,int startP) {
        if (startP>=p.length) return startS>=s.length;
        boolean ismatch=startS<s.length&&(s[startS]==p[startP]||p[startP]=='.');
        if ((startP+1<p.length)&&p[startP+1]=='*'){
            return ismatch&&(isMatch(s,startS+1,p,startP))||
                    (isMatch(s, startS, p, startP+2));
        }
        else {
            return ismatch&&isMatch(s,startS+1,p,startP+1);
        }
    }
    public boolean isMatch(String s, String p) {
        if (s==null||p==null) return false;
        return isMatch(s.toCharArray(),0,p.toCharArray(),0);
    }

    public static void main(String[] args) {
        RegexIsMatch regexIsMatch = new RegexIsMatch();
        String s="";
        String p="";
        boolean match = regexIsMatch.isMatch(s, p);
        System.out.println(match);
    }
}
