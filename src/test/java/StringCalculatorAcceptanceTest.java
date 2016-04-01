import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class StringCalculatorAcceptanceTest {

	@Parameterized.Parameters(name = "{0} add \"{1}\" should result {2}")
	public static Collection<Object[]> testData() {
		return Arrays.asList(new Object[][] {
				{"emptyString", "", 0},
				{"oneNumber", "1", 1},
				{"twoNumbers", "1,2", 3},
				{"manyNumbers", "1,10,100,1000", 1111},
				{"commaAndNewLineExistInString", "1\n2,3", 6},
				{"delimiterInPreamble", "//;\n1;2", 3},
				{"customDelimiterAndNewLinePresent", "//;\n1;2\n3", 6}
		});
	}

	@Parameterized.Parameter(0)
	public String message;

	@Parameterized.Parameter(1)
	public String input;

	@Parameterized.Parameter(2)
	public int sum;

	@Test
	public void acceptance() {
		// given
		StringCalculator stringCalculator = new StringCalculator();
		// when
		int value = stringCalculator.add(input);
		//then
		Assert.assertEquals(message, sum, value);
	}

}
