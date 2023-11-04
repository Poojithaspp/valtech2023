package assignments.test;
import assignments.CatchyNumber;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@DisplayName("To test  catchynumber")

public class CatchyNumberTest {

    @Test
    public void testFindCatchyNumberWithValidInput() {
        String[] numbers = {"7777770777", "123454321", "8888888","7777177771","45245677"};
        String catchyNumber = CatchyNumber.findCatchyNumber(numbers);
        assertEquals("8888888", catchyNumber);
    }
    void testHasRepetitiveNumbers() {
        boolean hasRepetitiveNumbers = CatchyNumber.hasRepetitiveNumbers("77777");
        assertTrue(hasRepetitiveNumbers, "Should have detected repetitive numbers");
 
        boolean noRepetitiveNumbers = CatchyNumber.hasRepetitiveNumbers("12345");
        assertFalse(noRepetitiveNumbers, "Should not have detected repetitive numbers");
    }
 
    @Test
    void testIsFirstHalfEqualToSecondHalf() {
  boolean isEqual = CatchyNumber.isFirstHalfEqualToSecondHalf("7777177771");
        assertTrue(isEqual, "Should have detected equal first and second half");
 
       
    }
}
//    @Test
//    public void testFindCatchyNumberWithEmptyInput() {
//        String[] numbers = {};
//        String catchyNumber = CatchyNumber.findCatchyNumber(numbers);
//        assertNull(catchyNumber);
//    }

 




