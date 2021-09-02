import org.junit.Test;
import qrl.io.Utils.FileUtils;

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
