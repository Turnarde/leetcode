package com.drturner.Howi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: HJ101
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/4
 * Version: 1.0
 */
public class HJ101 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int count = scanner.nextInt();
            Integer[] result=new Integer[count];
            for (int i=0;i<count;i++){
                result[i]=scanner.nextInt();
            }
            int flag = scanner.nextInt();
            if (flag==0){
                Arrays.sort(result);
            }
            else if (flag==1){
                Arrays.sort(result,(o1,o2)->o2-o1);
            }
            for (int e:result){
                System.out.print(e+" ");
            }
            System.out.println();
        }

    }
}
