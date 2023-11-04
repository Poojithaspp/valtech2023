package assignments.test;
import assignments.CSSParser;
import  assignments.TagCounter;

import static org.junit.jupiter.api.Assertions.*;
 
import java.io.IOException;
 
import org.junit.jupiter.api.Test;
 

 
class TagCounterTest {
 
	@Test
	void testMain() {
		 TagCounter TagCounter = new TagCounter();
	        try {
	        	String testFilePath = "Counter.html"; // Replace with your CSS file path
	    		CSSParser cssParser = new CSSParser();
	    		 TagCounter.main(new String[]{});
	           
	        } catch (IOException e) {
	            fail("An exception occurred while running the TagCounter: " + e.getMessage());
	        }
	}
 
}