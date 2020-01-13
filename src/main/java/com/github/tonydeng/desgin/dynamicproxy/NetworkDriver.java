package com.github.tonydeng.desgin.dynamicproxy;

/**
 * 网络驱动器
 *
 * @author Tony Deng
 * @date 2020/1/11 00:00
 **/
public class NetworkDriver implements Driver {
    /**
     * 获取类型
     *
     * @return
     */
    @Override
    public String getType() {
        return "Network";
    }

    public String GetIp() {
        return "10.0.0.1";
    }
}
