package day2;

//Given an array of strings strs, group the anagrams together.
//You can return the answer in any order.
//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
//typically using all the original letters exactly once.

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupAnagram {

    public static void main(String[] args) {
        String [] strings = {"eat","tea","tan","ate","nat","bat","tab","ant"};

        List<List<String>> result = getGroupsOfAnagram(strings);

        result.forEach(System.out::println);
    }

    private static List<List<String>> getGroupsOfAnagram(String[] strings) {
        Map<String, List<String>> group = new HashMap<>();
        List<List<String>> result = new LinkedList<>();
        for (String string : strings) {
            StringBuilder characterCountMap = new StringBuilder().append("00000000000000000000000000");
            for(Character letter : string.toCharArray()) {
                int letterIndex = ((int) letter) - (int)('a');
                characterCountMap.setCharAt(letterIndex, (char) (((int) characterCountMap.charAt(letterIndex)) + 1));
            }
            List<String> updatedList = group.getOrDefault(characterCountMap.toString(), new LinkedList<>());
            updatedList.add(string);
            group.put(characterCountMap.toString(), updatedList);
        }

        for(Map.Entry<String, List<String>> entry : group.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
}
