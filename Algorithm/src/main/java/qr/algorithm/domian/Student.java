package qr.algorithm.domian;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: QR
 * @Date: 2021/7/28-15:04
 */
@Data
@AllArgsConstructor
public class Student implements Comparable<Student>{

    private int score;
    private int age;

    private String name = "[ { \"endtime\": \"23:59\", \"isSend\": 1, \"subType\": 1, \"starttime\": \"07:00\", \"recordType\": 1 }, { \"endtime\": \"23:59\", \"isSend\": 1, \"subType\": 0, \"starttime\": \"07:00\", \"recordType\": 6 } ]";


    @Override
    public int compareTo(Student s) {
        return age - s.age;
    }
}
