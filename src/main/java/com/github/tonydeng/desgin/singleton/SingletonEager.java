package com.github.tonydeng.desgin.singleton;

/**
 * Created by tonydeng on 15/10/3.
 */
public class SingletonEager {
    private static SingletonEager sc = new SingletonEager();

    private SingletonEager(){}

    public static SingletonEager getInstance(){
        return sc;
    }
}
