package Trees;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Hipuy {
	public static void main(String[] args) throws IOException {
		var reader = new BufferedReader(new InputStreamReader(System.in));
		var writer = new BufferedWriter(new OutputStreamWriter(System.out));

		var n = Integer.parseInt(reader.readLine());
		var heap = new MaxHeap(n);

		for (var i = 0; i < n; i++) {
			var line = reader.readLine().split(" ");
			if (line[0].equals("0")) {
				var value = Integer.parseInt(line[1]);
				heap.insert(value);
			} else {
				var max = heap.extract();
				writer.write(String.valueOf(max));
				writer.newLine();
			}
		}

		reader.close();
		writer.close();
	}

	private static class MaxHeap {
		private int[] heap;
		private int size;

		public MaxHeap(int capacity) {
			heap = new int[capacity];
			size = 0;
		}

		public void insert(int value) {
			heap[size] = value;
			siftUp(size);
			size++;
		}

		public int extract() {
			var max = heap[0];
			heap[0] = heap[size - 1];
			size--;
			siftDown(0);

			return max;
		}

		private void siftUp(int index) {
			while (index > 0) {
				var parent = (index - 1) / 2;

				if (heap[index] <= heap[parent]) break;

				swap(index, parent);
				index = parent;
			}
		}

		private void siftDown(int index) {
			while (true) {
				var left = 2 * index + 1;
				var right = 2 * index + 2;
				var largest = index;

				if (left < size && heap[left] > heap[largest]) largest = left;
				if (right < size && heap[right] > heap[largest]) largest = right;
				if (largest == index) break;

				swap(index, largest);
				index = largest;
			}
		}

		private void swap(int i, int j) {
			var temp = heap[i];
			heap[i] = heap[j];
			heap[j] = temp;
		}
	}
}