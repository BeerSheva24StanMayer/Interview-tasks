package telran.interview;

import java.util.*;

public class MyStackInt {
    private LinkedList<Integer> stack = new LinkedList<>();
    private LinkedList<Integer> stackMax = new LinkedList<>();

	public void push(int num) {   
        stack.push(num);

        if(stackMax.peek() == null || num >= stackMax.peek()) {
            stackMax.push(num);
        }
	}

	public int pop() {
		emptyCheck();
        if(stack.peek().equals(stackMax.peek())) {
            stackMax.pop();
        }
        return stack.pop();
	}

	public int peek() {
		emptyCheck();
        return stack.peek();
	}

	public boolean isEmpty() {
		return stack.peek() == null;
	}

	public int getMaxElement() {
		emptyCheck();
        return stackMax.peek();
	}

    private void emptyCheck() {
        if(stack.isEmpty()) {
            throw new EmptyStackException();
        }
    }
}