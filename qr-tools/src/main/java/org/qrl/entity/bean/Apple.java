package org.qrl.entity.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @Author QR
 * @Date 2021/11/3 7:12 PM
 */
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Apple {
    Integer id;
    Double weight;
    Double price;
    String type;
}
