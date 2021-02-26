package com.github.tonydeng.desgin.dag;

import com.github.tonydeng.desgin.dag.util.Util;

import java.util.UUID;

public interface Actor {
    /**
     * 获取执行进程ID
     *
     * @return pid
     */
    UUID getPid();

    /**
     * 待实现的回调方法，用于执行receive的代码
     *
     * @param fromId 来自哪个pid
     * @param message 回调的消息
     */
    void receive(UUID fromId, Object message);

    /**
     * 获取开始时间（默认的实现是获取当前时间）
     *
     * @return 时间戳
     */
    default long getStartMilliSeconds() {
        return System.currentTimeMillis();
    }

    /**
     * 超时用于计算消息到达之前的等待时间。（默认值是-1，没有超时，它无限期地等待，直到收到消息）
     * 开始时间用于计算超时时间。
     *
     * @return
     */
    default long getTimeoutMilliSeconds() {
        return -1;
    }

    /**
     * 用于从发送方接收消息并计算超时时间.
     *
     * @param fromId
     * @param message
     */
    default void invoke(UUID fromId, Object message) {
        long to = getTimeoutMilliSeconds();
        if (to > 0 && Util.isTimedOut(getStartMilliSeconds(), to)) {
            //TODO: implement timeout message or indicator
            return;
        }
        receive(fromId, message);
    }

    default void register(String alias) {
        Pid.getInstance().register(alias, this);
    }

    default void send(UUID toId, Object message) {
        Pid.getInstance().send(toId, message, getPid());
    }

    default  void send(String toAlias, Object message) {
        Pid.getInstance().send(toAlias, message, getPid());
    }
}
