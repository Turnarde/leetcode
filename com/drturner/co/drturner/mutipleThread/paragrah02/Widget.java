package com.drturner.co.drturner.mutipleThread.paragrah02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ClassName: Widget
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/23
 * Version: 1.0
 */
class  Th extends Thread{
    private Widget widget=new Widget();
    public void show(){
        synchronized (widget){
            System.out.println("class Th show method execute!");
            widget.show();
        }

    }
    @Override
    public void run() {
        show();
    }
}
public class Widget {
    public synchronized void show(){
        System.out.println("This is father method!");
    }

    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        synchronized (list){
            for (int e:list){
                System.out.println(e);
                if (list.size()>1)

                    list.remove(list.size()-1);
            }
        }

    }
}
class Son{
    public synchronized void showSon() {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(32);
        List<Integer> list1 = Collections.synchronizedList(list);
        System.out.println("This is a son method!");
    }
}
