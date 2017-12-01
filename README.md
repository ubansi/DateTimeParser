# DateTimeParser
String to LocalDateTime Sample

This module was created for (Java Advent Calendar 2017)[https://qiita.com/advent-calendar/2017/java].

# How to use

## get LocalDateTime instance
```java:sample.java

String date = "2017/12/02";
DateTimeParser dtp = new DateTimeParser();
LocalDateTime result = dtp.parse(date);

```

## error log
When output standard IO in `DateTimeParser#parse`.
It is output when failure occurs in all formats.
