package BaseDataStructures;

import java.util.Stack;

public class MinStack {
	Stack<Integer> Stack;
	Stack<Integer> Min;

	public MinStack() {
		Stack = new Stack<>();
		Min = new Stack<>();
	}

	public void push(int val) {
		if (!Stack.isEmpty())
			System.out.println(Min.peek());

		if (Min.isEmpty() || val <= Min.peek())
			Min.push(val);

		Stack.push(val);
	}

	public void pop() {
		if (Stack.peek().equals(Min.peek()))
			Min.pop();

		Stack.pop();
	}

	public int top() {
		return Stack.peek();
	}

	public int getMin() {
		return Min.peek();
	}
}