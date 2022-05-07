package org.qrl.basic.obj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author qr
 * @Date 2022/5/7-10:33
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Operator implements Cloneable, Serializable {

    private Integer id;

    private String name;

    @Override
    public Operator clone() {
        try {
            Operator clone = (Operator) super.clone();
            clone.setId(this.id);
            clone.setName(this.name);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
