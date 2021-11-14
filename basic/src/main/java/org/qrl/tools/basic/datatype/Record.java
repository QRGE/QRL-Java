package org.qrl.tools.basic.datatype;

/**
 * 学习一下项目中的 enum 类
 * @Author: QR
 * @Date: 2021/9/1-16:16
 */
public enum Record {
    /**
     * 血糖
     */
    SUGAR(1),
    /**
     * 血压
     */
    BLOOD_PRESSURE(2),
    /**
     * 运动
     */
    SPORT(3),
    /**
     * 用药
     */
    MEDICAL(4),
    /**
     * 饮食
     */
    DIET(5),
    /**
     * 体重
     */
    WEIGHT(6),
    /**
     * 腰围
     */
    WAIST(7),
    /**
     * 尿酮
     */
    KETONE(8),
    /**
     * 胰岛素
     */
    INSULIN(9);

    private int  type;

    // 枚举类无法自己创建对象, 所以其构造方法固定为私有的为自身的值服务
    Record(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public static Record valueOf(Integer type) {
        for (Record value : values()) {
            if (value.type == type) {
                return value;
            }
        }
        return null;
    }
}
