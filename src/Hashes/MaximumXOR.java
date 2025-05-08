package Hashes;

public class MaximumXOR {
	private static class TrieNode {
		TrieNode[] children = new TrieNode[2];
	}

	public int findMaximumXOR(int[] nums) {
		var root = new TrieNode();
		var maxXor = 0;

		for (var num : nums) {
			var node = root;
			var xorNode = root;
			var currXor = 0;

			for (var i = 31; i >= 0; i--) {
				var bit = (num >>> i) & 1;

				if (node.children[bit] == null)
					node.children[bit] = new TrieNode();

				node = node.children[bit];

				var toggleBit = 1 - bit;
				if (xorNode.children[toggleBit] != null) {
					currXor += (1 << i);
					xorNode = xorNode.children[toggleBit];
				} else {
					xorNode = xorNode.children[bit];
				}
			}

			maxXor = Math.max(maxXor, currXor);
		}

		return maxXor;
	}
}