package com.github.tonydeng.desgin.singleton;

/**
 * Created by tonydeng on 15/10/3.
 */
public class SingletonLazyMultithreaded {
    private static SingletonLazyMultithreaded sc = null;

    public static synchronized SingletonLazyMultithreaded getInstance(){
        if(sc == null){
            sc = new SingletonLazyMultithreaded();
        }
        return sc;
    }
}
