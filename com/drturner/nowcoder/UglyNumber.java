package com.drturner.nowcoder;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: UglyNumber
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/1
 * Version: 1.0
 */
public class UglyNumber {
    /*
    * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
    * 例如6、8都是丑数，但14不是，因为它包含质因子7。
    * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
    * */
    public int GetUglyNumber_Solution(int index) {
       // if (index<6) return index;
        if (index==0) return 0;
        int[] num=new int[index+1];
        int i2=1,i3=1,i5=1;
        num[1]=1;
        for (int i=2;i<num.length;i++){
            int n2=num[i2]*2;
            int n3=num[i3]*3;
            int n5=num[i5]*5;
            num[i]=Math.min(n2,Math.min(n3,n5));
            if (n2==num[i]) i2++;
            if (n3==num[i]) i3++;
            if (n5==num[i]) i5++;
        }
        return num[index];
    }

    public static void main(String[] args) {
        UglyNumber uglyNumber = new UglyNumber();
        int i = uglyNumber.GetUglyNumber_Solution(1);
        System.out.println(i);
    }
}
