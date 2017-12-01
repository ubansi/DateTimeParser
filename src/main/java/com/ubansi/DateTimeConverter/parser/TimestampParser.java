package com.ubansi.DateTimeConverter.parser;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TimestampParser implements DateTimeParserInterface {

	private List<String> info = new ArrayList<String>();

	@Override
	public LocalDateTime parse(String input) {
		info.clear();
		try {
			Timestamp timestamp = new Timestamp(Long.parseLong(input) * 1000L);
			return timestamp.toLocalDateTime();
		} catch (NumberFormatException e) {
			info.add(e.getMessage());
		}

		return null;
	}

	@Override
	public List<String> getExceptionInfo() {
		return info;
	}

}
