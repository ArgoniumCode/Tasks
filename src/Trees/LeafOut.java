package Trees;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class LeafOut {
	public static void main(String[] args) throws IOException {
		var reader = new BufferedReader(new InputStreamReader(System.in));
		var writer = new BufferedWriter(new OutputStreamWriter(System.out));

		var numbers = readNumbers(reader);
		var tree = buildBST(numbers);
		var leaves = findLeaves(tree);

		for (var leaf : leaves) {
			writer.write(String.valueOf(leaf));
			writer.newLine();
		}

		reader.close();
		writer.close();
	}

	private static List<Integer> readNumbers(BufferedReader reader) throws IOException {
		var numbers = new ArrayList<Integer>();
		var line = reader.readLine();
		var parts = line.split(" ");

		for (var part : parts) {
			var num = Integer.parseInt(part);
			if (num == 0) break;
			numbers.add(num);
		}

		return numbers;
	}

	private static TreeNode buildBST(List<Integer> numbers) {
		var root = new TreeNode(numbers.getFirst());

		for (var i = 1; i < numbers.size(); i++) {
			insertIntoBST(root, numbers.get(i));
		}

		return root;
	}

	private static void insertIntoBST(TreeNode node, int value) {
		if (value < node.value) {
			if (node.left == null) {
				node.left = new TreeNode(value);
			} else {
				insertIntoBST(node.left, value);
			}
		} else if (value > node.value) {
			if (node.right == null) {
				node.right = new TreeNode(value);
			} else {
				insertIntoBST(node.right, value);
			}
		}
	}

	private static List<Integer> findLeaves(TreeNode root) {
		var leaves = new ArrayList<Integer>();
		collectLeaves(root, leaves);

		return leaves;
	}

	private static void collectLeaves(TreeNode node, List<Integer> leaves) {
		if (node == null) return;

		if (node.left == null && node.right == null) {
			leaves.add(node.value);
		} else {
			collectLeaves(node.left, leaves);
			collectLeaves(node.right, leaves);
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