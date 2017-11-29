package com.ubansi.DateTimeParser;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class ZonedDateTimeParser implements DateTimeParserInterface {

	private final static List<DateTimeFormatter> FORMATS = new ArrayList<DateTimeFormatter>() {
		{
			add(DateTimeFormatter.ISO_ZONED_DATE_TIME);
		}
	};
	@Override
	public LocalDateTime parse(String input) {

		// デフォルト解析を試す
		try {
			return ZonedDateTime.parse(input).toLocalDateTime();
		} catch (DateTimeParseException e) {

		}

		// 書式を指定して実行
		for (DateTimeFormatter format : FORMATS) {
			try {
				return ZonedDateTime.parse(input, format).toLocalDateTime();
			} catch (DateTimeParseException e) {

			}
		}
		return null;
	}

}
