package com.github.tonydeng.desgin.dynamicproxy;

/**
 * 网络驱动器
 *
 * @author Tony Deng
 * @date 2020/1/11 00:00
 **/
public class NetworkDriver implements Driver {
    private Target target;

    public NetworkDriver(Target target) {
        this.target = target;
    }

    @Override
    public Target getTarget() {
        return target;
    }

    /**
     * 获取类型
     *
     * @return
     */
    @Override
    public String getType() {
        return target.getName();
    }

    public String GetIp() {
        return "10.0.0.1";
    }
}
