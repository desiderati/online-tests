/*
 * Copyright (c) 2019 - Felipe Desiderati ALL RIGHTS RESERVED.
 *
 * This software is protected by international copyright laws and cannot be
 * used, copied, stored or distributed without prior authorization.
 */
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public class EmailThread {

    public static void main(String[] args) throws IOException {
        List<String> value = new ArrayList<String>();
        value.add("sv@outlook.com, gfdpdyf@gmail.com, n");
        value.add("wl@hackerrank.com, tk@outlook.com, m");
        value.add("gfdpdyf@gmail.com, sv@outlook.com, t.xg---n");
        value.add("sv@outlook.com, gfdpdyf@gmail.com, i---t.xg---n");
        value.add("tk@outlook.com, wl@hackerrank.com, o---m");
        value.add("tk@outlook.com, wl@hackerrank.com, w---o---m");
        value.add("tk@outlook.com, wl@hackerrank.com, nv---w---o---m");
        value.add("sv@outlook.com, gfdpdyf@gmail.com, cyhf---i---t.xg---n");
        System.out.println(getEmailThreads(value));
    }

    public static class Email {
        public String from;
        public String to;
        public String body;
        public Integer thread;
    }

    public static List<List<Integer>> getEmailThreads(List<String> emails) {
        List<List<Integer>> result = new ArrayList<>();

        Map<String, Email> threads = new HashMap<>();
        int threadCount = 0;
        for (String emailPart: emails) {
            String[] parts = emailPart.split(", ");

            Email email = new Email();
            email.to = parts[0];
            email.from = parts[1];
            email.body = concatenatedBody(2, parts, ", ");

            String[] bodyParts = email.body.split("---");
            if (bodyParts.length == 1) {
                threadCount++;
                email.thread = threadCount;
                threads.put(email.body, email);
                List<Integer> position = Arrays.asList(new Integer[]{email.thread , 1});
                result.add(position);

            } else {
                Email previousEmail = threads.get(concatenatedBody(1, bodyParts, "---"));
                if ((previousEmail.to.equals(email.from) && previousEmail.from.equals(email.to))
                        || (previousEmail.from.equals(email.from) && previousEmail.to.equals(email.to))) {

                    email.thread = previousEmail.thread;
                    threads.put(email.body, email);
                    List<Integer> position = Arrays.asList(new Integer[]{email.thread , bodyParts.length});
                    result.add(position);
                }
            }
        }

        return result;
    }

    public static String concatenatedBody(int skip, String[] parts, String delimiter) {
        String shiftedParts =
            Arrays.stream(parts)
                .skip(skip)
                .map(n -> n.toString())
                .collect(joining(delimiter));
        return shiftedParts.trim();
    }
}