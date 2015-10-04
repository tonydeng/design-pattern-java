package com.github.tonydeng.desgin.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * Created by tonydeng on 15/10/3.
 */
public class SingletonSerial implements Serializable {
    private  static final long serialVersionUID = 1l;

    private static SingletonSerial sc = new SingletonSerial();

    private SingletonSerial(){
        if(sc != null){
            throw new IllegalStateException("Already created.");
        }
    }

    public static SingletonSerial getInstance(){
        return sc;
    }

    private Object readReslove() throws ObjectStreamException{
        return sc;
    }

    private Object writeReplace() throws ObjectStreamException{
        return sc;
    }

    public  Object clone() throws CloneNotSupportedException{
        return new CloneNotSupportedException("Singletion, cannot be cloned");
    }

    private  static Class getClass(String className) throws ClassNotFoundException{
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if(classLoader == null){
            classLoader = SingletonSerial.class.getClassLoader();
        }

        return classLoader.loadClass(className);
    }
}
