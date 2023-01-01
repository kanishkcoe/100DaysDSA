package day4;
//Given an array of integers temperatures represents the daily temperatures,
//return an array answer such that answer[i] is the number of days you have to wait
//after the ith day to get a warmer temperature.
//If there is no future day for which this is possible, keep answer[i] == 0 instead.

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DailyTemperature {

    public static void main(String[] args) {
        Integer [] temperatures = {73,74,75,71,69,81,72,76,73,79};

        List<Integer> output = getWarmerDays(temperatures);

        System.out.println("output = " + output);
    }

    private static List<Integer> getWarmerDays(Integer[] temperatures) {
        List<Integer> result = new LinkedList<>();
        result.add(0);
        Stack<Integer> stack = new Stack<>();
        stack.push(temperatures[temperatures.length - 1]);

        for (int i = temperatures.length - 2; i >= 0; i--) {
            Boolean stackEmpty = false;
            Integer popCount = 0;
            while (temperatures[i] > stack.peek()) {
                stack.pop();
                popCount++;
                if(stack.isEmpty()) {
                    result.add(0,0);
                    stackEmpty = true;
                    break;
                }
            }
            for (int j = 0; j < popCount + 1; j++) {
                stack.push(temperatures[i]);
            }
            if(!stackEmpty)
                result.add(0,popCount + 1);
        }

        return result;
    }
}
