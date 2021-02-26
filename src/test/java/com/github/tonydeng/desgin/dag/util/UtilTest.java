package com.github.tonydeng.desgin.dag.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Tony Deng
 * @version V1.0
 * @date 2021/2/25 17:41
 **/
@Slf4j
class UtilTest {

    @Test
    void testIsTimedOut() {
        assertFalse(Util.isTimedOut(System.currentTimeMillis(), 10));
    }

    @Test
    void testGetNowInSeconds() {
        assertNotNull(Util.getNowInSeconds());
        assertEquals(10, String.valueOf(Util.getNowInSeconds()).length());
    }

    @Test
    void testGetNowTimeUnit() {
        TimeUnit.values().stream().forEach(
                () -> {log.info("test");}
        );
    }
}
