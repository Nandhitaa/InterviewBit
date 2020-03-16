/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) – Push element x onto stack.
pop() – Removes the element on top of the stack.
top() – Get the top element.
getMin() – Retrieve the minimum element in the stack.
Note that all the operations have to be constant time operations.

Questions to ask the interviewer :

Q: What should getMin() do on empty stack? 
A: In this case, return -1.

Q: What should pop do on empty stack? 
A: In this case, nothing. 

Q: What should top() do on empty stack?
A: In this case, return -1
*/

import java.util.Stack;

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    public void push(int x) {
        stack.push(x);
        if(minStack.empty() || x < minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if(!stack.empty()) {
            int x = stack.pop();
            if(x == minStack.peek()) {
                minStack.pop();
            }
        }
    }

    public int top() {
        if(stack.empty()) {
            return -1;
        }
        return stack.peek();
    }

    public int getMin() {
        if(stack.empty()) {
            return -1;
        }
        return minStack.peek();
    }
}
