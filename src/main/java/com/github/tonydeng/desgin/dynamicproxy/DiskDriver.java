package com.github.tonydeng.desgin.dynamicproxy;

import lombok.extern.slf4j.Slf4j;

/**
 * 磁盘驱动器
 *
 * @author Tony Deng
 * @date 2020/1/10 23:58
 **/
@Slf4j
public class DiskDriver implements Driver {
    @Override
    public String getType() {
        log.info("get disk driver type......");
        return "Disk";
    }

    /**
     * 获取磁盘大小
     *
     * @return
     */
    public int getSize() {
        return 10;
    }
}
