package com.drturner.leetcode;

/**
 * ClassName: LockTest
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/30
 * Version: 1.0
 */

public class LockTest {
    public static void main(String[] args) throws InterruptedException {
        Room room=new Room();
        new Thread(()->{
            try {
                room.show1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();
        Thread.sleep(1000);
        System.out.println(room.obj.hashCode());
    }
}
class Room{
    public Object obj=new Object();
    public void show1() throws InterruptedException {
        synchronized (obj){
            Thread.sleep(5000);
            System.out.println("show"+Thread.currentThread().getName());
        }

    }

}
