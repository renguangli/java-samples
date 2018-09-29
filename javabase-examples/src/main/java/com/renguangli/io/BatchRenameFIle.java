package com.renguangli.io;

import java.io.File;

/**
 * BatchRenameFIle
 *
 * @author renguangli 2018/8/20 16:30
 * @since JDK 1.8
 */
public class BatchRenameFIle {

    public static void main(String[] args) {
        String path = args[0];
        File dir = new File(path);
        File[] files = dir.listFiles();
        assert files != null;
        for (int i = 1; i <= files.length; i++) {
            files[i].renameTo(new File(path + File.separator + i + ".png"));
        }
    }

}
