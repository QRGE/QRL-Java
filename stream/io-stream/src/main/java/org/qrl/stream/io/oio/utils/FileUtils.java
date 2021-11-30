package org.qrl.stream.io.oio.utils;

import java.io.*;
import java.util.Objects;

public class FileUtils {



    public static String getFile(String fileName){
        return Objects.requireNonNull(FileUtils.class.getClassLoader().getResource(fileName)).getFile();
    }

    public static void copy(String source, String target){
        try {
            FileInputStream fis = new FileInputStream(source);
            FileOutputStream fos = new FileOutputStream(target);
            byte[] buf = new byte[1024];
            int count;
            while ((count = fis.read(buf)) != -1){
                fos.write(buf, 0, count);
            }
            // 注意顺序, 先关闭fis将流中的信息全部写进buf中, 再关闭fos
            fis.close();
            fos.close();
            System.out.println("Done");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + source);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void BufferedCopy(String source, String target){
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(target));
            int count;
            byte[] buf = new byte[1024];
            while ((count = bis.read()) != -1){
                bos.write(buf, 0, count);
            }
            bis.close();
            bos.close();
            System.out.println("Done");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + source);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something wrong...");
        }
    }
}
