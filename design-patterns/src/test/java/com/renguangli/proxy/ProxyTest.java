package com.renguangli.proxy;


import org.junit.Test;

import java.lang.reflect.Proxy;

public class ProxyTest {

    @Test
    public void staticProxyTest() {
        BuyCar buyCar = new BuyCarImpl();
        buyCar.buyCar();

        BuyCarProxy proxy = new BuyCarProxy(buyCar);
        proxy.buyCar();
    }

    @Test
    public void dynamicProxyTest() {
        BuyCarHandler handler = new BuyCarHandler(new BuyCarImpl());
        BuyCar buyCar = (BuyCar)Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{BuyCar.class}, handler);
        buyCar.buyCar();
    }

    @Test
    public void cglibProxyTest() {
        CglibBurCarProxy proxy = new CglibBurCarProxy();
        proxy.buyCar();
    }

}