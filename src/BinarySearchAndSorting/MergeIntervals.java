package BinarySearchAndSorting;

import java.util.ArrayList;

public class MergeIntervals {
	public int[][] merge(int[][] intervals) {
		java.util.Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

		var result = new ArrayList<int[]>();

		for (var array : intervals) {
			if (result.isEmpty() || result.getLast()[1] < array[0]) {
				result.add(array);
			}
			else {
				result.getLast()[1] = Math.max(result.getLast()[1], array[1]);
			}
 		}

		return result.toArray(int[][]::new);
	}
}