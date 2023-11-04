package assignments;

import java.util.Scanner;

public class CatchyNumber {
    public static String findCatchyNumber(String[] numbers) {
        String catchyNumber = null;
        int maxScore = 0;
 
        for (String number : numbers) {
            int score = calculateCatchinessScore(number);
 
            if (score > maxScore) {
                maxScore = score;
                catchyNumber = number;
            }
        }
 
        return catchyNumber;
    }
 
    // Calculate the catchiness score based on various criteria
    public static int calculateCatchinessScore(String number) {
        int score = 0;
 
        // Criteria: Repetitive numbers
        if (hasRepetitiveNumbers(number)) {
            score += 1;
        }
 
        // Criteria: First half and second half equality
        if (isFirstHalfEqualToSecondHalf(number)) {
            score += 2;
        }
 
        // Add more criteria as needed
 
        return score;
    }
 
    public static boolean hasRepetitiveNumbers(String number) {
        // Implement logic to check for repetitive numbers (e.g., "77777")
        // You can use regular expressions or a loop to check for repetitions.
    	  return number.matches(".*(\\d)\\1{2,}.*");
    	   // Replace with your logic
    }
 
    public static boolean isFirstHalfEqualToSecondHalf(String number) {
        int length = number.length();
        if (length % 2 == 0) {
            int halfLength = length / 2;
            String firstHalf = number.substring(0, halfLength);
            String secondHalf = number.substring(halfLength);
            return firstHalf.equals(secondHalf);
        }
        return true;
    }
 
    public static void main(String[] args) {
        String[] numbers = {"7777770777", "123454321", "8888888","7777177771"};
        String catchyNumber = findCatchyNumber(numbers);
        System.out.println("The most catchy number is: " + catchyNumber);
    
     
        
        
    }
}


