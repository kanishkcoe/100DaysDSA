package day1;

import java.util.HashMap;
import java.util.Map;

// Given an array of integers nums and an integer target,
// return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution,
// and you may not use the same element twice.
// You can return the answer in any order.
class Result {
    Integer firstIndex;
    Integer secondIndex;

    public Result(Integer firstIndex, Integer secondIndex) {
        this.firstIndex = firstIndex;
        this.secondIndex = secondIndex;
    }

    @Override
    public String toString() {
        return "Result {" + firstIndex +
                ", " + secondIndex +
                '}';
    }
}

public class TwoSum {

    public static void main(String[] args) {

        Integer [] array = {2, 7, 11, 15};
        Integer target = 9;

        Result result = getTwoSum(array, target);

        System.out.println(result);
    }

    private static Result getTwoSum(Integer[] array, Integer target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if(!map.containsKey(array[i])) {
                map.put(target - array[i], i);
            } else {
                return new Result(map.get(array[i]), i);
            }
        }

        return null;
    }
}
