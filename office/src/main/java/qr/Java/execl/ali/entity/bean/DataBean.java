package qr.Java.execl.ali.entity.bean;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class DataBean {

    /**
     * id
     */
    // @ExcelProperty 的 index 属性不要和 value 混用, 个人比较习惯用 index
    @ExcelProperty(index = 0)
    private Integer id;

    /**
     * 性别
     */
    @ExcelProperty(index = 1)
    private String sex;

    /**
     * 姓名
     */
    @ExcelProperty(index = 2)
    private String name;
}
