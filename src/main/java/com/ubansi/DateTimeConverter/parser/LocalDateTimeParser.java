package com.ubansi.DateTimeConverter.parser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class LocalDateTimeParser implements DateTimeParserInterface{
	private final static List<DateTimeFormatter> FORMATS = new ArrayList<DateTimeFormatter>() {
		{
			add(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
			add(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		}
	};
	@Override
	public LocalDateTime parse(String input) {

		// デフォルト解析を試す
		try {
			return LocalDateTime.parse(input);
		} catch (DateTimeParseException e) {
			// デフォルト解析失敗
		}

		for (DateTimeFormatter formatter : FORMATS) {
			try {
				return LocalDateTime.parse(input, formatter);
			} catch (DateTimeParseException e) {
				// 日付に変換できなかった
			}
		}
		return null;
	}

}
