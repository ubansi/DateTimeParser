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

	// エラー保持用リスト
	private List<String> errors = new ArrayList<String>();
	// 解析クラスを作成
	private final static List<TimeParser> PARSERS = new ArrayList<TimeParser>() {
		{
			// 情報量が多い順に解析する
			add(new ZonedDateTimeParser());
			add(new OffsetDateTimeParser());
			add(new LocalDateTimeParser());
			add(new LocalDateParser());
			add(new TimestampParser());
		}
	};

	public LocalDateTime parse(String input) {
		errors.clear();

		LocalDateTime result = null;

		for (TimeParser parser : PARSERS) {
			result = parser.parse(input);

			// 成功した時点で結果を返す
			if (result != null) {
				return result;
			}
			errors.addAll(parser.getExceptionInfo());
		}

		throw new DateTimeParseException("解析に失敗しました。(\"" + input + "\")", input, 0);

		// return がない！
	}

	public List<String> getErrors(){
		return errors;
	}

}
