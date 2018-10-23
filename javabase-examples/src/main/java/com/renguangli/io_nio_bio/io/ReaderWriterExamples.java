package com.renguangli.io_nio_bio.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * ReaderWriterExamples
 *
 * @author renguangli 2018/10/18 18:58
 * @since JDK 1.8
 */
public class ReaderWriterExamples {

    public static void main(String[] args) {
        read("E:/a.txt");
    }


    public static void read(String filePath) {

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader);) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
