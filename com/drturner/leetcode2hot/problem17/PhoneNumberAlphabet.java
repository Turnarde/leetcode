package com.drturner.leetcode2hot.problem17;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: PhoneNumberAlphabet
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/8
 * Version: 1.0
 */
public class PhoneNumberAlphabet {
    final String [] tab={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    private List<String> result=new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        char[] str = digits.toCharArray();
        letterCombinationsSub(str,0,new StringBuilder());
        return result;
    }
    private void letterCombinationsSub(char[] digits,int start,StringBuilder builder){
        if (start==digits.length){
            result.add(builder.toString());
            return;
        }
        for (int i=0;i<tab[digits[start]-'0'].length();i++){
            letterCombinationsSub(digits, start+1, new StringBuilder(builder).append(tab[digits[start]-'0'].charAt(i)));
        }
    }

    public static void main(String[] args) {
        PhoneNumberAlphabet phoneNumberAlphabet = new PhoneNumberAlphabet();
        List<String> list = phoneNumberAlphabet.letterCombinations("2345");
        System.out.println(list);
    }
}
