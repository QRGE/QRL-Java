package org.qrl.basic.data.type;

/**
 * 学习一下项目中的 enum 类
 * @Author: QR
 * @Date: 2021/9/1-16:16
 */
public enum RecordType {

    SUGAR(1),
    BLOOD_PRESSURE(2),
    SPORT(3),
    MEDICAL(4),
    DIET(5),
    WEIGHT(6),
    WAIST(7),
    KETONE(8),
    INSULIN(9);

    private int  type;

    // 枚举类无法 new , 所以其构造方法都是设定自身的值
    RecordType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    /**
     * values() 可以遍历 enum() 中的所有设定值
     * @param type type
     * @return 如果匹配到对应的 enum 值则返回, 否则返回 null
     */
    public static RecordType valueOf(Integer type) {
        for (RecordType value : values()) {
            if (value.type == type) {
                return value;
            }
        }
        return null;
    }
}
