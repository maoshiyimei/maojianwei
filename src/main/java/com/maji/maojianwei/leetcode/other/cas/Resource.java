package com.maji.maojianwei.leetcode.other.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class Resource {

    private AtomicInteger count = new AtomicInteger(0);


    public int get(){
        return count.get();
    }



    public void increment() {
        int oldValue;
        int newValue;
        do {
            oldValue = count.get(); // 获取当前值
            newValue = oldValue + 1; // 计算新值
        } while (!count.compareAndSet(oldValue, newValue)); // 如果当前值与预期值相等，则更新为新值，否则重试
    }


}
