package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathExists {
	public boolean validPath(int n, int[][] edges, int source, int destination) {
		if (source == destination) return true;
		
		var graph = buildGraph(n, edges);
		
		return BFS(graph, source, destination);
	}

	private List<List<Integer>> buildGraph(int n, int[][] edges) {
		var graph = new ArrayList<List<Integer>>(n);
		
		for (int i = 0; i < n; i++) 
			graph.add(new ArrayList<>());

		for (var edge : edges) {
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}
		
		return graph;
	}

	private boolean BFS(List<List<Integer>> graph, int source, int destination) {
		var visited = new boolean[graph.size()];
		var queue = new LinkedList<Integer>();
		queue.offer(source);
		visited[source] = true;

		while (!queue.isEmpty()) {
			var current = queue.poll();
			for (var neighbor : graph.get(current)) {
				if (neighbor == destination) {
					return true;
				}

				if (!visited[neighbor]) {
					visited[neighbor] = true;
					queue.offer(neighbor);
				}
			}
		}
		
		return false;
	}
}