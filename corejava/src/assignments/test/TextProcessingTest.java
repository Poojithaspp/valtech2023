
package assignments.test;



import org.junit.Test;
import assignments.TextProcessing;

import static org.junit.jupiter.api.Assertions.*;

public class TextProcessingTest {

	@Test
	void testWordCount() {

		String testFilePath = "article.txt"; // Replace with your CSS file path
		TextProcessing textProcessing = new TextProcessing();
		textProcessing.main(new String[] {});
	}
}
