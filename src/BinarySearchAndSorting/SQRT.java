package BinarySearchAndSorting;

public class SQRT {
	public int mySqrt(int x) {
		long left = 0, right = x, result = 0;

		while (left <= right) {
			long mid = (left + right) / 2;
			long preResult = mid * mid;

			if (preResult == x)
				return (int)mid;
			else if (preResult < x) {
				result = mid;
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}

		return (int)result;
	}
}