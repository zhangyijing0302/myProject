package com.myProject.company.xyxx;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 功能: 编写程序,在C盘根目录下创建文件myFile.txt，
 文件内容如下，请注意缩进和换行：
 Java
    C/C++
        Python
            JavaScripts
 */
public class CreateFile {

    public static void main(String[] args) {
        // C盘根目录不知道为啥不能创建文件 多包了一层目录（这个目录是手动创建的）
        String filePath = "C:/target/target.txt";
        String fileText = "Java\r\n\tC/C++\r\n\t\tPython\r\n\t\t\tJavaScripts";
        FileWriter fw = null;
        try{
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(filePath);
            fw.write(fileText);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
