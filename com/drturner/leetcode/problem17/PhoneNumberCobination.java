package com.drturner.leetcode.problem17;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: PhoneNumberCobination
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/1
 * Version: 1.0
 */
public class PhoneNumberCobination {
    private final String [] tab={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    private List<String> result=new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits==null||digits.length()==0) return result;
        letterCombinationsSub(digits,0,new StringBuilder());
        return result;
    }
    private void letterCombinationsSub(String digits,int index,StringBuilder builder){
        if (index==digits.length()){
            result.add(builder.toString());
            return;
        }
        char c = digits.charAt(index);
        String alpha = tab[c - '0'];
        for (int i=0;i<alpha.length();i++){
            letterCombinationsSub(digits, index+1,new StringBuilder(builder).append(alpha.charAt(i)));
        }
    }
    public static void main(String[] args) {
        PhoneNumberCobination phoneNumberCobination = new PhoneNumberCobination();
        List<String> list = phoneNumberCobination.letterCombinations("");
        System.out.println(list);
    }
}
