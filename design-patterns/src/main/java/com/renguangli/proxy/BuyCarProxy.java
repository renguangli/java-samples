package com.renguangli.proxy;

public class BuyCarProxy implements BuyCar {

    private BuyCar target;

    public BuyCarProxy(BuyCar target) {
        this.target = target;
    }

    @Override
    public void buyCar() {
        System.out.println("买车前，期待中。。。");
        this.target.buyCar();
        System.out.println("买成后，兴奋中。。。");
    }
}
