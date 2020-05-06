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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PackNumbers {

    // Complete the packNumbers function below.
    static List<String> packNumbers(List<Integer> arr) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            Integer item = arr.get(i);

            int numSibling = 1;
            for (int j = i+1; j < arr.size(); j++) {
                Integer nextItem = arr.get(j);
                if (item.equals(nextItem)) {
                    numSibling++;
                    i++;
                } else {
                    break;
                }
            }

            if (numSibling == 1) {
                result.add(String.valueOf(item));
            } else {
                result.add(item + ":" + numSibling);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{255, 255, 67, 12, 12, 12, 36, 89, 89, 54, 2, 12, 36, 36, 36};
        System.out.println(packNumbers(Arrays.asList(arr)));
    }
}