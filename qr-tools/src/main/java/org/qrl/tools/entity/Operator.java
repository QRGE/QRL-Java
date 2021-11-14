package org.qrl.tools.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author qr
 * @date 2021/11/13 4:38 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operator {

    private String number;

    private String codeName;

    private String realName;

    private Integer gender;

    private Integer rarity;
}
