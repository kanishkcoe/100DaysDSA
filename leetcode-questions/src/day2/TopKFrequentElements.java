package day2;

//Given an integer array nums and an integer k,
//return the k most frequent elements.
//You may return the answer in any order.

import java.util.*;


class Node implements Comparable<Node> {
    Integer element;
    Integer frequency;

    public Node(Integer element, Integer frequency) {
        this.element = element;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(Node that) {
        return this.frequency - that.frequency;
    }
}

public class TopKFrequentElements {

    public static void main(String[] args) {
        Integer [] numbers = {1,2,2,3,3,3,3};
        Integer k = 2;

        List<Integer> result = getKFrequentElements(numbers, k);

        System.out.println("result = " + result);
    }

    private static List<Integer> getKFrequentElements(Integer[] numbers, Integer k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(Integer number : numbers) {
            countMap.put(number, countMap.getOrDefault(number, 0) + 1);
        }

        List<Node> nodeList = new LinkedList<>();

        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            nodeList.add(new Node(entry.getKey(), entry.getValue()));
        }

        Queue<Node> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(nodeList);

        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            result.add(maxHeap.poll().element);
        }

        return result;
    }
}
