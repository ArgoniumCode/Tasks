package BaseDataStructures;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;

public class GoblinsAndShamans {
	public static void main(String[] args) throws IOException {
		var reader = new BufferedReader(new InputStreamReader(System.in));
		var writer = new BufferedWriter(new OutputStreamWriter(System.out));

		var N = Integer.parseInt(reader.readLine());
		var firstHalf = new ArrayDeque<Integer>();
		var secondHalf = new ArrayDeque<Integer>();

		for (var i = 0; i < N; i++) {
			var line = reader.readLine().trim();
			if (line.startsWith("+")) {
				var num = Integer.parseInt(line.substring(2));
				secondHalf.addLast(num);
			} else if (line.startsWith("*")) {
				var num = Integer.parseInt(line.substring(2));
				if (firstHalf.size() > secondHalf.size()) {
					secondHalf.addFirst(num);
				} else {
					firstHalf.addLast(num);
				}
			} else if (line.equals("-")) {
				writer.write(firstHalf.pollFirst().toString());
				writer.newLine();
			}

			if (firstHalf.size() < secondHalf.size()) {
				firstHalf.addLast(secondHalf.pollFirst());
			}
		}

		reader.close();
		writer.close();
	}
}