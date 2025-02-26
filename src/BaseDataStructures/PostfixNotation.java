package BaseDataStructures;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class PostfixNotation {
	public static void main(String[] args) throws IOException {
		var reader = new BufferedReader(new InputStreamReader(System.in));
		var writer = new BufferedWriter(new OutputStreamWriter(System.out));

		var input = reader.readLine().trim();
		var tokens = input.split(" ");
		var stack = new Stack<Integer>();

		for (var token : tokens) {
			if (isNumber(token)) {
				stack.push(Integer.parseInt(token));
			} else {
				int operand2 = stack.pop();
				int operand1 = stack.pop();
				int result = performOperation(token, operand1, operand2);
				stack.push(result);
			}
		}

		writer.write(String.valueOf(stack.pop()));
		reader.close();
		writer.close();
	}

	private static boolean isNumber(String token) {
		try {
			Integer.parseInt(token);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private static int performOperation(String operator, int operand1, int operand2) {
		return switch (operator) {
			case "+" -> operand1 + operand2;
			case "-" -> operand1 - operand2;
			case "*" -> operand1 * operand2;
			default -> throw new IllegalArgumentException("Неизвестная операция: " + operator);
		};
	}
}