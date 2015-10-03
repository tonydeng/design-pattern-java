package com.github.tonydeng.desgin.singleton;

/**
 * Created by tonydeng on 15/10/3.
 */
public class SingletonLazy {
    private static SingletonLazy sc = null;

    private SingletonLazy(){}

    public static SingletonLazy getInstance(){
        if(sc == null){
            sc = new SingletonLazy();
        }
        return sc;
    }
}
