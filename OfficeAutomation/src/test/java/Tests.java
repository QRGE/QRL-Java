import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import qr.Java.execl.WriteExeclDemo;

import java.io.IOException;
import java.io.InputStream;

public class Tests {

    @Test
    public void getResource() throws IOException, InvalidFormatException {
        InputStream inputStream = WriteExeclDemo.class.getResourceAsStream("/JavaPOI.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        System.out.println(workbook.getSheetAt(0).getRow(0).getCell(0));
    }
}
