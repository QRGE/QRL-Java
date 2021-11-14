package org.qrl.tools.util.file;

import java.io.File;

/**
 * File 工具类
 * @Author: QR
 * @Date: 2021/9/2-23:55
 */
public class FileTool {

    private final static String resourcesPath = "src/main/resources";

    /**
     * 获取当前项目根路径
     * @return 项目根路径
     */
    public static String getProjectPath(){
        return System.getProperty("user.dir");
    }

    /**
     * 获取 resources 路径, 源码中测试用
     * @return resource 路径
     */
    public static String getResourcesPath(){
        File file = new File(resourcesPath);
        return file.getAbsolutePath();
    }
}
