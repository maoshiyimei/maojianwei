package com.maji.maojianwei.leetcode.java_language.thread;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Class: 自旋锁的示例
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/15 , 12:09
 */
public class Spinlock {
    private AtomicReference<Thread> cas = new AtomicReference<Thread>();
    public void lock() {
        Thread current = Thread.currentThread();
        while (!cas.compareAndSet(null, current)) {
        }
    }
    public void unlock() {
        Thread current = Thread.currentThread();
        cas.compareAndSet(current, null);
    }
}
