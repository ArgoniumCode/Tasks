package Trees;

public class RangeSumBST {
	public int rangeSumBST(TreeNode root, int low, int high) {
		if (root == null) {
			return 0;
		}

		if (root.value < low) {
			return rangeSumBST(root.right, low, high);
		}

		if (root.value > high) {
			return rangeSumBST(root.left, low, high);
		}

		return root.value + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
	}
}
