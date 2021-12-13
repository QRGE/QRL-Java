package org.qrl.book.programmer_interview_guide.no4_catDogQueue;

import org.qrl.book.programmer_interview_guide.no4_catDogQueue.entity.Cat;
import org.qrl.book.programmer_interview_guide.no4_catDogQueue.entity.Dog;
import org.qrl.book.programmer_interview_guide.no4_catDogQueue.entity.Pet;
import org.qrl.exception.QRException;
import qr.data.structure.list.LinkedList.QRLinkedList;

import java.util.Objects;

/**
 * @author qr
 * @date 2021/12/13 23:09
 */
@SuppressWarnings("unused")
public class CatDogQueue {

    private final QRLinkedList<EnterPet> dogQueue = new QRLinkedList<>();

    private final QRLinkedList<EnterPet> catQueue = new QRLinkedList<>();

    /**
     * 入队的 pet 都有自己的 count 可以找到
     */
    private int count = 0;

    public Pet add(Pet pet) {
        if (pet.getType().equals("cat")) {
            catQueue.add(new EnterPet(pet, count++));
        }else if (pet.getType().equals("dog")) {
            dogQueue.add(new EnterPet(pet, count++));
        }else {
            throw new IllegalArgumentException("not cat or dog!");
        }
        return null;
    }

    public Pet pullCat() {
        if (catQueue.isEmpty()) {
            throw new QRException("catQueue is Empty");
        }
        return catQueue.poll().getPet();
    }

    public Pet pullDog() {
        if (dogQueue.isEmpty()) {
            throw new QRException("dogQueue is Empty");
        }
        return dogQueue.poll().getPet();
    }

    public Pet pullAll() {
        if (dogQueue.isNotEmpty() && catQueue.isNotEmpty()) {
            EnterPet dog = dogQueue.poll();
            EnterPet cat = catQueue.poll();
            assert dog != null;
            assert cat != null;
            int dogCount = dog.getCount();
            int catCount = cat.getCount();
            if (dogCount > catCount) {
                return cat.getPet();
            }else {
                return dog.getPet();
            }
        }else if (dogQueue.isNotEmpty()) {
            return Objects.requireNonNull(dogQueue.poll()).getPet();
        }else if (catQueue.isNotEmpty()) {
            return Objects.requireNonNull(catQueue.poll()).getPet();
        }else {
            throw new QRException("catQueue and dogQueue are both empty!");
        }
    }

    public boolean isEmpty() {
        return dogQueue.isEmpty() && catQueue.isEmpty();
    }

    public boolean isDogEmpty() {
        return dogQueue.isEmpty();
    }

    public boolean isCatEmpty() {
        return catQueue.isEmpty();
    }
}
