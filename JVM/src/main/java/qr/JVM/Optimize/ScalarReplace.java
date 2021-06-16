package qr.JVM.Optimize;

/**
 * -Xmx100m -Xms100m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:-EliminateAllocations(改变量)
 */
public class ScalarReplace {

    public static void main(String[] args) {
        alloc();
    }

    private static void alloc() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            Point point = new Point(1, 2);
        }
        long end = System.currentTimeMillis();
        System.out.println("Time consumed: " + (end - start) + "ms");
    }

    // 经过逃逸分析, 发现上面的alloc()方法中的point对象并不会被外界访问, 经过JIT优化, 就会把对象中的各个成员变量拆分成若干个标量代替
    private static void allocImprove(){
        int x = 1;
        int y = 2;
        System.out.println("Point.x: " + x);
        System.out.println("Point.y: " + y);
    }
}

class Point{

    Integer x;
    Integer y;

    public Point(Integer x, Integer y){
        this.x = x;
        this.y = y;
    }
}
