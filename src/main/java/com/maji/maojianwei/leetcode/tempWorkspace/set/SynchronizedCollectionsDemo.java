package com.maji.maojianwei.leetcode.tempWorkspace.set;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Class:
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/2/29 , 19:37
 */
public class SynchronizedCollectionsDemo {
    // 请求总数
    public static int clientTotal = 5000;

    // 同时并发执行的线程数
    public static int threadTotal = 200;

    private static List<Integer> list = Collections.synchronizedList(new ArrayList());
    private static Set<Integer> set = Collections.synchronizedSet(new HashSet());
    private static Map<Integer, Integer> map = Collections.synchronizedMap(new HashMap<>());

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            final int count = i;
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
        System.out.println("list size: " + list.size());
        System.out.println("set size: " + set.size());
        System.out.println("map size: " + map.size());
    }


    private static void update(int i) {
        list.add(i);
        set.add(i);
        map.put(i, i);
    }
}
