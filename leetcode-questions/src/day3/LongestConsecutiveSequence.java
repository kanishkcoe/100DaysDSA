package day3;

import java.util.*;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        Integer [] numbers = {0,3,7,2,5,8,4,6,0,1};

        Integer output = getLongestConsecutiveSequenceUsingSet(numbers);

        System.out.println("output = " + output);
    }

    private static Integer getLongestConsecutiveSequenceUsingSet(Integer[] numbers) {
        if(numbers.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for(Integer number : numbers) set.add(number);

        Integer overallMax = 1;

        for(Integer number : set) {
            Integer currentMax = 1;
            if (!set.contains(number - 1)) {
                while(set.contains(number + currentMax)) {
                    currentMax++;
                }
            }
            overallMax = Math.max(overallMax, currentMax);
        }

        return overallMax;
    }

    private static Integer getLongestConsecutiveSequenceUsingPriorityQueue(Integer [] numbers) {
        Integer currentMax = 1;
        Integer overallMax = 1;
        Queue<Integer> minHeap = new PriorityQueue<>(List.of(numbers));
        Integer currentElement = minHeap.poll();
        while (!minHeap.isEmpty()) {
            Integer nextElement = minHeap.poll();
            if(nextElement - currentElement == 1) {
                currentMax++;
            } else {
                currentMax = 1;
            }

            if(overallMax < currentMax) {
                overallMax = currentMax;
            }

            currentElement = nextElement;
        }

        return overallMax;
    }
}
