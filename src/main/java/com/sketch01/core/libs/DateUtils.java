package com.sketch01.core.libs;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

import static java.time.format.DateTimeFormatter.ofPattern;
import static org.apache.commons.lang3.StringUtils.containsAny;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class DateUtils {

    public final static DateTimeFormatter HH             = ofPattern("HH");
    public final static DateTimeFormatter HHmm           = ofPattern("HHmm");
    public final static DateTimeFormatter HHmmss         = ofPattern("HHmmss");
    public final static DateTimeFormatter MMdd           = ofPattern("MMdd");
    public final static DateTimeFormatter yyyy           = ofPattern("yyyy");
    public final static DateTimeFormatter MM             = ofPattern("MM");
    public final static DateTimeFormatter dd             = ofPattern("dd");
    public final static DateTimeFormatter d              = ofPattern("d");
    public final static DateTimeFormatter yyMM           = ofPattern("yyMM");
    public final static DateTimeFormatter yMMdd          = ofPattern("yMMdd");
    public final static DateTimeFormatter yyMMdd         = ofPattern("yyMMdd");
    public final static DateTimeFormatter yyyyMM         = ofPattern("yyyyMM");
    public final static DateTimeFormatter yyMMddHH       = ofPattern("yyMMddHH");
    public final static DateTimeFormatter yyyyMMdd       = ofPattern("yyyyMMdd");
    public final static DateTimeFormatter yyyyMMddHH     = ofPattern("yyyyMMddHH");
    public final static DateTimeFormatter yyyyMMddHHmm   = ofPattern("yyyyMMddHHmm");
    public final static DateTimeFormatter yyyyMMddHHmmss = ofPattern("yyyyMMddHHmmss");
    public final static DateTimeFormatter yyMMddHHmmss   = ofPattern("yyMMddHHmmss");
    public final static DateTimeFormatter D              = ofPattern("E");

    public final static DateTimeFormatter yyyyMMddHHmmssSSS = new DateTimeFormatterBuilder()
            .appendPattern("yyyyMMddHHmmss")
            .appendValue(ChronoField.MILLI_OF_SECOND, 3)
            .toFormatter();

    public final static DateTimeFormatter IOS_HHmm               = ofPattern("HH:mm");
    public final static DateTimeFormatter IOS_HHmmss             = ofPattern("HH:mm:ss");
    public final static DateTimeFormatter IOS_yyyyMMdd           = ofPattern("yyyy-MM-dd");
    public final static DateTimeFormatter IOS_yyyyMMddHH         = ofPattern("yyyy-MM-dd'T'HH");
    public final static DateTimeFormatter IOS_yyyyMMddHHmm       = ofPattern("yyyy-MM-dd'T'HH:mm");
    public final static DateTimeFormatter IOS_yyyyMMddHHmmss     = ofPattern("yyyy-MM-dd'T'HH:mm:ss");
    public final static DateTimeFormatter IOS_yyyyMMddHHmmssSSS  = ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
    public final static DateTimeFormatter IOS_yyyyMMdd_HH        = ofPattern("yyyy-MM-dd HH");
    public final static DateTimeFormatter IOS_yyyyMMdd_HHmm      = ofPattern("yyyy-MM-dd HH:mm");
    public final static DateTimeFormatter IOS_yyyyMMdd_HHmmss    = ofPattern("yyyy-MM-dd HH:mm:ss");
    public final static DateTimeFormatter IOS_yyyyMMdd_HHmmssSSS = ofPattern("yyyy-MM-dd HH:mm:ss.SSS");


    public static boolean isNotValid(String date) {
        try {
            parseDateTime(date);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public static boolean contains(LocalDateTime fromDateTime, LocalDateTime toDateTime) {
        return contains(fromDateTime, toDateTime, LocalDateTime.now());
    }

    public static boolean contains(LocalDateTime fromDateTime, LocalDateTime toDateTime, LocalDateTime checkDateTime) {
        return (checkDateTime.equals(fromDateTime) || checkDateTime.isAfter(fromDateTime))
                && (checkDateTime.equals(toDateTime) || checkDateTime.isBefore(toDateTime));
    }

    public static boolean contains(LocalDate fromDate, LocalDate toDate) {
        return contains(fromDate, toDate, LocalDate.now());
    }

    public static boolean contains(LocalDate fromDate, LocalDate toDate, LocalDate checkDate) {
        return (checkDate.equals(fromDate) || checkDate.isAfter(fromDate))
                && (checkDate.equals(toDate) || checkDate.isBefore(toDate));
    }

    public static String format(String date, String toFormat) {
        DateTimeFormatter toFormatter = ofPattern(toFormat);
        if ("yyyyMMddHHmmssSSS".equals(toFormat)) {
            toFormatter = yyyyMMddHHmmssSSS;
        }
        return format(date, toFormatter);
    }

    public static String format(String date, DateTimeFormatter toFormat) {
        return parseDateTime(date).format(toFormat);
    }

    public static String format(LocalDateTime date, DateTimeFormatter toFormat) {
        return date.format(toFormat);
    }

    public static String format(LocalDate date, DateTimeFormatter toFormat) {
        return date.format(toFormat);
    }

    public static LocalDate parseDate(String date) {
        if( isBlank(date) ) {
            return null;
        }
        return LocalDate.parse(date, getFormatter(date));
    }

    public static LocalDateTime parseDateTime(String date) {
        DateTimeFormatter formatter = getFormatter(date);
        if (formatter == yyyyMMdd) {
            return LocalDateTime.parse(date + "00", yyyyMMddHH);
        }
        if (formatter == IOS_yyyyMMdd) {
            return LocalDateTime.parse(date + "T00", IOS_yyyyMMddHH);
        }
        return LocalDateTime.parse(date, formatter);
    }

    public static LocalDateTime parseDateTimeLastTm(String date) {
        return LocalDateTime.parse(date + "235959", yyyyMMddHHmmss);
    }

    public static LocalDateTime parseDateTimeFirstTm(String date) {
        return LocalDateTime.parse(date + "000000", yyyyMMddHHmmss);
    }

    public static String parseDateTimeLastTmSlash(String date) {
        StringBuffer str = new StringBuffer(date);
        str.insert(4,'/');
        str.insert(7,'/');
        str.insert(10,'/');

        return str + "23/59/59";
    }

    public static String parseDateTimeFirstTmSlash(String date) {
        StringBuffer str = new StringBuffer(date);
        str.insert(4,'/');
        str.insert(7,'/');
        str.insert(10,'/');

        return str + "00/00/00";
    }

    public static LocalTime parseTime(String date) {
        DateTimeFormatter formatter = getFormatter(date);
        if (formatter == yyyyMMdd) {
            return LocalTime.parse(date + "00", yyyyMMddHH);
        }
        if (formatter == IOS_yyyyMMdd) {
            return LocalTime.parse(date + "T00", IOS_yyyyMMddHH);
        }
        return LocalTime.parse(date, getFormatter(date));
    }

    private static DateTimeFormatter getFormatter(String date) {
        if (isBlank(date)) {
            throw new IllegalArgumentException("유효하지 않은 date 타입 입니다.");
        }

        int length = date.length();

        if (containsAny(date, "-", ":")) {
            if (length == 5)
                return IOS_HHmm;
            if (length == 8)
                return IOS_HHmmss;
            if (length == 10)
                return IOS_yyyyMMdd;

            if (StringUtils.contains(date, "T")) {
                if (length == 13)
                    return IOS_yyyyMMddHH;
                if (length == 16)
                    return IOS_yyyyMMddHHmm;
                if (length == 19)
                    return IOS_yyyyMMddHHmmss;
                if (length == 23)
                    return IOS_yyyyMMddHHmmssSSS;
            } else {
                if (length == 13)
                    return IOS_yyyyMMdd_HH;
                if (length == 16)
                    return IOS_yyyyMMdd_HHmm;
                if (length == 19)
                    return IOS_yyyyMMdd_HHmmss;
                if (length == 23)
                    return IOS_yyyyMMdd_HHmmssSSS;
            }
        } else {
            if (length == 4)
                return HHmm;
            if (length == 6)
                return HHmmss;
            if (length == 8)
                return yyyyMMdd;
            if (length == 10)
                return yyyyMMddHH;
            if (length == 12)
                return yyyyMMddHHmm;
            if (length == 14)
                return yyyyMMddHHmmss;
            if (length == 17)
                return yyyyMMddHHmmssSSS;
        }
        throw new IllegalArgumentException("유효하지 않은 date 타입 입니다.");
    }

    public static String date6() {
        return format(LocalDate.now(), DateUtils.yyyyMM);
    }

    public static String date8() {
        return format(LocalDate.now(), DateUtils.yyyyMMdd);
    }

    public static String date14() {
        return format(LocalDateTime.now(), DateUtils.yyyyMMddHHmmss);
    }

    public static String date12() {
        return format(LocalDateTime.now(), DateUtils.yyMMddHHmmss);
    }

    public static String currentYear() {
        return format(LocalDate.now(), DateUtils.yyyy);
    }

    public static String currentMonth() {
        return format(LocalDate.now(), DateUtils.MM);
    }

    public static String currentDay() {
        return format(LocalDate.now(), DateUtils.dd);
    }

}
