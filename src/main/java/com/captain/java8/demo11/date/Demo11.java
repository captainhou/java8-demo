package com.captain.java8.demo11.date;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;

public class Demo11 {
	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2017, Month.NOVEMBER, 10);
		LocalTime time = LocalTime.of(15, 0, 0);
		LocalDateTime dateTime1 = date.atTime(time);
		LocalDateTime dateTime2 = LocalDateTime.of(2017, Month.NOVEMBER, 20, 16, 0, 0);
		System.out.println(dateTime1.equals(dateTime2));// true

		// duration
		Duration d2 = Duration.between(dateTime1, dateTime2);
		System.out.println(d2);// PT-1H-30M
		System.out.println(d2.get(ChronoUnit.SECONDS));// SECONDS,NANOS//867600

		LocalDate date2 = LocalDate.of(2017, 11, 11);
		// period
		Period p1 = Period.between(date, date2);
		System.out.println(p1);// P1D
		System.out.println(p1.get(ChronoUnit.DAYS));// YEARS,MONTHS,DAYS //1
		System.out.println(p1.get(ChronoUnit.MONTHS));// YEARS,MONTHS,DAYS //0
		//modify
		LocalDate date3 = LocalDate.of(2017, Month.NOVEMBER, 10);//2017-11-10
		LocalDate date4 = date3.withYear(2018);//2018-11-10
		LocalDate date5 = date4.with(ChronoField.MONTH_OF_YEAR, 9);//2018-9-10
		LocalDate date6 = date5.plus(1,ChronoUnit.DAYS);//2018-9-11 //
		//high lights
		LocalDate date7 =date3.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));//2017-11-12
		//format
		String s1 = date3.format(DateTimeFormatter.ISO_DATE);
		LocalDate date8 = LocalDate.parse("2017-11-20", DateTimeFormatter.ISO_DATE);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String s2 = date3.format(formatter);//10/11/2017

	}

}
