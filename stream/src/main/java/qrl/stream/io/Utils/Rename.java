package qrl.stream.io.Utils;

import java.io.File;

/**
 * @Author: QR
 * @Date: 2021/9/1-17:44
 */
public class Rename {

    static String newString = "";//新字符串,如果是去掉前缀后缀就留空，否则写上需要替换的字符串
    static String dir = "D:\\picture";//文件所在路径，所有文件的根目录，记得修改为你电脑上的文件所在路径

    public static void main(String[] args) {
        renameFile();
    }

    public static void renameFile() {
        File folder = new File("D:\\picture");
        File[] files = folder.listFiles();
        for (File file : files) {
            String[] strings = file.getPath().split("\\.");
            String name = strings[0];
            String newName = name + ".jpg";
            file.renameTo(new File(newName));
        }
    }
}
