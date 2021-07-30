package qr.algorithm.sort;

import org.jetbrains.annotations.NotNull;
import qr.algorithm.domian.Student;

import java.text.DecimalFormat;

/**
 * @Author: QR
 * @Date: 2021/7/27-19:29
 */
@SuppressWarnings("unused, unchecked")
public abstract class Sort<T extends Comparable<T>> implements Comparable<Sort<T>> {

    protected final static Integer ARRAY_LIMIT = 2;
    protected T[] array;
    private int cmpCount;
    private int swapCount;
    private long spendTime;
    private final DecimalFormat fmt = new DecimalFormat("#.00");

    /**
     * 用于给数组排序的方法
     */
    protected void sort(T[] array){
        if (array == null || array.length < ARRAY_LIMIT){
            return;
        }
        this.array = array;
        long begin = System.currentTimeMillis();
        sort();
        spendTime = System.currentTimeMillis() - begin;
    }

    /**
     * 用于实现排序逻辑的方法
     */
    protected abstract void sort();

    /**
     * 设置默认的比较数组元素的方法
     * @param index1 index1
     * @param index2 index2
     * @return 比较结果
     */
    protected Integer cmp(Integer index1, Integer index2) {
        cmpCount++;
        return array[index1].compareTo(array[index2]);
    }

    protected Integer cmp(T v1, T v2) {
        cmpCount++;
        return v1.compareTo(v2);
    }

    protected void swap(Integer index1, Integer index2) {
        swapCount++;
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    @Override
    public int compareTo(@NotNull Sort<T> o) {
        int result = (int)(spendTime-o.spendTime);
        if (result != 0) {
            return result;
        }
        result = cmpCount - o.cmpCount;
        if (result != 0) {
            return result;
        }
        return swapCount - o.swapCount;
    }

    @Override
    public String toString() {
        String timeStr = "耗时：" + (spendTime / 1000.0) + "s(" + spendTime + "ms)";
        String compareCountStr = "比较：" + numberString(cmpCount);
        String swapCountStr = "交换：" + numberString(swapCount);
        String stableStr = "稳定性: " + isStable();
        return "【" + getClass().getSimpleName() + "】\n"
                + stableStr + "\t"
                + timeStr + " \t"
                + compareCountStr + "\t "
                + swapCountStr + "\n"
                + "------------------------------------------------------------------";
    }

    @SuppressWarnings("all")
    private String numberString(int number) {
        if (number < 10000) {
            return "" + number;
        }
        if (number < 100000000) {
            return fmt.format(number / 10000.0) + "万";
        }
        return fmt.format(number / 100000000.0) + "亿";
    }

    private boolean isStable(){
        // student 默认用 age 排序, 下面生成 age 均相同的学生数组
        // 如果进行排序后学生的成绩仍然按照规则进行排序, 那么此排序算法就稳定
        Student[] students = new Student[20];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(i * 10, 10);
        }
        sort((T[]) students);
        for (int i = 1; i < students.length; i++) {
            int score = students[i].getScore();
            int prevScore = students[i - 1].getScore();
            if (score != prevScore + 10) {
                return false;
            }
        }
        return true;
    }
}
