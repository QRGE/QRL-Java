package qr.leetcode.ValidParentheses_20;

// https://leetcode-cn.com/problems/valid-parentheses/
import java.util.HashMap;
import java.util.Stack;

public class Solution {

    private HashMap<Character, Character> map = new HashMap<>();

    public Solution(){
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
    }

    public boolean isValid2(String s){
        if (s.length() % 2 == 1) return false;

        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(' || c=='{' || c=='['){
                stack.push(c);
            }else {
                if (stack.isEmpty()) return false;
                char left = stack.pop();
                if (c != map.get(left)) return false;
            }
        }
        return stack.isEmpty();
    }

    // 看到过去自己的写的代码真的好蠢
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) return false; // 奇数个括号直接返回false

        Stack<Character> stack = new Stack<>();
        // 为什么不先pop再判断呢？
        for (int i = 0; i < s.length(); i++) {
            if (left(s.charAt(i))){
                stack.push(s.charAt(i));
            }else if (right(s.charAt(i)) && stack.size() == 0){
                return false;
            }else if (s.charAt(i) == ']' && stack.peek() == '['){
                stack.pop();
            }else if (s.charAt(i) == ')' && stack.peek() == '('){
                stack.pop();
            }else if (s.charAt(i) == '}' && stack.peek() == '{'){
                stack.pop();
            }else {
                return false;
            }
        }
        return stack.size() == 0; // 不知道有isEmpty()
    }

    public boolean left(char c){
        return (c == '[' || c == '{' || c == '(');
    }

    public boolean right(char c){
        return (c == ']' || c == '}' || c == ')');
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("{[]}"));
    }
}
