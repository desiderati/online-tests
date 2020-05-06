/*
 * Copyright (c) 2019 - Felipe Desiderati
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial
 * portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT
 * LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
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
