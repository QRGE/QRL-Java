package org.qrl.book.programmer_interview_guide.no4_catDogQueue.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author qr
 * @date 2021/12/13 23:07
 */
@Getter
@Setter
@ToString
public class Pet {

    private String type;

    public Pet(String type) {
        this.type = type;
    }
}
