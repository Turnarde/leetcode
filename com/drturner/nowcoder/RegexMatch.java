package com.drturner.nowcoder;

/**
 * ClassName: RegexMatch
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/4
 * Version: 1.0
 */
public class RegexMatch {
    public boolean match(char[] str, char[] pattern) {
        return match(str,0,pattern,0);
    }
    public boolean match(char[] str,int strI, char[] pattern,int patternI) {
        if (patternI>=pattern.length) return str.length==strI;
     //   if (str.length==strI) return false;
        boolean isMatchCur=strI<str.length&&(str[strI]==pattern[patternI]||(pattern[patternI]=='.'));
        if (patternI+1<pattern.length&&pattern[patternI+1]=='*'){
            return match(str, strI, pattern, patternI+2)||(isMatchCur&&match(str, strI+1, pattern, patternI));
        //    return match(str, strI, pattern, patternI+2)||(isMatchCur&&(match(str, strI+1, pattern, patternI)||match(str, strI+1, pattern, patternI+2)));
        }
        else{
            return isMatchCur&&match(str, strI+1, pattern, patternI+1);
        }
    }
    private boolean isMatch(char[] str,int strI,char[] pattern,int patternI){
        if (patternI==pattern.length) return strI==str.length;
        String s="";
        //(strStart != str.length() && pattern.charAt(patternStart) == str.charAt(strStart)) || (pattern.charAt(patternStart) == '.' && strStart != str.length())
        boolean priMatch=((strI<str.length)&&(str[strI]==pattern[patternI]))||(pattern[patternI]=='.'&&strI<str.length);
        if ((patternI+1<pattern.length)&&pattern[patternI+1]=='*'){
            return isMatch(str,strI,pattern,patternI+2)||((priMatch)&&isMatch(str,strI+1,pattern,patternI));
        }
        else {
            return (priMatch)&&isMatch(str,strI+1,pattern,patternI+1);
        }
    }

    public static void main(String[] args) {
        RegexMatch regexMatch = new RegexMatch();
        String str="aab";
        String pattern="c*a*bc*";
        boolean match = regexMatch.match(str.toCharArray(), pattern.toCharArray());
        System.out.println(match);
    }
}
