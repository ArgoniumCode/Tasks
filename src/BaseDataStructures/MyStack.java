package BaseDataStructures;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
	Queue<Integer> Queue;

	public MyStack() {
		Queue = new LinkedList<>();
	}

	public void push(int x) {
		Queue.add(x);

		for (int i = 1; i < Queue.size(); i++)
			Queue.add(Queue.remove());
	}

	public int pop() {
	   return Queue.remove();
	}

	public int top() {
		return Queue.peek();
	}

	public boolean empty() {
		return Queue.isEmpty();
	}
}