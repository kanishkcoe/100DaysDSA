package day5;

import java.util.Arrays;
import java.util.Stack;

// Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
// return the area of the largest rectangle in the histogram
public class LongestRectangleInHistogram {

    public static void main(String[] args) {
        Integer[] heights = {2,1,5,6,2,3};
        
        Integer output = getLargestRectangle(heights);

        System.out.println("output = " + output);
    }

    private static Integer getLargestRectangle(Integer[] heights) {
        Integer maxArea = 0;
        
        //we will maintain index of left most possible block and right most possible block
//        Integer[] leftMostIndex = getLeftMostBlock(heights);
        Integer[] leftMostIndex = getLeftMostBlockUsingStack(heights);
//        Integer[] rightMostIndex = getRightMostBlock(heights);
        Integer[] rightMostIndex = getRightMostBlockUsingStack(heights);

        System.out.println("rightMostIndex = " + Arrays.toString(rightMostIndex));
        System.out.println("leftMostIndex = " + Arrays.toString(leftMostIndex));

        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            int width = rightMostIndex[i] - leftMostIndex[i];
            int currentArea = width * height;
            if(currentArea > maxArea) {
                maxArea = currentArea;
            }
        }
        return maxArea;
    }

    private static Integer[] getRightMostBlockUsingStack(Integer[] heights) {
        Integer[] right = new Integer[heights.length];

        Stack<Integer> stack = new Stack<>();

        stack.push(heights.length - 1);
        right[heights.length - 1] = heights.length;

        for (int i = heights.length - 2; i >= 0 ; i--) {
            if(!stack.isEmpty()) {
                if(heights[i] > heights[stack.peek()]) {
                    right[i] = i + 1;
                } else {
                    while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                        stack.pop();
                    }

                    if(stack.isEmpty()) {
                        right[i] = heights.length;
                    } else {
                        right[i] = stack.peek();
                    }
                }
                stack.push(i);
            }
        }

        return right;
    }

    private static Integer[] getLeftMostBlockUsingStack(Integer[] heights) {
        Integer[] left = new Integer[heights.length];

        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        left[0] = 0;
        for (int i = 1; i < heights.length ; i++) {
            if(!stack.isEmpty()) {
                if(heights[i] > heights[stack.peek()]) {
                    left[i] = i;
                } else {
                    while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                        stack.pop();
                    }

                    if(stack.isEmpty()) {
                        left[i] = 0;
                    } else {
                        left[i] = stack.peek() + 1;
                    }
                }
                stack.push(i);
            }
        }

        return left;
    }

    private static Integer[] getRightMostBlock(Integer[] heights) {
        Integer[] right = new Integer[heights.length];

        for (int i = 0; i < heights.length; i++) {
            int count = 0;
            for (int j = i + 1; j < heights.length; j++) {
                if(heights[i] <= heights[j]) {
                    count++;
                } else {
                    break;
                }
            }
            right[i] = i + count + 1;
        }

        return right;
    }

    private static Integer[] getLeftMostBlock(Integer[] heights) {
        Integer[] left = new Integer[heights.length];

        for (int i = 0; i < heights.length; i++) {
            int count = 0;
            for (int j = i - 1; j >= 0 ; j--) {
                if(heights[i] <= heights[j]) {
                    count++;
                } else {
                    break;
                }
            }
            left[i] = i - count;
        }

        return left;
    }
}
