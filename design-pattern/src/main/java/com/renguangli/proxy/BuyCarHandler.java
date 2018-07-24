package com.renguangli.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class BuyCarHandler implements InvocationHandler {

    private Object target;

    public BuyCarHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("买车前，期待中。。。");
        Object invoke = method.invoke(target, args);
        System.out.println("买成后，兴奋中。。。");
        return invoke;
    }

}
