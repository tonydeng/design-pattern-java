package com.github.tonydeng.desgin.dag.util;

import lombok.extern.slf4j.Slf4j;

import java.lang.management.ManagementFactory;
import java.util.concurrent.TimeUnit;

/**
 * @author Tony Deng
 * @version V1.0
 * @date 2021/2/25 17:37
 **/
@Slf4j
public class Util {
    /**
     * 检查操作是否超时。
     *
     * @param start   开始时间
     * @param timeout 超时间隔
     * @return 是否超时
     */
    public static boolean isTimedOut(long start, long timeout) {
        return (getNowInSeconds() - start) > timeout;
    }

    /**
     * 以秒为单位返回当前时间.
     *
     * @return 当前时间戳
     */
    public static long getNowInSeconds() {
        return getNowTimeUnit(TimeUnit.SECONDS);
    }

    /**
     * 获取指定时间单位的当前时间.
     *
     * @param timeunit
     * @return
     */
    public static long getNowTimeUnit(TimeUnit timeunit) {
        switch (timeunit) {
            case NANOSECONDS:
                return TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
            case MICROSECONDS:
                return TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
            case MILLISECONDS:
                return TimeUnit.MILLISECONDS.toMillis(System.currentTimeMillis());
            //default is seconds
            case SECONDS:
            default:
                return TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
            case MINUTES:
                return TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis());
            case HOURS:
                return TimeUnit.MILLISECONDS.toHours(System.currentTimeMillis());
            case DAYS:
                return TimeUnit.MILLISECONDS.toDays(System.currentTimeMillis());
        }
    }

    /**
     * 睡眠时间(以秒为单位).
     *
     * @param seconds
     */
    public static void sleepSeconds(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            log.error("sleep {} seconds error", seconds);
        }
    }

    /**
     * 睡眠时间(以毫秒为单位)..
     *
     * @param milliseconds
     */
    public static void sleepMilliseconds(long milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            log.error("sleep {} milliseconds error", milliseconds);
        }
    }

    /**
     * 获取当前运行的Java运行Pid。(警告:只支持Linux，其他platform不可知)
     *
     * @return the pid in String.
     */
    public static String getPid() {
        return ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
    }

    /**
     * 获取给定初始开始时间和超时秒的剩余超时.
     *
     * @param allocTimeout
     * @param start
     * @return
     */
    public static long getRemainingTimeout(long allocTimeout, long start) {
        return start + allocTimeout - getNowInSeconds();
    }
}
