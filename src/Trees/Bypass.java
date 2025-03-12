package Trees;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Bypass {
	public static void main(String[] args) throws IOException {
		var reader = new BufferedReader(new InputStreamReader(System.in));
		var writer = new BufferedWriter(new OutputStreamWriter(System.out));

		var input = reader.readLine().split(" ");
		TreeNode root = null;

		for (var s : input) {
			var num = Integer.parseInt(s);
			if (num == 0) break;
			root = insert(root, num);
		}

		inOrder(root, writer);

		reader.close();
		writer.close();
	}

	private static TreeNode insert(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		}

		if (val < root.value) {
			root.left = insert(root.left, val);
		} else if (val > root.value) {
			root.right = insert(root.right, val);
		}

		return root;
	}

	private static void inOrder(TreeNode root, BufferedWriter writer) throws IOException {
		if (root != null) {
			inOrder(root.left, writer);
			writer.write(root.value + "\n");
			inOrder(root.right, writer);
		}
	}

	private static class TreeNode {
		private int value;
		private TreeNode left;
		private TreeNode right;

		TreeNode(int value) {
			this.value = value;
		}
	}
}