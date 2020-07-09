package com.drturner.leetcode.jianzhioffer.problem33;

/**
 * ClassName: PostOrder
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/21
 * Version: 1.0
 */
public class PostOrder {
    class ResultType{
        boolean flag;
        int min;
        int max;

        public ResultType(boolean flag, int min, int max) {
            this.flag = flag;
            this.min = min;
            this.max = max;
        }
    }
    private boolean verifyPostorderSub(int[] postorder,int start,int end){
        if (start>=end) return true;
        int i=end-1;
        for (;i>=start;i--){
            if (postorder[i]<postorder[end])
                break;
        }
        for (int j=start;j<=i;j++){
            if (postorder[j]>postorder[end]) return false;
        }
        return verifyPostorderSub(postorder,start,i)&&verifyPostorderSub(postorder, i+1, end-1);
    }
    public boolean VerifySquenceOfBST(int [] sequence){
        if (sequence.length==0) return false;
        return verifyPostorderSub(sequence,0,sequence.length-1);
    }
    public static void main(String[] args) {

        int[] number={};
        PostOrder postOrder = new PostOrder();
        boolean b = postOrder.VerifySquenceOfBST(number);
        System.out.println(b);
    }
}
