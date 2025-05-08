package Hashes;

import java.io.*;
import java.util.*;

public class FrequentWord {
	public static void main(String[] args) throws IOException {
		var reader = new BufferedReader(new InputStreamReader(System.in));
		var writer = new BufferedWriter(new OutputStreamWriter(System.out));
		var wordCount = new HashMap<String, Integer>();
		var line = "";

		while ((line = reader.readLine()) != null) {
			var words = line.split(" ");
			for (var word : words) {
				if (!word.isEmpty()) {
					wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
				}
			}
		}

		var mostFrequent = "";
		var maxCount = 0;

		for (var entry : wordCount.entrySet()) {
			var currentCount = entry.getValue();
			var currentWord = entry.getKey();

			if (currentCount > maxCount || (currentCount == maxCount && currentWord.compareTo(mostFrequent) < 0)) {
				mostFrequent = currentWord;
				maxCount = currentCount;
			}
		}

		writer.write(mostFrequent);
		writer.newLine();

		reader.close();
		writer.close();
	}
}