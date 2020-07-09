package com.drturner.nowcoder;

/**
 * ClassName: IsBSTSequence
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/1
 * Version: 1.0
 */
public class IsBSTSequence {
    private boolean VerifySquenceOfBSTSub(int [] sequence,int L,int R){
        if(L>=R) return true;
        int r=sequence[R];
        int i=R-1;
        for (;i>=L;i--){
            if (sequence[i]<r) break;
        }
        for (int j=L;j<=i;j++){
            if (sequence[j]>r) return false;
        }
        return VerifySquenceOfBSTSub(sequence,L,i)&&VerifySquenceOfBSTSub(sequence, i+1, R-1);
    }
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length==0) return false;
        return VerifySquenceOfBSTSub(sequence,0,sequence.length-1);
    }

    public static void main(String[] args) {
        IsBSTSequence isBSTSequence = new IsBSTSequence();
        int[] seqquence={};
        boolean b = isBSTSequence.VerifySquenceOfBST(seqquence);
        System.out.println(b);
    }
}
