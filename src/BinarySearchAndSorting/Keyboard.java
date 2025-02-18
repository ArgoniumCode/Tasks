package BinarySearchAndSorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Keyboard {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(reader.readLine());

		String[] cParts = reader.readLine().split(" ");
		int[] c = new int[n];
		for (int i = 0; i < n; i++) {
			c[i] = Integer.parseInt(cParts[i]);
		}

		int k = Integer.parseInt(reader.readLine());

		String[] pParts = reader.readLine().split(" ");
		int[] p = new int[k];
		for (int i = 0; i < k; i++) {
			p[i] = Integer.parseInt(pParts[i]);
		}

		int[] count = new int[n + 1];
		for (int i = 0; i < k; i++) {
			count[p[i]]++;
		}

		for (int i = 1; i <= n; i++) {
			if (count[i] > c[i - 1]) {
				writer.write("YES\n");
			} else {
				writer.write("NO\n");
			}
		}

		reader.close();
		writer.close();
	}
}