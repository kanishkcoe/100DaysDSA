package day1;

// Given two strings s and t, return true if t is an anagram of s, and false otherwise.
// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
// typically using all the original letters exactly once.

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ValidAnagram {
    public static void main(String[] args) {
        String string1 = "anagram";
        String string2 = "nagrama";

        Boolean result = isValidAnagram(string1, string2);
        System.out.println("result = " + result);
    }

    private static Boolean isValidAnagram(String string1, String string2) {
        Map<Character, Integer> map1 = extractMap(string1);
        Map<Character, Integer> map2 = extractMap(string2);
        for(Map.Entry<Character, Integer> entry : map1.entrySet()) {
            Character keyFromMap1 = entry.getKey();

            if(map2.containsKey(keyFromMap1)) {
                if(!Objects.equals(map2.get(keyFromMap1), entry.getValue())) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
    private static Map<Character, Integer> extractMap(String string) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character letter : string.toCharArray()) {
            if(map.containsKey(letter)) {
                map.put(letter, map.get(letter) + 1);
            } else {
                map.put(letter, 1);
            }
        }

        return map;
    }


}
