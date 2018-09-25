package com.renguangli.interesting;

/**
 * ThreadMXBeanExamples
 *
 * @author renguangli 2018/9/11 15:17
 * @since JDK 1.8
 */
public class ThreadMXBeanExamples {

    public static void main(String[] args) {
        // 获取 java 线程管理MXBean
    /*    ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            System.err.println(threadInfo.getThreadId() + " " + threadInfo.getThreadName());
        }*/
        new B(("s"));
    }
}
