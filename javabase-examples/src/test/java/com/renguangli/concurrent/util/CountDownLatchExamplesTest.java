package com.renguangli.concurrent.util;


import org.junit.Test;

/*
 *
 * Created by renguangli at 2018/10/21 15:27
 * @since JDK1.8
 */
public class CountDownLatchExamplesTest {

    private CountDownLatchExamples examples = new CountDownLatchExamples();

    @Test
    public void waitOtherThreads() {
        examples.waitOtherThreads();
    }

    @Test
    public void concurrent() {
        examples.concurrent();
    }

}
