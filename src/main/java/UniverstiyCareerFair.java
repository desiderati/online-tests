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
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class UniverstiyCareerFair {

    public static void main(String[] args) {
        System.out.println(maxEvents(Arrays.asList(1, 3, 3, 5, 7), Arrays.asList(2, 2, 1, 2, 1)));
        System.out.println(maxEvents(Arrays.asList(1, 3, 5), Arrays.asList(2, 2, 2)));
        System.out.println(maxEvents(Arrays.asList(1, 4, 5, 5, 7), Arrays.asList(5, 2, 1, 2, 1)));
        System.out.println(maxEvents(Arrays.asList(1, 4, 6, 6, 7), Arrays.asList(5, 2, 1, 2, 1)));
        System.out.println(maxEvents(Arrays.asList(1, 4, 6, 6, 7), Arrays.asList(5, 2, 2, 3, 1)));
    }

    public static int maxEvents(List<Integer> arrival, List<Integer> duration) {
        // I need to choose a solution with the most companies served.
        int companiesServed = 0;
        int totalTime = 0;

        for (int i = 0; i < arrival.size(); i++) {
            int currentArrival = arrival.get(i);
            int currentDuration = duration.get(i);

            if (currentArrival >= totalTime) {
                totalTime = currentArrival;

                // I need to check if there are other companies starting at this same time.
                for (int j = i + 1; j < arrival.size(); j++) {
                    int nextArrival = arrival.get(j);
                    int nextDuration = duration.get(j);

                    if (nextArrival == currentArrival) {
                        // If so I need to check the one with less duration.
                        currentArrival = (currentDuration > nextDuration)? nextArrival : currentArrival;
                        currentDuration = (currentDuration > nextDuration)? nextDuration : currentDuration;
                        i = j;
                    } else {
                        break;
                    }
                }

                totalTime += (currentDuration);
                companiesServed++;
            }
        }

        return companiesServed;
    }
}
