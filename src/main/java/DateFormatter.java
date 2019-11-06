/*
 * Copyright (c) 2019 - Felipe Desiderati ALL RIGHTS RESERVED.
 *
 * This software is protected by international copyright laws and cannot be
 * used, copied, stored or distributed without prior authorization.
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class DateFormatter {

    public static void main(String[] args) throws ParseException {
        System.out.println(convertDate(removeDaySuffix("20th Oct 2052")));
        System.out.println(convertDate(removeDaySuffix("1st Mar 1984")));
        System.out.println(convertDate(removeDaySuffix("2nd Feb 2013")));
        System.out.println(convertDate(removeDaySuffix("4th Apr 1900")));
        System.out.println(convertDate(removeDaySuffix("25th May 1912")));
        System.out.println(convertDate(removeDaySuffix("16th Dec 2061")));
        System.out.println(convertDate(removeDaySuffix("3rd Nov 1963")));
    }

    private static String removeDaySuffix(String date) {
        return date.replace("st", "")
            .replace("nd", "")
            .replace("rd", "")
            .replace("th", "");
    }

    private static String convertDate(String date) throws ParseException {
        SimpleDateFormat inputSimpleDateFormat =
            new SimpleDateFormat("dd MMM yyyy", new Locale("en", "US"));
        SimpleDateFormat outputSimpleDateFormat =
            new SimpleDateFormat("yyyy-MM-dd", new Locale("en", "US"));
        return outputSimpleDateFormat.format(inputSimpleDateFormat.parse(date));
    }
}
