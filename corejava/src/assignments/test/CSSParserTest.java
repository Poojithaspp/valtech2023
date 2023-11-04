
package assignments.test;

import assignments.CSSParser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CSSParserTest {

	@Test
	void testCSSParser() {
		// Your test file path
		String testFilePath = "C:/Users/Poojitha.SP/eclipse-workspace/corejava/style.css"; // Replace with your CSS file
																							// path
		CSSParser cssParser = new CSSParser();
		cssParser.main(new String[] {});
	}

	@Test

	void testhexToRgb() {

		CSSParser cssParser = new CSSParser();

		// Test case 1: Test a known hex value and check the RGB conversion
		String hexValue = "FFA500"; // Example hex value for orange color
		String expectedRGB = "rgb(255,165,0)"; // Expected RGB value for the given hex

		String actualRGB = cssParser.hexToRgb(hexValue);

		assertEquals(expectedRGB, actualRGB, "Hex to RGB conversion failed for " + hexValue);
	}
}
