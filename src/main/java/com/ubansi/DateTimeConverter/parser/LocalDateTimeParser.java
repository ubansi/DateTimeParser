package com.ubansi.DateTimeConverter.parser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class LocalDateTimeParser extends TimeParser{

	private final static List<DateTimeFormatter> FORMATS = new ArrayList<DateTimeFormatter>() {
		{
			add(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
			add(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			add(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));

		}
	};
	@Override
	public LocalDateTime parse(String input) {
		failsMessages.clear();

		// デフォルト解析を試す
		try {
			return LocalDateTime.parse(input);
		} catch (DateTimeParseException e) {
			addExceptionMessage(e);
		}

		for (DateTimeFormatter formatter : FORMATS) {
			try {
				return LocalDateTime.parse(input, formatter);
			} catch (DateTimeParseException e) {
				addExceptionMessage(e);
			}
		}
		return null;
	}

}
