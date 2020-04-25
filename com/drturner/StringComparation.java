package com.drturner;

public class StringComparation {
    static int compare(String left, String right){
        //4.1.15   5.16.17
        String[] leftSplit = left.split("\\.");
        String[] rightSplit = right.split("\\.");
        int i=0;
        int j=0;
        while (i<leftSplit.length&&j<rightSplit.length){
            if (leftSplit[i].compareTo(rightSplit[j])>0){
                return 1;
            }
            else if (leftSplit[i].compareTo(rightSplit[j])<0){
                return -1;
            }
            i++;
            j++;
        }
        if(i<leftSplit.length) return 1;
        else if (j<rightSplit.length) return -1;
        else
            return 0;
    }

    public static void main(String[] args) {
        String s1="5.1.3";
        String s2="31.2";
        int c = compare(s1, s2);
        System.out.println(c);
    }
}
