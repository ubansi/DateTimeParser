package com.ubansi.DateTimeConverter.parser;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class TimestampParser extends TimeParser {


	@Override
	public LocalDateTime parse(String input) {
		failsMessages.clear();
		try {
			Timestamp timestamp = new Timestamp(Long.parseLong(input) * 1000L);
			return timestamp.toLocalDateTime();
		} catch (NumberFormatException e) {
			failsMessages.add(e.getMessage());
		}

		return null;
	}

	@Override
	public List<String> getExceptionInfo() {
		return failsMessages;
	}

}
