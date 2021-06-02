package qr.Java.DataStructure.List.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Object> stack = new Stack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        while (stack.peek() != null){
            System.out.println(stack.pop());
        }

        // Java自己的Stack
        java.util.Stack<Integer> integers = new java.util.Stack<>();
        for (int i = 0; i < 10; i++) {
            integers.add(i);
        }
        while (!integers.isEmpty()){
            System.out.println(integers.pop());
        }
    }
}
