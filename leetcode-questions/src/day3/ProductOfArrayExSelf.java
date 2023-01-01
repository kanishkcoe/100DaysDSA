package day3;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// Given an integer array nums,
// return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
// You must write an algorithm that runs in O(n) time and without using the division operation.
public class ProductOfArrayExSelf {

    public static void main(String[] args) {
        Integer [] numbers = {-1,1,0,-3,3};

        List<Integer> output = getProductArray(numbers);

        System.out.println("output = " + output);
    }

    private static List<Integer> getProductArray(Integer[] numbers) {
        Integer zeroCounter = 0;
        List<Integer> output = new LinkedList<>();
        Integer combinedProduct = 1;
        for (Integer number : numbers) {
            if(number == 0) {
                zeroCounter++;
            } else {
                combinedProduct *= number;
            }
        }

        if (zeroCounter > 1) {
            return Collections.nCopies(numbers.length, 0);
        }
        for (Integer number : numbers) {
            if(zeroCounter == 1) {
                if(number != 0) {
                    output.add(0);
                } else {
                    output.add(combinedProduct);
                }
            } else {
                output.add(combinedProduct / number);
            }
        }

        return output;
    }
}
