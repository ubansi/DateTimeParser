package com.ubansi.DateTimeConverter;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import com.ubansi.DateTimeConverter.parser.LocalDateParser;
import com.ubansi.DateTimeConverter.parser.LocalDateTimeParser;
import com.ubansi.DateTimeConverter.parser.OffsetDateTimeParser;
import com.ubansi.DateTimeConverter.parser.TimeParser;
import com.ubansi.DateTimeConverter.parser.TimestampParser;
import com.ubansi.DateTimeConverter.parser.ZonedDateTimeParser;

public class DateTimeParser {

	private final static List<TimeParser> PARSERS = new ArrayList<TimeParser>() {
		{
			add(new OffsetDateTimeParser());
			add(new ZonedDateTimeParser());
			add(new LocalDateTimeParser());
			add(new LocalDateParser());
			add(new TimestampParser());
		}
	};

	public LocalDateTime parse(String input) {

		LocalDateTime result = null;

		for (TimeParser parser : PARSERS) {
			result = parser.parse(input);

			if (result != null) {
				return result;
			}
		}

		PARSERS.forEach(parser -> parser.getExceptionInfo().forEach(s -> System.out.println(s)));

		throw new DateTimeParseException("解析に失敗しました。(\"" + input + "\")", input, 0);

	}

}
