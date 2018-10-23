package com.renguangli.abstract_interface;

/**
 *  1.abstract修饰的类为抽象类
 *  2.有抽象方法的类为抽象类
 *  3.普通类继承抽象类必须实现所有抽象方法
 *
 * @author renguangli 2018/9/19 16:35
 * @since JDK 1.8
 */
public abstract class AbstractExamples extends Thread{

    // 抽象类不能被实例化
    //private AbstractExamples abstractExample = new AbstractExamples();

    // 抽象类可以有成员变量
    private String name;

    // 抽象类可以有构造方法
    public AbstractExamples() {}

    // 抽象类可以有普通方法
    public void show(){}

    // 抽象方法，默认 public访问修饰符
    abstract void showTime();

}

/**
 * 普通类继承抽象类必须实现抽象类所有抽象方法，除非是抽象类
 */
class DefaultAbstractExamples extends AbstractExamples {

    @Override
    void showTime() {
        this.run();
    }

}