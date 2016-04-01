import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {
	@Test
	public void split_commaAndNewLineExistInString_returnsCorrectlySplitArray() {
		// given
		String input = "1\n2,3";
		String[] correctSplit = {"1","2","3"};
		StringCalculator calculator = new StringCalculator();
		// when
		String[] split = calculator.split(input, ",");
		System.out.println(Arrays.toString(split));
		//then
		Assert.assertArrayEquals(correctSplit, split);
	}

	@Test
	public void extractExpression_containsNewLine_returnsRemainingPart() {
		// given
		String input = "a\nb";
		StringCalculator stringCalculator = new StringCalculator();
		// when
		String remaining = stringCalculator.extractExpression(input);
		//then
		assertEquals("b", remaining);
	}

	@Test
	public void extractExpression_dontContainPreambleSplitter_returnsAll() {
		// given
		String input = "ab";
		StringCalculator stringCalculator = new StringCalculator();
		// when
		String remaining = stringCalculator.extractExpression(input);
		//then
		assertEquals(input, remaining);
	}

	@Test
	public void indexOfPreambleSplitter_containsNewLine_returnsPosition() {
		// given
		StringCalculator stringCalculator = new StringCalculator();
		// when
		int idx = stringCalculator.indexOfPreambleSplitter("a\nb");
		//then
		assertEquals(1,idx);
	}

	@Test
	public void extractPreamble_containsPreamble_returnsPreamble() {
		// given
		StringCalculator stringCalculator = new StringCalculator();
		// when
		String preamble = stringCalculator.extractPreamble("//aaa\nbbb");
		//then
		assertEquals("aaa", preamble);
	}
}
