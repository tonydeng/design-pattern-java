package com.github.tonydeng.desgin.dynamicproxy;

/**
 * @author dengtao
 */
public interface Driver {
    /**
     * 获取驱动目标
     *
     * @return
     */
    Target getTarget();

    /**
     * 获取类型
     *
     * @return
     */
    String getType();

//    /**
//     * 返回名称
//     *
//     * @return
//     */
//    default String getName() {
//        return this.getClass().getSimpleName();
//    }
}
