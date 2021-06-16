package qr.JVM.Heap;

import qr.Java.Utils.Thread.TSTools;

import java.util.ArrayList;

/**
 * -SurvivorRation: 可以设置Eden和Survivor的比例, 默认比例 Eden:Survivor0:Survivor1 = 8:1:1
 * 有时候通过查看内存发现比例并不是默认值, JVM存在自适应机制, 可以通过-XX:-UseAdaptiveSizePolicy 关闭自适应策略
 * 或者通过手动指定SurvivorRation进行设置
 *
 * -Xmn: 设置新生代内存的大小
 */
public class EdenAndSurvivor {

    public static void main(String[] args) {
        System.out.println("Just a Demo...");
        new ArrayList<>();
        TSTools.sleepS(1000);
    }
}
