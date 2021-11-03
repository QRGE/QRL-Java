package qrl.stream.io.ByteStreams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 对象流: ObjectOutputStream/ObjectInputStream
 *      增强缓冲区功能
 *      增强了8种基本数据类型和字符串功能
 *      增强了读写对象的功能, 可以对对象进行序列化:
 *          readObject()
 *          writeObject(Object obj)
 */
public class ObjectStream {

    public static void main(String[] args) {

    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Person implements Serializable {

    private Integer id;
    private String name;
    private Integer age;
}
