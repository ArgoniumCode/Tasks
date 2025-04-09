package Graphs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class CycleSearch {
	public static void main(String[] args) throws IOException {
		var reader = new BufferedReader(new InputStreamReader(System.in));
		var writer = new BufferedWriter(new OutputStreamWriter(System.out));

		var n = Integer.parseInt(reader.readLine());
		var graph = new int[n][n];

		for (var i = 0; i < n; i++) {
			var parts = reader.readLine().split(" ");
			for (var j = 0; j < n; j++) {
				graph[i][j] = Integer.parseInt(parts[j]);
			}
		}

		var result = findCycleInGraph(n, graph);
		if (result == null) {
			writer.write("NO\n");
		} else {
			writer.write("YES\n");
			writer.write(result.size() + "\n");

			for (var v : result)
				writer.write((v + 1) + " ");

			writer.write("\n");
		}

		writer.flush();
	}

	static List<Integer> findCycleInGraph(int n, int[][] graph) {
		var visited = new boolean[n];
		var parent = new int[n];

		Arrays.fill(parent, -1);

		for (var i = 0; i < n; i++) {
			if (!visited[i]) {
				var cycle = DFS(i, graph, visited, parent);
				if (cycle != null)
					return cycle;
			}
		}

		return null;
	}

	static List<Integer> DFS(int u, int[][] graph, boolean[] visited, int[] parent) {
		var stack = new ArrayDeque<Integer>();
		stack.push(u);

		while (!stack.isEmpty()) {
			var curr = stack.pop();
			if (!visited[curr]) visited[curr] = true;

			for (var v = 0; v < graph.length; v++) {
				if (graph[curr][v] == 0) continue;
				if (!visited[v]) {
					parent[v] = curr;
					stack.push(v);
				} else if (v != parent[curr]) {
					return buildCycle(curr, v, parent);
				}
			}
		}

		return null;
	}

	static List<Integer> buildCycle(int u, int v, int[] parent) {
		var path = new ArrayList<Integer>();
		for (var curr = u; curr != v; curr = parent[curr])
			path.add(curr);

		path.add(v);
		Collections.reverse(path);

		return path;
	}
}
