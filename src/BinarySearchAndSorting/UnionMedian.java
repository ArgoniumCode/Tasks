package BinarySearchAndSorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class UnionMedian {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] firstLine = reader.readLine().split(" ");
		int N = Integer.parseInt(firstLine[0]);
		int L = Integer.parseInt(firstLine[1]);

		int[][] sequences = new int[N][L];
		for (int i = 0; i < N; i++) {
			String[] parts = reader.readLine().split(" ");
			for (int j = 0; j < L; j++) {
				sequences[i][j] = Integer.parseInt(parts[j]);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				int median = findMedian(sequences[i], sequences[j], L);
				writer.write(median + "\n");
			}
		}

		reader.close();
		writer.close();
	}

	private static int findMedian(int[] a, int[] b, int L) {
		int low = Math.min(a[0], b[0]);
		int high = Math.max(a[L - 1], b[L - 1]);

		while (low <= high) {
			int mid = low + (high - low) / 2;

			int countA = countLessOrEqual(a, mid);
			int countB = countLessOrEqual(b, mid);

			if (countA + countB < L) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return low;
	}

	private static int countLessOrEqual(int[] arr, int x) {
		int left = 0;
		int right = arr.length - 1;
		int count = 0;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] <= x) {
				count = mid + 1;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return count;
	}
}