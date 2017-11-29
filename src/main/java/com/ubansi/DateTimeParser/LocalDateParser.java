package com.ubansi.DateTimeParser;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class LocalDateParser implements DateTimeParserInterface {

	private final static List<DateTimeFormatter> FORMATS = new ArrayList<DateTimeFormatter>() {
		{
			add(DateTimeFormatter.ISO_LOCAL_DATE);
			add(DateTimeFormatter.BASIC_ISO_DATE);
			add(DateTimeFormatter.ofPattern("yy-MM-dd"));
			add(DateTimeFormatter.ofPattern("yy-M-d"));

		}
	};

	@Override
	public LocalDateTime parse(String input) {

		// デフォルト解析を試す

		try {
			return LocalDate.parse(input).atStartOfDay();
		} catch (DateTimeParseException e) {
			// TODO: handle exception
		}

		for (DateTimeFormatter formatter : FORMATS) {
			try {
				return LocalDate.parse(input, formatter).atStartOfDay();
			} catch (DateTimeParseException e) {
				// 日付に変換できなかった
			}
		}
		return null;
	}

}
