package day5;

//There are n cars going to the same destination along a one-lane road.
//The destination is target miles away.
//You are given two integer array position and speed, both of length n,
//where position[i] is the position of the ith car and speed[i] is the speed of the ith car (in miles per hour).
//A car can never pass another car ahead of it,
//but it can catch up to it and drive bumper to bumper at the same speed.
//The faster car will slow down to match the slower car's speed.
//The distance between these two cars is ignored (i.e., they are assumed to have the same position).
//A car fleet is some non-empty set of cars driving at the same position and same speed.
//Note that a single car is also a car fleet.
//If a car catches up to a car fleet right at the destination point,
//it will still be considered as one car fleet.
//Return the number of car fleets that will arrive at the destination.

import java.util.Collections;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class CarFleet {

    public static void main(String[] args) {
        int target = 10;
        int [] position = {0,4,2};
        int [] speed = {1,1,3};
        
        int fleetCount = getCarfleetCount(target, position, speed);

        System.out.println("fleetCount = " + fleetCount);
    }

    private static int getCarfleetCount(int target, int[] position, int[] speed) {
        double [] time = new double[position.length];
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < position.length; i++) {
            time[i] = ((double)target - position[i]) / speed[i];
        }

        Map<Integer, Double> positionTimeMap = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < position.length; i++) {
            positionTimeMap.put(position[i], time[i]);
        }
        System.out.println("positionTimeMap = " + positionTimeMap);
        for(Map.Entry<Integer, Double> entry: positionTimeMap.entrySet()) {
            System.out.println("stack = " + stack);
            Double currentTime = entry.getValue();
            if(stack.isEmpty()) {
                stack.push(currentTime);
            } else {
                if(stack.peek() < currentTime) {
                    stack.push(currentTime);
                }
            }
        }
        System.out.println("stack = " + stack);
        return stack.size();
    }


}
