package qrl.stream.file;

import org.junit.jupiter.api.Test;
import org.qrl.tools.util.file.FileTool;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @Author QR
 * @Date 2021/10/31 8:05 AM
 */
public class FileStream {

    @Test
    public void linesTest() {
        String resources = FileTool.getResourcesPath();
        long uniqueWords;
        try (Stream<String> lines = Files.lines(Paths.get(resources+ "/data.txt"), Charset.defaultCharset())){
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
            System.out.println(uniqueWords);
        } catch (IOException e) {
            System.out.println("文件打开失败");
            e.printStackTrace();
        }
    }
}
