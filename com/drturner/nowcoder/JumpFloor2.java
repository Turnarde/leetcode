package com.drturner.nowcoder;

/**
 * ClassName: JumpFloor2
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/30
 * Version: 1.0
 */
public class JumpFloor2 {
    public int JumpFloorII(int target) {
        return 1<<(target-1);
    }

    public static void main(String[] args) {
        JumpFloor2 jumpFloor2 = new JumpFloor2();
        for (int i=1;i<10;i++){
            int fibonacci = jumpFloor2.JumpFloorII(i);
            System.out.println(fibonacci);
        }
    }
}
