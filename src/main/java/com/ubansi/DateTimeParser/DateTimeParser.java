package com.ubansi.DateTimeParser;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DateTimeParser {

	private final static List<DateTimeFormatter> LOCAL_DATE_FORMAT = new ArrayList<DateTimeFormatter>() {
		{
			add(DateTimeFormatter.BASIC_ISO_DATE);
		}
	};

	private ZoneOffset zoneOffset = ZoneOffset.UTC;

	public LocalDateTime parse(String input) {

		return null;
	}

	public ZoneOffset getZoneOffset() {
		return zoneOffset;
	}

	public void setZoneOffset(String timeZone) {
		this.zoneOffset = ZoneOffset.of(timeZone);
	}


}
