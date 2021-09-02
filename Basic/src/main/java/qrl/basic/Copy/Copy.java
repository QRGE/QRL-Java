package qrl.basic.Copy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 深拷贝和浅拷贝的区别即看对于对象类型是共享引用还是创建一个新的对象赋值其值
 * @author QR
 */
public class Copy {
    public static void main(String[] args) throws CloneNotSupportedException {
        CloneModel1 d1 = new CloneModel1(1, "doctor1", new Date());
        CloneModel1 d2 = (CloneModel1) d1.clone();
        // 克隆后的两个对象是不同的
        System.out.println(d2==d1);
        // 对于引用类型采用的策略是指向同一个引用, 所以此处结果为true
        System.out.println(d1.getBirthday() == d2.getBirthday());

        CloneModel2 d3 = new CloneModel2(3, "doctor3", new Date());
        CloneModel2 d4 = d3.clone();
        System.out.println(d3==d4);
        // 此处即为false
        System.out.println(d3.getBirthday() == d4.getBirthday());

    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class CloneModel1 implements Cloneable{
    private Integer id;
    private String name;
    private Date birthday;

    /**
     * 默认的clone()是前拷贝, 对于值的复制是直接复制, 而对于对象是共享同一个对象的引用
     * @return
     * @throws CloneNotSupportedException 不支持克隆异常
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class CloneModel2 implements Cloneable{
    private Integer id;
    private String name;
    private Date birthday;

    // 默认的clone()是前拷贝, 对于值的复制是直接复制, 而对于对象是共享同一个对象的引用
    @Override
    protected CloneModel2 clone() throws CloneNotSupportedException {
        CloneModel2 clone = (CloneModel2) super.clone();
        // 每个成员变量都是复制启值
        clone.setBirthday((Date) this.getBirthday().clone()); // 借助Date的clone()创建一个新的Date对象
        clone.setId(this.getId());
        clone.setName(this.getName());
        return clone;
    }
}
