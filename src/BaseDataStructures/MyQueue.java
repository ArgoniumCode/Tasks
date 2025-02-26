package BaseDataStructures;

import java.util.Stack;

public class MyQueue {
	Stack<Integer> Input;
	Stack<Integer> Output;

	public MyQueue() {
		 Input = new Stack<>();
		 Output = new Stack<>();
	}

	public void push(int x) {
		Input.push(x);
	}

	public int pop() {
		peek();

		return Output.pop();
	}

	public int peek() {
		if (Output.isEmpty()) {
			while (!Input.isEmpty()) {
				Output.push(Input.pop());
			}
		}

		return Output.peek();
	}

	public boolean empty() {
		return Input.isEmpty() && Output.isEmpty();
	}
}