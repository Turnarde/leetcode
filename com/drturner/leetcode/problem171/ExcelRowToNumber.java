package com.drturner.leetcode.problem171;

/**
 * ClassName: ExcelRowToNumber
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/10
 * Version: 1.0
 */
public class ExcelRowToNumber {
    //ZZY
    public int titleToNumber(String s) {
        if (s==null||s.length()==0) return 0;
        int count=0,result=0,weight=1;
        for (int i=s.length()-1;i>=0;i--){
            count=count+weight*(s.charAt(i)-'A'+1);
            weight*=26;
        }
        return count;
    }

    public static void main(String[] args) {
        ExcelRowToNumber excelRowToNumber = new ExcelRowToNumber();
        int zzy = excelRowToNumber.titleToNumber("ZZZY");
        System.out.println(zzy);
    }
}
