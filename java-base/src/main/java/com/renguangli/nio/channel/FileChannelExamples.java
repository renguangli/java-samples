package com.renguangli.nio.channel;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * FileChannelExamples
 *
 * @author renguangli 2018/6/22 10:07
 * @since JDK 1.8
 */
public class FileChannelExamples {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        RandomAccessFile file = new RandomAccessFile("D:a.txt", "rw");
        FileChannel fileChannel = file.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (fileChannel.read(byteBuffer) != -1) {
            //切换为读状态,默认写状态
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                System.out.println("--------------");
                sb.append(byteBuffer.getChar());
            }
            byteBuffer.clear();
        }
        file.close();
        fileChannel.close();
        System.out.println(sb);

    }
}
