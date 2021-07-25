package qr.data.structure.hash;

/**
 * @Author: QR
 * @Date: 2021/7/21-14:47
 */
@SuppressWarnings("all")
public class Person {
    private Integer age;
    private Float height;
    private String name;
    // 成员变量如果有自定义对象 A 则只需要要类A 重写了 hashCode() 即可
    private Car car;

    public Person(int age, float height, String name, Car car) {
        this.age = age;
        this.height = height;
        this.name = name;
        this.car = car;
    }

    @Override
    public int hashCode() {
        int hashCode = age.hashCode();
        hashCode = hashCode * 31 + height.hashCode();
        hashCode = hashCode * 31 + name.hashCode();
        hashCode = hashCode * 31 + car.hashCode();
        return hashCode;
    }

    /**
     * 重写equals可以用于自定义比较方法,
     *      对于哈希表的意义为当两个存储对象计算的index相同时用于进行两个对象的比较判断对应key的值是否需要进行替换
     * @param obj 传入的比较对象
     * @return 比较结果
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        // 传入的对象为null或者两个对象的类不相等
        if (obj == null || !(obj instanceof  Person)){
            return false;
        }
        Person p = (Person) obj;
        return this.getAge() == p.getAge()
                && this.getHeight() == p.getHeight()
                && p.getName() == null ? this.getName() == null : p.getName().equals(this.getName())
                && p.getCar() == null ? this.getCar() == null : p.getCar().equals(this.getCar());
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
