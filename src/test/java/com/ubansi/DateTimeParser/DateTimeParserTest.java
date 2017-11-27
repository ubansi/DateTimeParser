package com.ubansi.DateTimeParser;

import java.time.ZoneOffset;

import org.junit.Test;

import junit.framework.TestCase;

public class DateTimeParserTest extends TestCase {

	@Test
	public void testSetZoneId() {
		DateTimeParser dtp = new DateTimeParser();
		dtp.setZoneOffset("+9");

		assertEquals("+09:00",ZoneOffset.of("+9").getId());
	}
}
