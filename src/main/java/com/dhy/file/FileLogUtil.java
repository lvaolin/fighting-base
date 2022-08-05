package com.dhy.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Project fighting-core
 * @Description 主要用途描述
 * @Author lvaolin
 * @Date 2022/8/5 下午2:15
 */
public class FileLogUtil {

    public static void main(String[] args) throws IOException {

        File file = new File("/Users/lvaolin/Downloads/1.txt");
        if (!file.exists()) {
            //file.createNewFile();
        }
        FileOutputStream outputStream = new FileOutputStream(file,true);
        outputStream.write("aaaaaaaa".getBytes());
        outputStream.write('\n');
        outputStream.close();
    }
}
