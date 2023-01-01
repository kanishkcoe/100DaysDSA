package day1;

// Given an integer array nums,
// return true if any value appears at least twice in the array,
// and return false if every element is distinct.

import java.util.*;

public class ContainsDuplicate {

    public static void main(String[] args) {
        Integer [] numbers = {3, 3, 4, 5, 67, 57, 17, 75, 13, 45};
//        Boolean result = containsDuplicateUsingSet(Arrays.stream(numbers).toList());
        Boolean result = containsDuplicateUsingHashMap(Arrays.stream(numbers).toList());

        System.out.println("result = " + result);
    }

    private static Boolean containsDuplicateUsingSet(List<Integer> array) {
        Set<Integer> set = new HashSet<>(array);
        return set.size() != array.size();
    }

    private static Boolean containsDuplicateUsingHashMap(List<Integer> array) {
        Boolean result = false;
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer number : array) {
            if(map.containsKey(number)) {
                return true;
            } else {
                map.put(number, 1);
            }
        }
        return false;
    }
}
