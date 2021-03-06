package com.ubansi.DateTimeConverter.parser;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class LocalDateParser extends TimeParser {

	// フォーマットを片っ端から定義
	private final static List<DateTimeFormatter> FORMATS = new ArrayList<DateTimeFormatter>() {
		{
			add(DateTimeFormatter.ISO_LOCAL_DATE);
			add(DateTimeFormatter.BASIC_ISO_DATE);
			add(DateTimeFormatter.ISO_DATE);
			add(DateTimeFormatter.ofPattern("yy-MM-dd"));
			add(DateTimeFormatter.ofPattern("yy-M-d"));
			add(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
			add(DateTimeFormatter.ofPattern("yyyy/M/d"));
			add(DateTimeFormatter.ofPattern("yyyy年M月d日"));

		}
	};

	@Override
	public LocalDateTime parse(String input) {
		failsMessages.clear();

		// デフォルト解析を試す
		try {
			return LocalDate.parse(input).atStartOfDay();
		} catch (DateTimeParseException e) {
			addExceptionMessage(e);
		}

		// 指定フォーマットで解析
		for (DateTimeFormatter formatter : FORMATS) {
			try {
				return LocalDate.parse(input, formatter).atStartOfDay();
			} catch (DateTimeParseException e) {
				// 失敗したログはリストへ保存しておく
				addExceptionMessage(e);
			}
		}
		return null;
	}
}
