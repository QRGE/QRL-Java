package qr.JVM.GC;

import java.util.ArrayList;

public class GCDemo {

    public static void main(String[] args) {
        int i = 0; // 记录迭代次数
        try {
            ArrayList<String> names = new ArrayList<>();
            String name = "ZhangSan";
            for (int j = 0; j < Integer.MAX_VALUE; j++) {
                names.add(name);
                name = name + "HaHaHa";
                i++;
            }
            System.out.println(names);
        } catch (Throwable t){
            t.printStackTrace();
            System.out.println("迭代次数为: " + i);
        }
    }
}
