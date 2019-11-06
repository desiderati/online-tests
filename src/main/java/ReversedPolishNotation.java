/*
 * Copyright (c) 2019 - Felipe Desiderati ALL RIGHTS RESERVED.
 *
 * This software is protected by international copyright laws and cannot be
 * used, copied, stored or distributed without prior authorization.
 */
import java.util.Stack;

public class ReversedPolishNotation {

    public static void main(String[] args) {
        System.out.println(calc("5 4 +"));
        System.out.println(calc("5 4 + 3 -"));
        System.out.println(calc("20 7 1 2 + - / 3 * 2 1 10 + + -"));
    }

    private static Integer calc(String input) {
        Stack<Integer> numbers = new Stack<>();
        for (String element : input.split(" ")) {
            int first;
            int second;
            switch (element) {
                case "+":
                    first = numbers.pop();
                    second = numbers.pop();
                    numbers.push(second + first);
                    break;

                case "-":
                    first = numbers.pop();
                    second = numbers.pop();
                    numbers.push(second - first);
                    break;

                case "*":
                    first = numbers.pop();
                    second = numbers.pop();
                    numbers.push(second * first);
                    break;

                case "/":
                    first = numbers.pop();
                    second = numbers.pop();
                    numbers.push(second / first);
                    break;

                default:
                    numbers.push(Integer.parseInt(element));
                    break;
            }
        }
        return numbers.pop();
    }
}
