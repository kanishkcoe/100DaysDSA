package day4;
//Given an array of integers temperatures represents the daily temperatures,
//return an array answer such that answer[i] is the number of days you have to wait
//after the ith day to get a warmer temperature.
//If there is no future day for which this is possible, keep answer[i] == 0 instead.

import java.util.*;

public class DailyTemperature {

    public static void main(String[] args) {
        Integer [] temperatures = {89, 62, 70, 58, 47, 47, 46, 76, 100, 70};

        Integer[] output = getWarmerDays(temperatures);

        System.out.println("output = " + Arrays.toString(output));
    }

    private static Integer[] getWarmerDays(Integer[] temperatures) {
        Integer[] result = new Integer[temperatures.length];
        result[temperatures.length - 1] = 0;

        //this stack contains the indices of temperature which is in descending order.
        //the last element of stack will have the maximum temperature
        //the top will have the lowest temperature within the stack
        //we need the next larger element in the array for any index i
        Stack<Integer> indexStack = new Stack<>();
        indexStack.push(temperatures.length - 1);

        for (int i = temperatures.length - 2; i >= 0 ; i--) {
            System.out.println("--------------------------");
            int currentTemperature = temperatures[i];
            int currentIndex = i;
            System.out.println("currentIndex = " + currentIndex);
            System.out.println("currentTemperature = " + currentTemperature);
            System.out.println("indexStack = " + indexStack);
            if(!indexStack.isEmpty()) {
                if(temperatures[i] < temperatures[indexStack.peek()]) {
                    result[i] = indexStack.peek() - i;
                    indexStack.push(i);
                } else {
                    while(!indexStack.isEmpty() && temperatures[i] >= temperatures[indexStack.peek()]) {
                        System.out.println("popping out index = " + indexStack.peek() + ", temperature = " + temperatures[indexStack.peek()]);
                        indexStack.pop();
                    }
                    if(indexStack.isEmpty()) {
                        result[i] = 0;
                        indexStack.push(i);
                    } else {
                        result[i] = indexStack.peek() - i;
                        indexStack.push(i);
                    }
                }
            }
        }
        System.out.println("--------------------------");
        return result;
    }
}
