package qr.Java.IO.Seriablize;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Student implements Serializable {

    private Integer id;
    private String className;
    private String name;
}
