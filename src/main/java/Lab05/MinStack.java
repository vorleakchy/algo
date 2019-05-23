package Lab05;

import java.util.ArrayDeque;

public class MinStack {

    private Node top;
    private ArrayDeque<Node> minStack = new ArrayDeque<>();

    private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public void push(int data) {
        Node node = new Node(data);
        if (top == null) {
            top = node;
            minStack.push(top);
        } else {
            node.next = top;
            top = node;
            assert minStack.peek() != null;
            if (node.value < minStack.peek().value)
                minStack.push(top);
        }
    }

    public int pop() {
        if (top == null) throw new IllegalStateException("MinStack is empty!");
        Node node = top;
        if (node == minStack.peek()) minStack.pop();
        top = top.next;
        return node.value;
    }

    public int peek() {
        if (top == null) throw new IllegalStateException("MinStack is empty!");
        return top.value;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int min() {
        if (top == null || minStack.peek() == null) throw new IllegalStateException("MinStack is empty!");
        return minStack.peek().value;
    }

    public void print() {
        if (top == null) {
            System.out.println("[]");
        } else {
            Node node = top;
            System.out.print("[");
            while (node != null) {
                System.out.printf("%d, ", node.value);
                node = node.next;
            }
            System.out.println("]");
            assert minStack.peek() != null;
            System.out.printf("Min value is %d\n", minStack.peek().value);
        }

    }

}