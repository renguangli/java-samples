package com.renguangli.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * JVMParamsExamples
 *
 * @author renguangli 2018/9/21 17:35
 * @since JDK 1.8
 */
public class JVMParamsExamples {
    public static void main(String[] args) {
        List<byte[]> b = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            b.add(new byte[1024 * 1024]);
        }
    }
}
