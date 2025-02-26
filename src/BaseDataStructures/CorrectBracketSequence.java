package BaseDataStructures;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class CorrectBracketSequence {
	public static void main(String[] args) throws IOException {
		var reader = new BufferedReader(new InputStreamReader(System.in));
		var writer = new BufferedWriter(new OutputStreamWriter(System.out));

		var input = reader.readLine();
		var isEmpty = checkBrackets(input);
		var response = (isEmpty) ? "yes" : "no";

		writer.write(response);
		reader.close();
		writer.close();
	}

	private static boolean checkBrackets(String input) {
		var stack = new Stack<Character>();

		for (var i = 0; i < input.length(); i++) {
			var ch = input.charAt(i);

			if (ch == '(' || ch == '[' || ch == '{') {
				stack.push(ch);
			} else if (ch == ')' || ch == ']' || ch == '}') {
				if (stack.isEmpty()) {
					return false;
				}

				var top = stack.pop();
				if (!isMatchingPair(top, ch)) {
					return false;
				}
			}
		}

		return stack.isEmpty();
	}

	private static boolean isMatchingPair(char opening, char closing) {
		return (opening == '(' && closing == ')') ||
				(opening == '[' && closing == ']') ||
				(opening == '{' && closing == '}');
	}
}