package org.qrl.stream.io.oio.file;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DirectoryDemo {

    public static void main(String[] args) {
        String dirName = "D:\\MyDirectory\\A\\B";
        File dir = new File(dirName);
        if (!dir.exists()){
            // mkdir(): 只能创建单级目录, 尝试用mkdir()创建一个多级目录, 运行后代码不会报错, 但是无法创建
            // mkdirs(): 创建多级目录 D:\\A\\B\\C
            dir.mkdirs();
            System.out.println("Create directory: " + dirName);
        }else {
            System.out.println(dirName + " already exists...");
        }

        System.out.println("Get absolutePath: " + dir.getAbsolutePath());

        // 你创建dir时传入的参数名
        System.out.println("Get Path:" + dir.getPath());

        // 最底层的目录名字
        System.out.println("Get directory path: " + dir.getName());

        System.out.println("Parent path: " + dir.getParent());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dirCreateTime = sdf.format(new Date(dir.lastModified()));
        System.out.println("Create time: " + dirCreateTime);

        System.out.println("Is directory: " + dir.isDirectory());
        System.out.println("Is file: " + dir.isFile());

        System.out.println("Is hidden: " + dir.isHidden());

        // String[] list() 遍历文件夹子层中的所有内容, 返回内容的名字数组
        String[] files = dir.list();
        assert files != null;
        for (String file : files) {
            System.out.println(file);
        }

        // 如果指定的目录中有其他目录或文件则无法删除, 如果删除一个有子目录或文件的目录, jvm不会报错, 但是无法删除
        dir.delete();
    }
}
