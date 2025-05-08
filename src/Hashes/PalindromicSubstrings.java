package Hashes;

public class PalindromicSubstrings {
	public int countSubstrings(String s) {
		var count = 0;

		for (var i = 0; i < s.length(); i++) {
			count += expand(s, i, i);
			count += expand(s, i, i + 1);
		}

		return count;
	}

	private int expand(String s, int left, int right) {
		var count = 0;
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			count++;
			left--;
			right++;
		}

		return count;
	}
}