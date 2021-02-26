package com.github.tonydeng.desgin.dag;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Tony Deng
 * @version V1.0
 * @date 2021/2/25 17:43
 **/
public class Pid {
    private Map<String, UUID> pidMap = new ConcurrentHashMap<>();
    private Map<UUID, Actor> actors = new ConcurrentHashMap<>();

    /**
     * Private constructor.
     */
    private Pid() {
    }

    /**
     * 线程安全的单例.
     *
     * @return pid
     */
    public static Pid getInstance() {
        return Loader.instance;
    }

    /**
     * Java内存模型保证了类的初始化
     */
    private static class Loader {
        private static final Pid instance = new Pid();
    }

    public void register(final String alias, final Actor actor) {
        if (null == pidMap.putIfAbsent(alias, actor.getPid())) {
            register(actor);
        }
    }

    public void register(final Actor actor) {
        actors.putIfAbsent(actor.getPid(), actor);
    }

    public UUID getPid(final String alias) {
        return pidMap.get(alias);
    }

    public void send(final UUID toId, final Object message, final UUID fromId) {
        new Thread(() -> this.actors.get(toId).invoke(fromId, message)).start();
    }

    public void send(final String alias, final Object message, final UUID fromId) {
        Optional.of(getPid(alias)).ifPresent(uuid -> send(uuid, message, fromId));
    }

    public int getActorSize() {
        return this.actors.size();
    }
}
