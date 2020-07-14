package com.drturner.jindian;

//段式回文
public class LongestSubPalindrome {
    private int longestDecomposition(char[] text,int start,int end){
        if (start==end) return 1;
        if (start>end) return 0;
        for (int i=end;i>start+(end-start)/2;i--){
            if (text[start]==text[i]){
                boolean flag=true;
                for (int j=i;j<=end;j++){
                    if (text[start+j-i]!=text[j]){
                        flag=false;
                        break;
                    }
                }
                if (flag){
                    return longestDecomposition(text, start+end-i+1, i-1)+2;
                }
            }
        }
        return 1;
    }
    public int longestDecomposition(String text) {
        if (text.length()==0) return 0;
        char[] str = text.toCharArray();
        int i = longestDecomposition(str, 0, str.length - 1);
        return i;
    }

    public static void main(String[] args) {
        LongestSubPalindrome longestSubPalindrome = new LongestSubPalindrome();
        int result = longestSubPalindrome.longestDecomposition("aba");
        System.out.println(result);
    }
}
