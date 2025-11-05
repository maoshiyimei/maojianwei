package com.maji.maojianwei.leetcode.java_language.test.threadlocal;

import java.util.concurrent.TimeUnit;

public class ThreadLocalDemo {
    public static void main(String[] args) throws InterruptedException {
        firstStack();
        Thread thread = Thread.currentThread();
        System.out.println(thread);
        System.gc();
        TimeUnit.SECONDS.sleep(1);

        System.out.println(thread); // �������ϵ㣬�۲�thread�������ThreadLocalMap����

    }
    // ͨ���Ƿ��ȡ����ֵ�۲�A�������local�����Ƿ񱻻���
    private static A firstStack(){
        A a = new A();
        System.out.println("value: "+ a.get());
        return a;
    }
    private static class A{
        private ThreadLocal<String> local = ThreadLocal.withInitial(() -> "in class A");

        public String get(){
            return local.get();
        }
        public void set(String str){
            local.set(str);
        }

    }
}
