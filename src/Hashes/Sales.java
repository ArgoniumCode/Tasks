package Hashes;

import java.io.*;
import java.util.*;

public class Sales {
	public static void main(String[] args) throws IOException {
		var reader = new BufferedReader(new InputStreamReader(System.in));
		var writer = new BufferedWriter(new OutputStreamWriter(System.out));
		var sales = new TreeMap<String, TreeMap<String, Integer>>();

		var line = "";
		while ((line = reader.readLine()) != null && !line.isEmpty()) {
			var parts = line.split(" ");
			var buyer = parts[0];
			var product = parts[1];
			var amount = Integer.parseInt(parts[2]);

			sales.putIfAbsent(buyer, new TreeMap<>());

			var products = sales.get(buyer);
			products.put(product, products.getOrDefault(product, 0) + amount);
		}

		for (var entry : sales.entrySet()) {
			writer.write(entry.getKey() + ":\n");
			
			for (var productEntry : entry.getValue().entrySet()) {
				writer.write(productEntry.getKey() + " " + productEntry.getValue() + "\n");
			}
		}

		writer.flush();
		reader.close();
		writer.close();
	}
}

