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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class CreditCardMask {

    public static void main(String[] args) {

        String log = "{'name':'Maria Rosa','phone':'12378921821','address':'R: João Rodrigues'," +
            "'amount':120.03,'creditcard':{'number':'123456777774321'}},{creditcard:123456789012345678}";

        String maskedLog = null;
        do {
            if (maskedLog != null) {
                log = maskedLog;
            }
            maskedLog = maskCreditCard(log);
        } while(!log.equals(maskedLog));
        System.out.println(maskedLog);
    }

    private static String maskCreditCard(String log) {
        String patternStr = "(.*[:'\"])([0-9]{15,19})(['\"},].*)";
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(log);
        if (!matcher.matches()) {
            return log;
        }

        String prefix = matcher.group(1);
        String suffix = matcher.group(3);

        String creditCard = matcher.group(2);
        int asteriskSize = creditCard.length() - 6 - 4;
        final StringBuilder asterisk = new StringBuilder("*");
        IntStream.range(0, asteriskSize).forEach(i -> {
            asterisk.append("*");
        });
        String maskedCreditcard =
            creditCard.replaceAll("([0-9]{6})([0-9]*)([0-9]{4})", "$1" + asterisk + "$3");

        return prefix + maskedCreditcard + suffix;
    }
}


