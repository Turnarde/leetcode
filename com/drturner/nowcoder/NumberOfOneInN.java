package com.drturner.nowcoder;

/**
 * ClassName: NumberOfOneInN
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/1
 * Version: 1.0
 */
public class NumberOfOneInN {
    public int NumberOf1Between1AndN_Solution(int n) {
        int division=10;
      //  int modd=0;
        int count=0;
        while (n/division>0){
            if (n%division>=2*division/10){
                count+=n/division*(division/10)+division/10;
            }
            else if (n%division>=division/10){
                count+=n/division*(division/10)+n%division-division/10+1;
            }
            else{
                count+=n/division*(division/10);
            }
        //    System.out.println(count);
            division*=10;
        }
        if (n%division>=2*division/10){
            count+=division/10;
        }
        else if ((n%division>=division/10)){
            count+=n%division-division/10+1;
        }
        return count;
    }

    /*
    * 这里思路参考的是《编程之美》书中的一种解法
    * 感觉比上面一种更好理解，思路是针对每一位，
    * 取其那一位上的数字存放在变量eq中，那一位之前的高位数存放在more中，低位数存放在less中，
    * 对于每一位上是数字，分大于1，小于1（即等于0）和等于1三种情况予以讨论求解
    * */
    public int NumberOf1Between1AndN_Solution2(int n) {
        if (n<1) return 0;
        int count=0;
        int div=10;
        int num=n;
        int more=n/div,less=0,eq=n%div;
        while (more>0){
            if (eq>1) count+=(more+1)*(div/10);
            else if (eq==0) count+=more*(div/10);
            else count+=more*(div/10)+less+1;
            less=num%div;
            eq=(num/div)%10;
            div*=10;
            more=num/(div);
        }
        if (eq>1) count+=div/10;
        else count+=less+1;
        return count;
    }


    public static void main(String[] args) {
        NumberOfOneInN numberOfOneInN = new NumberOfOneInN();
       // for (int i=1;i<10000;i++){
       // for (int i=1;i<Integer.MAX_VALUE;i++){
            int b = numberOfOneInN.NumberOf1Between1AndN_Solution2(0);
           //  if (!b)
                System.out.println("i: "+"  "+b);
     //   }

     //   }


    }
}
