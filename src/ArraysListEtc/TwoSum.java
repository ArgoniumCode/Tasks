package ArraysListEtc;

import java.util.HashMap;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		var NumToIndex = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			var Num = nums[i];
			var Diff = target - Num;

			if (NumToIndex.containsKey(Diff))
				return new int[]{NumToIndex.get(Diff), i};

			NumToIndex.put(Num, i);
		}

		return new int[0];
	}
}