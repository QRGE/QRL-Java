package qr.data.structure.map;

import org.junit.jupiter.api.Test;
import qr.data.structure.hash.Car;
import qr.data.structure.hash.Person;

/**
 * @Author: QR
 * @Date: 2021/7/21-21:15
 */
public class HashMapTests {

    @Test
    public void hashMapFirstTest(){
        Car bigG = new Car(1, "Benz");
        Person p1 = new Person(21, 177.5f, "ToolMan", bigG);
        Person p2 = new Person(21, 177.5f, "ToolMan", bigG);
        HashMap<Person, Integer> hashMap = new HashMap<>();
        hashMap.put(p1, 1);
        hashMap.put(p2, 2);
    }


}
