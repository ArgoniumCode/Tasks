package BaseDataStructures;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class SortingWagonsLite {
	public static void main(String[] args) throws IOException {
		var reader = new BufferedReader(new InputStreamReader(System.in));
		var writer = new BufferedWriter(new OutputStreamWriter(System.out));

		var N = Integer.parseInt(reader.readLine());
		var input = reader.readLine().trim();
		var parts = input.split(" ");
		var wagons = new int[N];

		for (var i = 0; i < N; i++)
			wagons[i] = Integer.parseInt(parts[i]);

		var stack = new Stack<Integer>();
		var expected = 1;

		for (var wagon : wagons) {
			stack.push(wagon);

			while (!stack.isEmpty() && stack.peek() == expected) {
				stack.pop();
				expected++;
			}
		}

		var result = (stack.isEmpty()) ? "YES" : "NO";
		writer.write(result);

		reader.close();
		writer.close();
	}
}