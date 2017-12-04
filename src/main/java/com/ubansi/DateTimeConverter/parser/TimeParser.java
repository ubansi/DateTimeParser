package com.ubansi.DateTimeConverter.parser;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class TimeParser {

	/**
	 * fails info
	 */
	protected List<String> failsMessages = new ArrayList<>();

	/**
	 * This function forcibly converts a string to a date.
	 *<p>
	 * If the return value is null, please throw an {@code DateTimeParseException}.
	 * </p>
	 * @param input
	 * @return LocalDateTime instance or {@code null}
	 */
	public abstract LocalDateTime parse(String input);

	protected void addExceptionMessage(Exception e) {
		failsMessages.add(e.getMessage() + " ("+this.getClass().getSimpleName()+")");
	}

	public List<String> getExceptionInfo(){
		return failsMessages;
	};
}
