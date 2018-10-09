package com.renguangli.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * FileChannelExamples
 *
 * @author renguangli 2018/10/9 10:03
 * @since JDK 1.8
 */
public class FileChannelExamples {

    public static void main(String[] args) {
//        String s = readFile("D:/a.txt");
//        System.out.println(s);
//        writeFile("sdhaha哈哈f","D:/b.txt");
        copyFile("D:/a.pdf", "D:/b.pdf");
    }

    public static String readFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (FileInputStream fis = new FileInputStream(fileName);
             FileChannel fileChannel = fis.getChannel()) {

          /*  while (fileChannel.read(byteBuffer) != -1) {
                byteBuffer.flip(); // 切换读写状态
                while (byteBuffer.hasRemaining()) {
                    sb.append((char)byteBuffer.get());
                }
                byteBuffer.clear();
            }*/

            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            while (fileChannel.read(byteBuffer) != -1) {
                sb.append(new String(byteBuffer.array()));
                byteBuffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * nio 写文件
     */
    public static void writeFile(String content, String fileName) {
        try (FileOutputStream out = new FileOutputStream(fileName);FileChannel fileChannel = out.getChannel()) {
            // 编码
            ByteBuffer byteBuffer = StandardCharsets.UTF_8.encode(content);
            fileChannel.write(byteBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFile(String src, String dist) {
        try (FileInputStream fis = new FileInputStream(src);FileChannel fisChannel = fis.getChannel();
             FileOutputStream fos = new FileOutputStream(dist);FileChannel fosChannel = fos.getChannel()) {
            // 创建缓冲区
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            while (fisChannel.read(byteBuffer) != -1) {
                byteBuffer.flip();
                fosChannel.write(byteBuffer);
                byteBuffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
