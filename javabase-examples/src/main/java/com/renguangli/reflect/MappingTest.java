package com.renguangli.reflect;

/**
 * MappingTest
 *
 * @author renguangli 2018/9/3 19:49
 * @since JDK 1.8
 */
public class MappingTest {

    public static void main(String[] args) {
        Class<TestController> testController = TestController.class;
        Mapping annotation = testController.getAnnotation(Mapping.class);
        String method = annotation.method();
        System.out.println("method = " + method);
        String value = annotation.value();
        System.out.println("value = " + value);
    }
}
