package com.ubansi.DateTimeConverter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;

public class DateTimeParserTest extends TestCase {
	private DateTimeParser dtp = new DateTimeParser();
	private DateTimeFormatter formater = DateTimeFormatter.ISO_DATE_TIME;

	@Test
	public void testDateFormat() {
		List<String> dates = new ArrayList<String>() {
			{
				add("2017-12-02");
				add("17-12-02");
				add("17-12-2");
				add("20171202");
				add("2017/12/02");
				add("2017/12/2");
				add("2017年12月2日");

			}
		};

		for (String date : dates) {
			LocalDateTime time = dtp.parse(date);

			assertEquals(time.format(formater), "2017-12-02T00:00:00");
		}

	}

	@Test
	public void testDateTimeFormat() {
		List<String> datetimes = new ArrayList<String>() {
			{
				add("2017-12-02 12:01:02");
				add("2017/12/02 12:01:02");
				add("1512183662");
			}
		};

		for (String date : datetimes) {
			LocalDateTime time = dtp.parse(date);

			assertEquals(time.format(formater), "2017-12-02T12:01:02");
		}
	}

	@Test
	public void testEmptyInput() {

		try {
			LocalDateTime time = dtp.parse("");
			assertTrue(false);

		} catch (DateTimeParseException e) {
			assertEquals(e.getMessage(),"解析に失敗しました。(\"\")");
		}
	}
}
