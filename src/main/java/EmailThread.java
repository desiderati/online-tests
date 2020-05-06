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