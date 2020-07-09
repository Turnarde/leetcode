package com.drturner.com.drturner.daily;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * ClassName: MyLockTest
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/22
 * Version: 1.0
 */
class MyLock implements Lock{
//    AtomicInteger state=new AtomicInteger(0);
    private AtomicInteger count=new AtomicInteger(0);
    private AtomicReference<Thread> state=new AtomicReference<>();
    private LinkedBlockingDeque<Thread> blockingDeque=new LinkedBlockingDeque<>();
 //   Thread curr=null;
    @Override
    public void lock() {
        if (state.get()==Thread.currentThread()){
            count.getAndIncrement();
            return;
        }
        while (!state.compareAndSet(null,Thread.currentThread())){
            blockingDeque.add(Thread.currentThread());
            LockSupport.park();
            blockingDeque.remove(Thread.currentThread());
        }
        count.getAndIncrement();
    //    curr=Thread.currentThread();
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {

        if (!state.compareAndSet(null,Thread.currentThread())){
            return false;
        }
        return true;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        if (state.get()==Thread.currentThread()&&count.decrementAndGet()==0&&state.compareAndSet(Thread.currentThread(),null)){
            for (Thread t:blockingDeque){
                LockSupport.unpark(t);
            }
        }
    //    if (state.compareAndSet(Thread.currentThread(),null)){
    //        for (Thread t:blockingDeque){
     //           LockSupport.unpark(t);
      //      }
    //    }

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
class LockTest implements Runnable{
    private static MyLock lock=new MyLock();
    @Override
    public void run() {
        lock.lock();
        System.out.println("Current thread: "+Thread.currentThread().getName()+" start");
        try {
            lock.lock();
            Thread.sleep(5000);
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Current thread: "+Thread.currentThread().getName()+" end");
        lock.unlock();
    }
}

public class MyLockTest{
    public static void main(String[] args) {
        LockTest t1 = new LockTest();
        LockTest t2 = new LockTest();
        LockTest t3 = new LockTest();
        LockTest t4 = new LockTest();
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
        new Thread(t4).start();
    }

}
