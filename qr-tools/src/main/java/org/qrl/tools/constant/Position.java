package org.qrl.tools.constant;

/**
 * @Author QR
 * @Date 2021/11/7 9:38 PM
 */
public enum Position {

    SNIPER(1,0),
    CASTER(2,0),
    MEDIC(3,0),
    GUARD(4,0),
    VANGUARD(5,0),
    DEFENDER(6,0),
    SPECIALIST(7,0),
    SUPPORTER(8,0);

    int mainType;
    int subType;

    Position(int mainType, int subType) {
        this.mainType = mainType;
        this.subType = subType;
    }

    public int getMainType() {
        return mainType;
    }

    public void setMainType(int mainType) {
        this.mainType = mainType;
    }

    public int getSubType() {
        return subType;
    }

    public void setSubType(int subType) {
        this.subType = subType;
    }
}
