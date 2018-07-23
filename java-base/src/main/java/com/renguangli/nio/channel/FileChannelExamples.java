package com.renguangli.nio.channel;

import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * FileChannelExamples
 *
 * @author renguangli 2018/6/22 10:07
 * @since JDK 1.8
 */
public class FileChannelExamples {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        RandomAccessFile file = new RandomAccessFile("D:/data/nio-data.txt", "rw");
        FileChannel fileChannel = file.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(64);
        while (fileChannel.read(byteBuffer) != -1) {
            //切换为读状态,默认写状态
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                sb.append((char)byteBuffer.getChar());
            }
            byteBuffer.clear();
        }
        file.close();
        System.out.println(sb);

        Path path = Paths.get("d:/data");
        System.out.println(path.getFileName());
        System.out.println(path.getFileSystem());
        System.out.println(path.getNameCount());
        System.out.println(path.getRoot());
    }
}
