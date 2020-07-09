package com.drturner.nowcoder;

/**
 * ClassName: StringToInt
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/3
 * Version: 1.0
 */
public class StringToInt {
    public long StrToInt(String str) {
        if (str==null||str.length()==0) return 0;
        int start=(str.charAt(0)=='+'||str.charAt(0)=='-')?1:0;
        long res=0;
        for (int i=start;i<str.length();i++){
            char c = str.charAt(i);
            if (c<'0'||c>'9') return 0;
            int num=c-'0';
        //    if (res==Integer.MAX_VALUE/10&&str.charAt(0)=='-'&&)
            res=res*10+num;

        }
        if (str.charAt(0)=='-') res=-res;
        return res;
    }

    public static void main(String[] args) {
        StringToInt stringToInt = new StringToInt();
        long i = stringToInt.StrToInt("-2147483649");
        System.out.println(i);
    }
}
