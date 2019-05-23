package sandbox;

import java.util.Stack;

public class StackSandbox {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.print(stack.pop());
    }
}
