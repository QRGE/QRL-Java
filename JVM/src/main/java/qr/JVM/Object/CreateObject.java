package qr.JVM.Object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Constructor;

/**
 * the ways of create a object:
 *  - new
 *  - Class对象的newInstance
 *  - Constructor的newInstance
 *  - clone()
 *  - 反序列化
 *  - 某些第三方类库
 */
public class CreateObject {
    public static void main(String[] args) throws Exception {
        Doctor d1 = new Doctor(1, "QR");
        System.out.println(d1);

        Class<?> doctorClass = Class.forName("qr.JVM.Object.Doctor");
        // newInstance只能通过调用空参构造方法创建对象
        Doctor d2 = (Doctor)doctorClass.newInstance();
        d2.setId(2);
        d2.setName("doctor2");
        System.out.println(d2);

        // 通过获取Constructor的对象调用去newInstance()创建对象
        // getConstructor通过传入参数类型的class对象创建对应参数类型的Constructor对象
        Constructor<?> doctorClassConstructor = doctorClass.getConstructor(Integer.class, String.class);
        Doctor d3 = (Doctor) doctorClassConstructor.newInstance(3, "doctor3");
        System.out.println(d3);

        // 通过Clone()克隆一个对象
        Doctor d4 = (Doctor) d3.clone();
        System.out.println(d4);
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Doctor implements Cloneable{
    private Integer id;
    private String name;

    // Object的clone()默认是浅拷贝
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
