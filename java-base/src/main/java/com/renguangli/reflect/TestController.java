package com.renguangli.reflect;

/**
 * TestController
 *
 * @author renguangli 2018/9/3 19:50
 * @since JDK 1.8
 */
@Mapping(value = "/index", method = "POST")
public class TestController {

    @Mapping(value = "/test", method = "GET")
    public TestController() {

    }
}
