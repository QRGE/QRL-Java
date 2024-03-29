package qr.data.structure.domain;

import java.util.Comparator;

/**
 * @Author: QR
 * @Date: 2021/7/5-15:49
 */
public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        // 利用年龄进行比较
        return p1.getAge() - p2.getAge();
    }
}
