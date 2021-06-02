import org.junit.Test;
import qr.Java.IO.Utils.FileUtils;

public class FileCopyTest {

    @Test
    public void fileCopyTest(){
        FileUtils.copy("D:\\Note.txt", "D:\\Note-copy.txt");
    }

    @Test
    public void BufferedFileCopyTest(){
        FileUtils.copy("D:\\Note.txt", "D:\\Note-bufferedCopy.txt");
    }
}
