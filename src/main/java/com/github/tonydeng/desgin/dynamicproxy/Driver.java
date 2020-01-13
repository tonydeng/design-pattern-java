package com.github.tonydeng.desgin.dynamicproxy;

public interface Driver {
    /**
     * 获取类型
     *
     * @return
     */
    String getType();

    /**
     * 返回名称
     *
     * @return
     */
    default String getName() {
        return this.getClass().getSimpleName();
    }
}
