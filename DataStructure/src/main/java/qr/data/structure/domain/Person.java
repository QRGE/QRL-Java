package qr.data.structure.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: QR
 * @Date: 2021/7/5-15:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    Integer id;
    Integer age;
    String name;
}
