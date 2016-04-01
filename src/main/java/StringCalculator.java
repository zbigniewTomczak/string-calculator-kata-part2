/**
 * - magic strings explosion
 * - magic numbers
 * - responsibilities explosion
 */
public class StringCalculator {

	public static final int EMPTY_VALUE = 0;

	public int add(String input) {
		if (input.isEmpty()) {
			return EMPTY_VALUE;
		}
		String defaultDelimiter = ",";
		if (preambleExists(input)) {
			String preamble = extractPreamble(input);
			defaultDelimiter = preamble;
		}
		String expression = input;
		if (preambleExists(input)) {
			expression = extractExpression(input);
		}
		String[] stringNumbers = split(expression, defaultDelimiter);
		return calculateSum(stringNumbers);
	}

	private boolean preambleExists(String input) {
		return input.startsWith("//");
	}

	String extractExpression(String input) {
		return input.substring(indexOfExpressionBegin(input), input.length());
	}

	private int indexOfExpressionBegin(String input) {
		return indexOfPreambleSplitter(input) + 1;
	}

	int indexOfPreambleSplitter(String input) {
		return input.indexOf('\n');
	}

	String extractPreamble(String input) {
		return input.substring(2, indexOfPreambleSplitter(input));
	}

	private int calculateSum(String[] stringNumbers) {
		int sum = 0;
		for (String stringNumber : stringNumbers) {
			sum += Integer.parseInt(stringNumber);
		}
		return sum;
	}

	String[] split(String input, String defaultDelimiter) {
		return input.split("[\\n" + defaultDelimiter + "]");
	}
}
