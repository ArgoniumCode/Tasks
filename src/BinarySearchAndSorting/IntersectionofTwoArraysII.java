package BinarySearchAndSorting;

import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionofTwoArraysII {
	public int[] intersect(int[] nums1, int[] nums2) {
		var result = new ArrayList<Integer>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int first = 0, second = 0;

		while (first < nums1.length && second < nums2.length) {
			if (nums1[first] == nums2[second]) {
				result.add(nums1[first]);
				first++;
				second++;
			}
			else if (nums1[first] < nums2[second]) {
				first++;
			}
			else {
				second++;
			}
		}

		return result.stream().mapToInt(x -> x).toArray();
	}
}