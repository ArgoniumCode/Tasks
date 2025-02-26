package BaseDataStructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Window {
	Queue<Integer> Window;
	LinkedList<Integer> Maxs;
	int maxWindowsSize;

	public Window(int size) {
		Window = new LinkedList<>();
		Maxs = new LinkedList<>();
		maxWindowsSize = size;
	}

	public void Add(int x) {
		Window.add(x);
		AddInMaxs(x);

		if (Window.size() > maxWindowsSize) {
			if (Window.peek().equals(Maxs.getFirst()))
				Maxs.removeFirst();

			Window.remove();
		}
	}

	public int GetMax() {
		return Maxs.getFirst();
	}

	public void AddInMaxs(int x) {
		while (!Maxs.isEmpty() && Maxs.getLast() < x)
			Maxs.removeLast();

		Maxs.addLast(x);
	}
}

public class MaxSlidingWindow {
	public int[] maxSlidingWindow(int[] nums, int k) {
		var Result = new ArrayList<Integer>();
		var Window = new Window(k);

		for (int i = 0; i < k; i++)
			Window.Add(nums[i]);

		for (int i = k; i < nums.length; i++) {
			Result.add(Window.GetMax());
			Window.Add(nums[i]);
		}

		Result.add(Window.GetMax());

		return Result.stream().mapToInt(x -> x).toArray();
	}
}