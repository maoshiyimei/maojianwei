package com.maji.maojianwei.leetcode.designPatterm;

/**
 * 双校验掸里模式
 */
public class SingletonDemo {

    // volatile 修饰是为了防止指令重排序导致其他现成获得没有初始化的实例
    private volatile static SingletonDemo singletonDemo;

    private SingletonDemo(){

    }

    public static SingletonDemo getInstance(){
        if( singletonDemo == null ){
            synchronized (SingletonDemo.class){ //锁
                if(singletonDemo == null ){
                    singletonDemo = new SingletonDemo(); // 这不是原子操作
                }
            }
        }
        return singletonDemo;
    }

}
