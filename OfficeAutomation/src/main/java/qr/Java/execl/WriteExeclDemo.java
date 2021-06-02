package qr.Java.execl;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

public class WriteExeclDemo {

    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet employee = workbook.createSheet("employee");
        XSSFRow employeeRow0 = employee.createRow(0);
        employeeRow0.createCell(0).setCellValue("Id");
        employeeRow0.createCell(1).setCellValue("Name");
        employeeRow0.createCell(2).setCellValue("Salary");

        String url = Objects.requireNonNull(WriteExeclDemo.class.getClassLoader().getResource("JavaPOI.xlsx")).getPath();
        FileOutputStream out = new FileOutputStream(url);
        workbook.write(out);
        out.flush();
        workbook.close();
        System.out.println("写入成功");
    }
}
