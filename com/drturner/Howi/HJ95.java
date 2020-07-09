package com.drturner.Howi;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName: HJ95
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/4
 * Version: 1.0
 */
public class HJ95 {
    public static void main(String[] args) throws IOException {
        Process notepad = Runtime.getRuntime().exec("notepad");
        System.out.println(notepad);
    }
}
