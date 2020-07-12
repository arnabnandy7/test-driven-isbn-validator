package io.tdd.isbn;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidatorISBNTest {
	
	
	@BeforeEach
	public void setup() {
		
	}

	@Test
	void testForValidISBN() {
		
		ValidateISBN validator=new ValidateISBN();
		Boolean result=validator.checkISBN("0141345659","ten");
		assertTrue(result);
		result=validator.checkISBN("0141345659","ten");
		assertTrue(result);
	}
	
	@Test
	void testForInvalidValidISBN() {
		ValidateISBN validator=new ValidateISBN();
		Boolean result=validator.checkISBN("0141345650","ten");
		assertFalse(result);
	}
	
	
	@Test
	void testForValid10DigitISBN() {
		ValidateISBN validator=new ValidateISBN();
		Boolean result=validator.checkISBN("0141345659","ten");
		assertTrue(result);
	}
	
	@Test
	void testForInValid10DigitISBN() {
		ValidateISBN validator=new ValidateISBN();
		Boolean result=validator.checkISBN("1","ten");
		assertFalse(result);
	}
	
	@Test
	void testForValid13DigitISBN() {
		ValidateISBN validator=new ValidateISBN();
		Boolean result=validator.checkISBN("978-0141345659","13");
		assertTrue(result);
	}
	@Test
	void testForInValid13DigitISBN() {
		ValidateISBN validator=new ValidateISBN();
		Boolean result=validator.checkISBN("979-0141345659","13");
		assertFalse(result);
	}
	
	@Test
	void testForInValid13DigitISBNOtherFormats() {
		ValidateISBN validator=new ValidateISBN();
		Boolean result=validator.checkISBN("979#0141345659","13");
		assertFalse(result);
		result=validator.checkISBN("","13");
		assertFalse(result);
		result=validator.checkISBN("uHFajsflafjl","13");
		assertFalse(result);
		result=validator.checkISBN(null,"13");
		assertFalse(result);
		
		
	}
	
	@AfterEach
	public void destroy() {
		
	}

}
