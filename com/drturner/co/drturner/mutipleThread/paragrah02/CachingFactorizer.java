package com.drturner.co.drturner.mutipleThread.paragrah02;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * ClassName: CachingFactorizer
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/25
 * Version: 1.0
 */
public class CachingFactorizer {
    class Cache{
        BigInteger number;
        BigInteger[] factor;
    }
    private final AtomicReference<Cache> cache=new AtomicReference<>();

}
