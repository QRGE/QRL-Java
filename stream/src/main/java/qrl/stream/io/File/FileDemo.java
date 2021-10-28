package qrl.stream.io.File;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FileDemo {

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\file.txt");
        if (!file.exists()){
            boolean result = file.createNewFile();
            System.out.println("创建结果: " + result);
        }else {
            System.out.println("文件已经存在...");
        }

        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("Are you OK?");
        fileWriter.close();

        // String getAbsolutePath()
        System.out.println("File absolutePath: " + file.getAbsolutePath());

        // String getPath()
        System.out.println("Path: " + file.getPath());

        // String getName(): get fileName
        System.out.println("FileName: " + file.getName());

        // String getParent()
        System.out.println("ParentPath: " + file.getParent());

        // long length()
        System.out.println("File length: " + file.length() + " Byte");

        // long lastModified()
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String lastModifiedTime = sdf.format(new Date(file.lastModified()));
        System.out.println("File last modified time: " + lastModifiedTime);

        // boolean canWrite()
        System.out.println("Can write: " + file.canWrite());

        // boolean isFile()
        System.out.println("Is file: " + file.isFile());

        // boolean isHidden()
        System.out.println("Is hidden: " + file.isHidden());

        // file.delete();
        // 在JVM退出时删除文件
        file.deleteOnExit();
    }

    public static void separator(){
        System.out.println("路径分隔符: " + File.pathSeparator);
        System.out.println("文件分隔符: " + File.separator);
    }
}
