package com.valtech.training.day2.test;
import com.valtech.training.day2.Outer;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
@DisplayName("To test arithmetic class")

class OuterTest {
	  private Outer outer;
	  @BeforeAll
		static void beforeAll() {
		  
			System.out.println("Before all");
		}

		@AfterAll
		static void afterAll() {
			System.out.println("After all");
		}
		@Before
	    public void setUp() {
	        outer = new Outer();
	    }
	@Test
	void test() {
		fail("Not yet implemented");
	}
	

}

