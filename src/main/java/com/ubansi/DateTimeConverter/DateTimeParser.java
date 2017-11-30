package com.ubansi.DateTimeConverter;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import com.ubansi.DateTimeConverter.parser.DateTimeParserInterface;
import com.ubansi.DateTimeConverter.parser.LocalDateParser;
import com.ubansi.DateTimeConverter.parser.LocalDateTimeParser;
import com.ubansi.DateTimeConverter.parser.OffsetDateTimeParser;
import com.ubansi.DateTimeConverter.parser.ZonedDateTimeParser;

public class DateTimeParser {

	private final static List<DateTimeParserInterface> PARSERS = new ArrayList<DateTimeParserInterface>() {
		{
			add(new OffsetDateTimeParser());
			add(new ZonedDateTimeParser());
			add(new LocalDateTimeParser());
			add(new LocalDateParser());
		}
	};

	public LocalDateTime parse(String input) {

		LocalDateTime result = null;

		for(DateTimeParserInterface parser: PARSERS) {
			result = parser.parse(input);

			if (result != null) {
				return result;
			}
		}

		if (result == null) {
			throw new DateTimeParseException("日付の解析に失敗しました。", input, 0);
		}
		return result;
	}

}
