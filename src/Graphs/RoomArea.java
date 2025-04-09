package Graphs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class RoomArea {
	public static void main(String[] args) throws IOException {
		var reader = new BufferedReader(new InputStreamReader(System.in));
		var writer = new BufferedWriter(new OutputStreamWriter(System.out));

		var n = Integer.parseInt(reader.readLine());
		var maze = new char[n][];

		for (var i = 0; i < n; i++)
			maze[i] = reader.readLine().toCharArray();

		var coords = reader.readLine().split(" ");
		var row = Integer.parseInt(coords[0]) - 1;
		var col = Integer.parseInt(coords[1]) - 1;

		var area = getRoomArea(maze, row, col);
		writer.write(String.valueOf(area));

		reader.close();
		writer.close();
	}

	private static int getRoomArea(char[][] maze, int startRow, int startCol) {
		var queue = new LinkedList<int[]>();
		queue.offer(new int[]{startRow, startCol});
		maze[startRow][startCol] = '*';

		var area = 0;
		var dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

		while (!queue.isEmpty()) {
			var current = queue.poll();
			area++;

			for (var dir : dirs) {
				var newRow = current[0] + dir[0];
				var newCol = current[1] + dir[1];

				if (newRow >= 0 && newRow < maze.length && newCol >= 0 && newCol < maze.length && maze[newRow][newCol] == '.') {
					maze[newRow][newCol] = '*';
					queue.offer(new int[]{newRow, newCol});
				}
			}
		}

		return area;
	}
}