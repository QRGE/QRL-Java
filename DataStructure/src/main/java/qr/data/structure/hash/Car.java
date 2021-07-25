package qr.data.structure.hash;

/**
 * @Author: QR
 * @Date: 2021/7/21-15:13
 */
@SuppressWarnings("all")
public class Car {

    private Integer id;
    private String brand;

    public Car() {
    }

    public Car(Integer id, String brand) {
        this.id = id;
        this.brand = brand;
    }

    @Override
    public int hashCode() {
        int hashCode = id.hashCode();
        hashCode = hashCode * 31 + brand.hashCode();
        return hashCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
