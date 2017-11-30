package com.ubansi.DateTimeConverter.parser;

import java.time.LocalDateTime;

public interface DateTimeParserInterface {

	/**
	 * This function forcibly converts a string to a date.
	 *<p>
	 * If the return value is null, please throw an {@code DateTimeParseException}.
	 * </p>
	 * @param input
	 * @return LocalDateTime instance or {@code null}
	 */
	public LocalDateTime parse(String input);
}
