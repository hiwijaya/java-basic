package com.hiwijaya.javabasic;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 *
 */
public class LocalDateExample {

    static void localDateExample() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
    }

    static void formatterExample() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm:ss");

        System.out.println(localDateTime.format(formatter));
        System.out.println(localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }

    static void manipulateExample() {
        LocalDate localDate = LocalDate.now();

        localDate = localDate.plusDays(1);
        System.out.println(localDate);

        localDate = localDate.minusMonths(1);
        System.out.println(localDate);
    }

    static void compareExample() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nextHour = now.plusHours(1);

        if(now.isBefore(nextHour)) {
            System.out.printf("true: %s < %s", now, nextHour);
        }
        else {
            System.out.println("false");
        }
    }

    static void timezoneExample() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Jayapura"));
        LocalDateTime utcDateTime = LocalDateTime.now(ZoneOffset.UTC);

        System.out.println(zonedDateTime);
        System.out.println(utcDateTime);
    }

    static void main(String[] args) {
        localDateExample();
        formatterExample();
        manipulateExample();
        compareExample();
        timezoneExample();
    }

}
