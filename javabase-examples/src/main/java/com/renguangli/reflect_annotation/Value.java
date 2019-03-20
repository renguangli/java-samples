package com.renguangli.reflect_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * javabase-examples
 * Created by renguangli at 2019/3/18 17:48
 *
 * @since JDK1.8
 */
@Target({
        ElementType.PACKAGE, // 包
        ElementType.TYPE, // 类
        ElementType.ANNOTATION_TYPE, // 注解
        ElementType.METHOD, // 方法
        ElementType.PARAMETER, // 方法参数
        ElementType.FIELD, // 字段/常量
        ElementType.LOCAL_VARIABLE, // 局部变量
        ElementType.TYPE_USE // 注解上
})
@Retention(RetentionPolicy.RUNTIME) // RetentionPolicy.RUNTIME RetentionPolicy.SOURCE RetentionPolicy.CLASS
public @interface Value {
    String value() default "";
}
