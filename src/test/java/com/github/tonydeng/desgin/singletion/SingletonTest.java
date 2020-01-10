package com.github.tonydeng.desgin.singletion;

import com.github.tonydeng.desgin.BaseTest;
import com.github.tonydeng.desgin.singleton.*;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Sets;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by tonydeng on 15/10/3.
 */
public class SingletonTest extends BaseTest {
    private static final int THREAD_POOL_NUM=20;
    private static final int LOOP_NUM = 100000;
//    @Test
    public void testEnum() {
        SingletoneEnum.SingleEnum singleEnum = SingletoneEnum.SingleEnum.SINGLETION_ENUM;

        log.info("classname:'{}' single:'{}'", singleEnum.getClass().getSimpleName(), singleEnum);
    }

    @Test
    public void testEager() throws InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_NUM);
        Set<Integer> singles = Sets.newConcurrentHashSet();
        for (int i = 0; i < LOOP_NUM; i++) {
            int counter = i;

            executorService.submit(() -> {
                SingletonEager singletonLazy = SingletonEager.getInstance();
                singles.add(singletonLazy.hashCode());
//                log.info("get counter:{} singletonLazy hashcode:{}, instances:{}", counter,  singletonLazy.hashCode(), singles.size());
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

        stopwatch.stop();
        log.info("testEager run time:{} MILLISECONDS, single instances:'{}'",stopwatch.elapsed(TimeUnit.MILLISECONDS),singles.size());
    }

    @Test
    public void testLazy() throws InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_NUM);
        Set<Integer> singles = Sets.newConcurrentHashSet();
        for (int i = 0; i < LOOP_NUM; i++) {
            int counter = i;

            executorService.submit(() -> {
                SingletonLazy singletonLazy = SingletonLazy.getInstance();
                singles.add(singletonLazy.hashCode());
//                log.info("get counter:{} singletonLazy hashcode:{}, instances:{}", counter,  singletonLazy.hashCode(), singles.size());
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

        stopwatch.stop();
        log.info("testLazy run time:{} MILLISECONDS, single instances:'{}'",stopwatch.elapsed(TimeUnit.MILLISECONDS),singles.size());
    }

    @Test
    public void testLazyMultithread() throws InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_NUM);
        Set<Integer> singles = Sets.newConcurrentHashSet();
        for (int i = 0; i < LOOP_NUM; i++) {
            int counter = i;

            executorService.submit(() -> {
                SingletonLazyMultithreaded singletonLazy = SingletonLazyMultithreaded.getInstance();
                singles.add(singletonLazy.hashCode());
//                log.info("get counter:{} singletonLazy hashcode:{}, instances:{}", counter,  singletonLazy.hashCode(), singles.size());
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

        stopwatch.stop();
        log.info("testLazyMultithread run time:{} MILLISECONDS, single instances:'{}'",stopwatch.elapsed(TimeUnit.MILLISECONDS),singles.size());
    }


    @Test
    public void testLazyDoubleCheck() throws InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_NUM);
        Set<Integer> singles = Sets.newConcurrentHashSet();
        for (int i = 0; i < LOOP_NUM; i++) {
            int counter = i;

            executorService.submit(() -> {
                SingletonLazyDoubleCheck singletonLazy = SingletonLazyDoubleCheck.getInstance();
                singles.add(singletonLazy.hashCode());
//                log.info("get counter:{} singletonLazy hashcode:{}, instances:{}", counter,  singletonLazy.hashCode(), singles.size());
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

        stopwatch.stop();
        log.info("testLazyDoubleCheck run time:{} MILLISECONDS, single instances:'{}'",stopwatch.elapsed(TimeUnit.MILLISECONDS),singles.size());
    }

    @Test
    public void testSerial() throws InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_NUM);
        Set<Integer> singles = Sets.newConcurrentHashSet();
        for (int i = 0; i < LOOP_NUM; i++) {
            int counter = i;

            executorService.submit(() -> {
                SingletonSerial singletonLazy = SingletonSerial.getInstance();
                singles.add(singletonLazy.hashCode());
//                log.info("get counter:{} singletonLazy hashcode:{}, instances:{}", counter,  singletonLazy.hashCode(), singles.size());
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

        stopwatch.stop();
        log.info("testSerial run time:{} MILLISECONDS, single instances:'{}'",stopwatch.elapsed(TimeUnit.MILLISECONDS),singles.size());
    }

}
