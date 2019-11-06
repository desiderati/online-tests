/*
 * Copyright (c) 2019 - Felipe Desiderati ALL RIGHTS RESERVED.
 *
 * This software is protected by international copyright laws and cannot be
 * used, copied, stored or distributed without prior authorization.
 */
public class RoundingRules {

    public static void main(String[] args) {
        System.out.println(roundPayment(50));
        System.out.println(roundPayment(51));
        System.out.println(roundPayment(74));
        System.out.println(roundPayment(75));
        System.out.println(roundPayment(99));
        System.out.println(roundPayment(100));
        System.out.println(roundPayment(5524));
        System.out.println(roundPayment(5525));
        System.out.println(roundPayment(5549));
        System.out.println(roundPayment(5550));
        System.out.println(roundPayment(5574));
        System.out.println(roundPayment(5575));
        System.out.println(roundPayment(5599));
        System.out.println(roundPayment(5600));
    }

    private static int roundPayment(int payment) {
        int mod = payment % 100;
        int round;
        if (mod <= 24) {
            round = 0;
        } else if (mod <= 74) {
            round = 50;
        } else {
            round = 100;
        }
        return ((payment / 100) * 100) + round;
    }
}
