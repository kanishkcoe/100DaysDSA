package day4;

//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//Implement the MinStack class:
//MinStack() initializes the stack object.
//void push(int val) pushes the element val onto the stack.
//void pop() removes the element on the top of the stack.
//int top() gets the top element of the stack.
//int getMin() retrieves the minimum element in the stack.
//You must implement a solution with O(1) time complexity for each function.

import java.util.Stack;

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minimumStack;


    public MinStack() {
        stack = new Stack<>();
        minimumStack = new Stack<>();
    }

    public void push(Integer value) {
        if(minimumStack.isEmpty()) {
            minimumStack.push(value);
        } else {
            Integer currentMinimum = minimumStack.peek();
            if(currentMinimum > value) {
                minimumStack.push(value);
            } else {
                minimumStack.push(currentMinimum);
            }
        }
        stack.push(value);
    }

    public void pop() {
        stack.pop();
        minimumStack.pop();
    }

    public Integer top() {
        return stack.peek();
    }

    public Integer getMin() {
        return minimumStack.peek();
    }
}

public class MinstackRunner {

    public static void main(String[] args) {
        MinStack minstack = new MinStack();

        minstack.push(-2);
        minstack.push(0);
        minstack.push(-3);

        System.out.println("min = " + minstack.getMin());
        minstack.pop();
        System.out.println("top = " + minstack.top());
        System.out.println("min = " + minstack.getMin());
    }
}
