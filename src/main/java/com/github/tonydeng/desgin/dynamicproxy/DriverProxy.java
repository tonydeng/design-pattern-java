package com.github.tonydeng.desgin.dynamicproxy;

import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Tony Deng
 * @version V1.0
 * @date 2020/1/11 00:04
 **/
@Slf4j(topic = "DriverProxy")
public class DriverProxy {

    public <X extends Driver> X iface(Class<X> clazz, Target target) {
        ProxyFactory factory = new ProxyFactory();
        factory.setSuperclass(clazz);

        Set<String> methods = getInterfaceMethodNames(clazz);

        factory.setFilter(
                m -> methods.contains(m.getName())
        );
        try {
            X x = (X) factory.create(new Class[]{Target.class}, new Object[]{target});

            ((ProxyObject) x).setHandler((self, thisMethod, proceed, args) -> {
                try {
                    Object result = proceed.invoke(self, args);
                    return result;
                } finally {
                    log.info("set handler......");
                }

            });
            return x;
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("fail to create proxy.", e);
        }

    }

    private static Set<String> getInterfaceMethodNames(Class<?> clazz) {
        log.debug("get interfaceMethodNames:'{}' interfaces: '{}'", clazz, clazz.getInterfaces().length);

        return Stream.of(clazz.getInterfaces())
                .flatMap(c -> Stream.of(c.getMethods()))
                .map(Method::getName)
                .collect(Collectors.toSet());
    }
}
