package com.renguangli.io_nio_bio.io;

import java.io.File;
import java.io.IOException;
import java.net.URI;

/**
 * FileExamples
 *
 * @author renguangli 2018/10/18 16:57
 * @since JDK 1.8
 */
public class FileExamples {


    public static void main(String[] args) throws IOException {
        useFile();
//        listFiles(new File("E:"));
    }

    public static void useFile() throws IOException {
        // 表示一个文件在内存中还未持久化到磁盘
        File file = new File("E:/a.txt");
        if (!file.exists()) {
            // 新建文件
            boolean newFile = file.createNewFile();
            System.out.println("newFile : " +newFile);
            File[] files = file.listFiles();
            System.out.println(files);
        }
        // 删除文件或目录
        boolean delete = file.delete();
        System.out.println("delete: " + delete);
        String name = file.getName();// 获取文件名
        long length = file.length();// 获取文件大小
        String[] list = file.list();
        URI uri = file.toURI();

        // 表示一个目录在内存中还未持久化到磁盘
        File dir = new File("E:/a/b/c");
        if (!dir.exists()) {
            // 创建一级目录，父目录不存在创建失败,不会抛异常
            boolean mkdir = dir.mkdir();
            System.out.println("mkdir : " + mkdir);

            // 如果父目录不存在，自动创建父目录
            boolean mkdirs = dir.mkdirs();
            System.out.println("mkdirs : " + mkdirs);
        }
    }

    public static void listFiles(String filePath) {
        listFiles(new File(filePath));
    }

    // 列出目录下的所有文件
    public static void listFiles(File file) {
        if (file == null || !file.exists()) return;

        if (file.isFile()) {
            System.out.println(file.getName());
            return;
        }

        for (File file1 : file.listFiles()) {
            listFiles(file1);
        }
    }

}
