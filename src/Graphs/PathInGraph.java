package Graphs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PathInGraph {
	public static void main(String[] args) throws IOException {
		var reader = new BufferedReader(new InputStreamReader(System.in));
		var writer = new BufferedWriter(new OutputStreamWriter(System.out));

		var n = Integer.parseInt(reader.readLine());
		var adjMatrix = new int[n][n];
		
		for (var i = 0; i < n; i++) {
			var parts = reader.readLine().split(" ");
			for (var j = 0; j < n; j++) {
				adjMatrix[i][j] = Integer.parseInt(parts[j]);
			}
		}

		var vertices = reader.readLine().split(" ");
		var start = Integer.parseInt(vertices[0]) - 1;
		var end = Integer.parseInt(vertices[1]) - 1;

		var result = findShortestPath(adjMatrix, start, end);
		if (result == null) {
			writer.write("-1");
		} else {
			writer.write(String.valueOf(result.size() - 1));
			if (result.size() > 1) {
				writer.newLine();

				var path = new StringBuilder();
				for (var node : result) {
					path.append(node + 1).append(" ");
				}

				writer.write(path.toString().trim());
			}
		}

		reader.close();
		writer.close();
	}

	private static List<Integer> findShortestPath(int[][] adjMatrix, int start, int end) {
		if (start == end)
			return List.of(start);

		var n = adjMatrix.length;
		var prev = new int[n];
		Arrays.fill(prev, -1);

		var queue = new LinkedList<Integer>();
		queue.add(start);
		prev[start] = start;

		while (!queue.isEmpty()) {
			var current = queue.poll();

			for (var neighbor = 0; neighbor < n; neighbor++) {
				if (adjMatrix[current][neighbor] == 1 && prev[neighbor] == -1) {
					prev[neighbor] = current;
					if (neighbor == end) {
						return recreatePath(prev, start, end);
					}
					queue.add(neighbor);
				}
			}
		}

		return null;
	}

	private static List<Integer> recreatePath(int[] prev, int start, int end) {
		var path = new LinkedList<Integer>();
		var current = end;
		
		while (current != start) {
			path.addFirst(current);
			current = prev[current];
		}
		
		path.addFirst(start);

		return path;
	}
}