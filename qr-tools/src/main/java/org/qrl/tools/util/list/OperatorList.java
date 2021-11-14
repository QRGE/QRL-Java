package org.qrl.tools.util.list;

import org.qrl.tools.constant.OperatorInfo;
import org.qrl.tools.entity.Operator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qr
 * @date 2021/11/13 4:46 PM
 */
public class OperatorList {

    /**
     * 方舟目前有 214 个干员, 可能有一些的干员真名我还并不清楚, 所以用代号代替
     */
    public final static List<Operator> OPERATOR_LIST = new ArrayList<>(OperatorInfo.operatorNum);
    static {
        OPERATOR_LIST.add(new Operator("KZ01", "Nearl the Radiant Knight","临光·玛嘉烈",2,6));
        OPERATOR_LIST.add(new Operator("KZ11", "Flametial","索纳",2,6));
        OPERATOR_LIST.add(new Operator("VC10", "Saileach","简·薇洛",2,6));
        OPERATOR_LIST.add(new Operator("B003", "Kal'tsit","凯尔希",2,6));
        OPERATOR_LIST.add(new Operator("JC01", "SilverAsh","恩希欧迪斯•希瓦艾什",1,6));
        OPERATOR_LIST.add(new Operator("KZ03", "Platinum","欣特莱雅",2,5));
        OPERATOR_LIST.add(new Operator("PA13", "Hibiscus","芙蓉",2,3));
        OPERATOR_LIST.add(new Operator("LT01", "Executor","送葬人",1,5));
        OPERATOR_LIST.add(new Operator("SG07", "Passenger","艾利奧特·格罗夫",1,6));
        OPERATOR_LIST.add(new Operator("LM20", "Aak","阿",2,3));
    }
}
