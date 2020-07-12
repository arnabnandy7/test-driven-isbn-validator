package io.tdd.isbn;

import java.util.Optional;
import java.util.stream.Stream;

public class ValidateISBN {

	static int totalFor10DigitISBNCheck = 0;
	static int totalFor13DigitISBNCheck = 0;

	public Boolean checkISBN(String isbn, String isbnType) {
		String isbnFilteredData = Optional.ofNullable(isbn).orElse("");
		if (isbnFilteredData.length() == 10 && isbnType.equalsIgnoreCase("ten")) {
			Stream.iterate(0, i -> i < 10, i -> i + 1).forEach(i -> {
				int digit = Integer.parseInt(Character.toString(isbnFilteredData.charAt(i)));
				totalFor10DigitISBNCheck = totalFor10DigitISBNCheck + digit * (10 - i);
			});
			if (totalFor10DigitISBNCheck % 11 == 0)
				return true;
			return false;
		} else {
			if (isbnFilteredData.matches("^[0-9-]+$")) {
				String isbnFiltered = isbnFilteredData.replaceAll("-", "");
				Stream.iterate(0, i -> i < 13, i -> i + 1).forEach(i -> {
					totalFor13DigitISBNCheck += i % 2 == 0
							? Integer.parseInt(Character.toString(isbnFiltered.charAt(i))) * 1
							: Integer.parseInt(Character.toString(isbnFiltered.charAt(i))) * 3;
				});
				if (totalFor13DigitISBNCheck % 10 == 0)
					return true;
			} else
				return false;
		}
		return false;
	}
}