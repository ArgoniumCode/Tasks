package Hashes;

public class UniqueSubstrings {
	public int findSubstringInWraproundString(String s) {
		var count = new int[26];
		var maxLen = 0;

		for (var i = 0; i < s.length(); i++) {
			if (i > 0 && (s.charAt(i) - s.charAt(i - 1) == 1 || s.charAt(i - 1) - s.charAt(i) == 25))
				maxLen++;
			else
				maxLen = 1;

			var idx = s.charAt(i) - 'a';
			count[idx] = Math.max(count[idx], maxLen);
		}

		var result = 0;
		for (var num : count)
			result += num;

		return result;
	}
}
