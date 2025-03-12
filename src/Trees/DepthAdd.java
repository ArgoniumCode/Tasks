package Trees;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class DepthAdd {
	public static void main(String[] args) throws IOException {
		var reader = new BufferedReader(new InputStreamReader(System.in));
		var writer = new BufferedWriter(new OutputStreamWriter(System.out));

		var numbers = readNumbers(reader);
		var depths = calculateDepths(numbers);

		for (var depth : depths) {
			writer.write(depth + " ");
		}

		writer.newLine();

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

	private static List<Integer> calculateDepths(List<Integer> numbers) {
		var depths = new ArrayList<Integer>();
		if (numbers.isEmpty()) return depths;

		var root = new TreeNode(numbers.getFirst());
		depths.add(1);

		for (var i = 1; i < numbers.size(); i++) {
			var depth = insertAndGetDepth(root, numbers.get(i));
			if (depth != -1) {
				depths.add(depth);
			}
		}

		return depths;
	}

	private static int insertAndGetDepth(TreeNode node, int value) {
		var depth = 1;

		while (true) {
			if (value < node.value) {
				if (node.left == null) {
					node.left = new TreeNode(value);
					return depth + 1;
				} else {
					node = node.left;
					depth++;
				}
			} else if (value > node.value) {
				if (node.right == null) {
					node.right = new TreeNode(value);
					return depth + 1;
				} else {
					node = node.right;
					depth++;
				}
			} else {
				return -1;
			}
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