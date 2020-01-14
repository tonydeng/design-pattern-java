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
        log.info("{}", new DiskDriver(new Target()).getType());
        log.info("{}", new NetworkDriver(new Target()).getType());
    }

    @Test
    void testNetwork() {
        DriverProxy proxy = new DriverProxy();
        Target target = new Target("Network");
        NetworkDriver driver = proxy.iface(NetworkDriver.class, target);
        log.info("{} {}", driver.getClass().getName(), driver.getClass().getSimpleName());

        proxy.iface(NetworkDriver.class, target);
        proxy.iface(NetworkDriver.class, target);

        proxy.iface(DiskDriver.class,new Target("Disk"));
        proxy.iface(DiskDriver.class,new Target("Disk"));
        proxy.iface(DiskDriver.class,new Target("Disk"));
    }
}
