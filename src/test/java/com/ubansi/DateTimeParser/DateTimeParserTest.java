package com.ubansi.DateTimeParser;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;

public class DateTimeParserTest extends TestCase {
	private DateTimeParser dtp = new DateTimeParser();
	private DateTimeFormatter formater = DateTimeFormatter.ISO_DATE_TIME;

	@Test
	public void testSetZoneId() {
		DateTimeParser dtp = new DateTimeParser();
		dtp.setZoneOffset("+9");

		assertEquals("+09:00", ZoneOffset.of("+9").getId());
	}

	@Test
	public void testMySQLFormat() {
		List<String> mysqlDates = new ArrayList<String>() {
			{
				add("2017-12-02");
			}
		};

		for (String date : mysqlDates) {
			LocalDateTime time = dtp.parse(date);

			assertEquals(time.format(formater),"2017-12-02T00:00:00");
		}

	}
}
