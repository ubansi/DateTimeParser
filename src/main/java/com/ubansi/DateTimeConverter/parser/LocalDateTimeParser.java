package com.ubansi.DateTimeConverter.parser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class LocalDateTimeParser implements DateTimeParserInterface{

	private List<String> info = new ArrayList<String>();

	private final static List<DateTimeFormatter> FORMATS = new ArrayList<DateTimeFormatter>() {
		{
			add(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
			add(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		}
	};
	@Override
	public LocalDateTime parse(String input) {
		info.clear();

		// デフォルト解析を試す
		try {
			return LocalDateTime.parse(input);
		} catch (DateTimeParseException e) {
			info.add(e.getMessage());
		}

		for (DateTimeFormatter formatter : FORMATS) {
			try {
				return LocalDateTime.parse(input, formatter);
			} catch (DateTimeParseException e) {
				info.add(e.getMessage());
			}
		}
		return null;
	}
	@Override
	public List<String> getExceptionInfo() {
		return info;
	}

}
