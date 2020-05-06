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
