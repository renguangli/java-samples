package com.renguangli.reflect_annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * javabase-examples
 * Created by renguangli at 2019/3/18 17:29
 *
 * @since JDK1.8
 */
@Value("haha")
class ClassExamples {

    public ClassExamples() {
        System.out.println("init");
    }

    private static final int ANNOTATION= 0x00002000;
    private static final int ENUM      = 0x00004000;
    private static final int SYNTHETIC = 0x00001000;

    private static int ctlOf(int rs, int wc) { return rs | wc; }

    private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;

    // -3
    // 1000 0011
    // 0111 1100


    // 2
    // 0000 0010
    // 1111 1101
    // 1111 1100
    //
    // 0111 1100
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<Test> clazz = Test.class;
        // 获取该类的全限定类名
        String clazzName = clazz.getName();
        System.out.println(clazzName);
        // 获取该类的类名
        String simpleName = clazz.getSimpleName();
        System.out.println(simpleName);


        // 返回该类上的注解
        Annotation[] annotations = clazz.getAnnotations();
        System.out.println(Arrays.toString(annotations));
        // 返回该类上指定的注解
        Value annotation = clazz.getAnnotation(Value.class);
        System.out.println(annotation.value());

        // 创建对象，会调用无参构造器
        try {
            Test Test = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // getFileds(clazz);

        // 获取 访问权限为 public 的方法， 包括从父类继承的方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        Test test = new Test();
        //  获取指定访问权限为 public 的方法
        Method setName = clazz.getMethod("setName", String.class);
        setName.setAccessible(true);
        System.out.println(test.name);
        setName.invoke(test, "name");
        System.out.println(test.name);


    }

    private static void getFileds(Class<Test> clazz) throws NoSuchFieldException, IllegalAccessException {
        // 获取 访问权限为 public 的成员变量
        Field[] fields = clazz.getFields();
        System.out.println(Arrays.toString(fields));
        //获取指定访问权限为 public 的成员变量
        Field name2 = clazz.getField("name2");
        System.out.println(name2);

        // 获取所有变量，包括静态变量
        Field[] declaredFields = clazz.getDeclaredFields();
        System.out.println(Arrays.toString(declaredFields));
        Field name = clazz.getDeclaredField("name");
        boolean accessible = name.isAccessible();
        System.out.println(accessible);
        name.setAccessible(true);
        System.out.println(name.isAccessible());
        Test test = new Test();
        System.out.println(test.name);
        name.set(test, "haha");
        System.out.println(name.get(test));
    }

    /**
     * 获取 Class 对象的 4 种方法
     */
    private static Class<Test> getClassExamples() {
        // 类名.class
        Class<Test> clazz = Test.class;
        System.out.println(clazz.getModifiers());
        // 对象.getClass
        Test test = new Test();
        Class<? extends Test> clazz1 = test.getClass();

        try {
            // Class.forName
            Class<?> clazz2 = Class.forName("com.renguangli.reflect_annotation.Test");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 包装类型.TYPE
        Class<Integer> type3 = Integer.TYPE;
        return clazz;
    }

    private class A{}
}
