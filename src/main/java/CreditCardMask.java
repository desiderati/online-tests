/*
 * Copyright (c) 2019 - Felipe Desiderati ALL RIGHTS RESERVED.
 *
 * This software is protected by international copyright laws and cannot be
 * used, copied, stored or distributed without prior authorization.
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


