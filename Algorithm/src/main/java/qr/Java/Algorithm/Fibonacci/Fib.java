package qr.Java.Algorithm.Fibonacci;

public class Fib {
    // O(2^n)
    public static int fib1(int n){
        if (n == 1) return 1;
        else if (n == 2) return 1;
        return fib1(n - 1) + fib1(n - 2);
    }

    // O(n)
    public static int fib2(int n){
        if (n == 1) return 1;
        else if (n == 2) return 1;
        int first = 1;
        int second = 1;
        // 因为第一和第二个值已经可以取得,所以只需要循环n-2次
        for (int i = 0; i < n - 2; i++) {
            second = first + second;
            first = second - first;
        }
        return second;
    }

    // 数学のpower 阿┗|｀O′|┛ 嗷~~
    public static int fib3(int n){
        double c = Math.sqrt(5);
        return (int)((Math.pow((1 + c) / 2, n) - Math.pow((1 - c) / 2 , n)) / c);
    }

    public static void main(String[] args) {
        System.out.println(fib2(10));
        System.out.println(fib3(10));
    }
}
