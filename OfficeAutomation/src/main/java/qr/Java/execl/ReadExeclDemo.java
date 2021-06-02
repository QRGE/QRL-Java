package qr.Java.execl;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class ReadExeclDemo {

    public static void main(String[] args){
        InputStream inputStream;
        XSSFWorkbook workbook = null;
        try {
            inputStream = ReadExeclDemo.class.getResourceAsStream("JavaPOI.xlsx");
            assert inputStream != null;

            workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            XSSFRow row = sheet.getRow(0);
            for (Cell cell : row) {
                System.out.println(cell);
            }
            System.out.println(Arrays.toString(sheet.getColumnBreaks()));

            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
