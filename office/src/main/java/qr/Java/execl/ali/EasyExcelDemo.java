package qr.Java.execl.ali;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import qr.Java.execl.ali.entity.bean.DataBean;

public class EasyExcelDemo {

    public static void main(String[] args) {
        String filename = "/Users/qr/Desktop/data.xlsx";
        EasyExcel.read(filename, DataBean.class, new PageReadListener<DataBean>(dataList->{
            for (DataBean dataBean : dataList) {
                System.out.println(dataBean);
            }
        })).sheet().doRead();
    }
}
