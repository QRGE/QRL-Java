package qr.basic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: QR
 * @Date: 2021/7/21-17:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private Integer age;
    private String name;
}
