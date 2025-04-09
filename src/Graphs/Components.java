package Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Components
{
	private static void DFS(
		int currentVertex,
		HashSet<Integer> visited,
		ArrayList<Integer> component,
		ArrayList<ArrayList<Integer>> adjacencyList)
	{
		visited.add(currentVertex);
		component.add(currentVertex);

		for(var vertex : adjacencyList.get(currentVertex))
			if(!visited.contains(vertex))
				DFS(vertex, visited, component, adjacencyList);
	}

	private static ArrayList<ArrayList<Integer>> GetComponents(ArrayList<ArrayList<Integer>> adjacencyList)
	{
		var visited = new HashSet<Integer>();
		var components = new ArrayList<ArrayList<Integer>>();

		for(var vertex = 1; vertex < adjacencyList.size(); vertex++)
		{
			if(visited.contains(vertex))
				continue;

			var component = new ArrayList<Integer>();
			DFS(vertex, visited, component, adjacencyList);
			components.add(component);
		}

		return components;
	}

	private static ArrayList<ArrayList<Integer>> GetAdjacencyList()
	{
		var scanner = new Scanner(System.in);
		var countVertex = scanner.nextInt();
		var countEdge = scanner.nextInt();

		var adjacencyList = new ArrayList<ArrayList<Integer>>();
		for(var i = 0; i < countVertex + 1; i++)
			adjacencyList.add(new ArrayList<>());

		for (var i = 0; i < countEdge; i++)
		{
			var firstVertex = scanner.nextInt();
			var secondVertex = scanner.nextInt();

			adjacencyList.get(firstVertex).add(secondVertex);
			adjacencyList.get(secondVertex).add(firstVertex);
		}

		return adjacencyList;
	}

	private static void Print(ArrayList<ArrayList<Integer>> components)
	{
		System.out.println(components.size());

		for(var component : components) {
			System.out.println(component.size());

			for (var vertex : component)
				System.out.print(vertex + " ");

			System.out.println();
		}
	}

	public static void main(String[] args)
	{
		var adjacencyList = GetAdjacencyList();
		var components = GetComponents(adjacencyList);
		Print(components);
	}
}