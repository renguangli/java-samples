package com.renguangli.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * CglibExamples
 *
 * @author renguangli 2018/10/18 10:57
 * @since JDK 1.8
 */
public class CglibBurCarProxy {

    public void buyCar() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(BuyCarImpl.class);
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            System.out.println("before buyCar method ");
            Object invoke = methodProxy.invokeSuper(o, objects);
            System.out.println("after buyCar method ");
            return invoke;
        });
        BuyCar buyCar = (BuyCarImpl)enhancer.create();
        buyCar.buyCar();
    }
}
