package com.ubansi.DateTimeParser;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class DateTimeParser {

	private final static List<DateTimeFormatter> LOCAL_DATE_FORMAT_LIST = new ArrayList<DateTimeFormatter>() {
		{
			add(DateTimeFormatter.ISO_LOCAL_DATE);
			add(DateTimeFormatter.BASIC_ISO_DATE);
		}
	};

	private ZoneOffset zoneOffset = ZoneOffset.UTC;

	public LocalDateTime parse(String input) {

		LocalDateTime result= null;

		for(DateTimeFormatter formatter: LOCAL_DATE_FORMAT_LIST) {
			try {
			LocalDate date = LocalDate.parse(input, formatter);
			result =  date.atStartOfDay();
			}catch(DateTimeParseException e) {
				System.out.println(e.getMessage());
			}

		}

		if(result== null) {
			throw new DateTimeParseException("日付の解析に失敗しました。", input, 0);
		}

		return result;
	}

	public ZoneOffset getZoneOffset() {
		return zoneOffset;
	}

	public void setZoneOffset(String timeZone) {
		this.zoneOffset = ZoneOffset.of(timeZone);
	}


}
