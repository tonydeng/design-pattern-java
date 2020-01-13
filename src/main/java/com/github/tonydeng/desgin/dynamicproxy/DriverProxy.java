package com.github.tonydeng.desgin.dynamicproxy;

import com.google.common.collect.Maps;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Tony Deng
 * @version V1.0
 * @date 2020/1/11 00:04
 **/
@Slf4j
public class DriverProxy {
    private static Map<Class<?>, Set<String>> interfaceMethodCache = Maps.newConcurrentMap();

    public <X extends Driver> X iface(Class<X> ifaceClass) {
        ProxyFactory factory = new ProxyFactory();
        factory.setSuperclass(ifaceClass);

        factory.setFilter(
                m -> getInterfaceMethodNames(ifaceClass).contains(m.getName())
        );
//        MethodHandler mi = (self, m, proceed, args) -> {
//            log.info("Name: {}", m.getName());
//            return proceed.invoke(self, args);  // execute the original method.
//        };
        X x = null;
        try {
            x = (X) factory.create(new Class[]{Driver.class},new Object[]{});
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            log.error("{}", e);
        }

//        ((ProxyObject) x).setHandler(
//                (self, thisMethod, proceed, args)
//                        -> proceed.invoke(self, args)
//        );

        return x;
    }

    private static Set<String> getInterfaceMethodNames(Class<?> ifaceClass) {
        return interfaceMethodCache.computeIfAbsent(
                ifaceClass,
                i -> Stream.of(i.getInterfaces())
                        .flatMap(c -> Stream.of(c.getMethods()))
                        .map(Method::getName)
                        .collect(Collectors.toSet())
        );
    }
}
