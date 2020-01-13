package com.github.tonydeng.desgin.dynamicproxy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author Tony Deng
 * @date 2020/1/10 23:56
 **/
@Slf4j
public class DriverTest {
    @Test
    void testGetName() {
        log.info("{}", new DiskDriver().getName());
        log.info("{}", new NetworkDriver().getName());
    }

    @Test
    void testNetwork() {
        log.info("{}", new DriverProxy().iface(NetworkDriver.class).GetIp());
    }
}
