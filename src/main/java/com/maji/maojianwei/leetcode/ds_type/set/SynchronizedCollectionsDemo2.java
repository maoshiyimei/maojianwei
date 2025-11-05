package com.maji.maojianwei.leetcode.ds_type.set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Class:
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/2/29 , 20:27
 */
public class SynchronizedCollectionsDemo2 {

    public static List<Integer> list1 = new ArrayList<>();
    public static List<Integer> list2 = Collections.synchronizedList(new ArrayList<Integer>());

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(200);
        final CountDownLatch countDownLatch = new CountDownLatch(5000);
        for(int i = 0 ; i< 5000;i++){
             int count = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    update(count);
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        for(int i = 0 ;i<100 ;i++){
            System.out.print(list1.get(i) + " ");
        }
    }
    public static void update(int i ) throws InterruptedException {

        //list1.add(i);
        list1.add(i);
        list2.add(i);
    }
}
