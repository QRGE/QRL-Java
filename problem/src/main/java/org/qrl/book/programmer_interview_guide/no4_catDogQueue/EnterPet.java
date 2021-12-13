package org.qrl.book.programmer_interview_guide.no4_catDogQueue;

import lombok.Getter;
import lombok.Setter;
import org.qrl.book.programmer_interview_guide.no4_catDogQueue.entity.Pet;

/**
 * @author qr
 * @date 2021/12/13 23:24
 */
@Getter
@Setter
public class EnterPet {

    private Pet pet;

    private int count;

    public EnterPet(Pet pet, int count) {
        this.pet = pet;
        this.count = count;
    }

    public String getPetType(){
        return this.pet.getType();
    }

}
