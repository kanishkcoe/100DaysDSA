package day4;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
public class GenerateParantheses {

    static Stack<String> stack = new Stack<>();
    static List<String> result = new LinkedList<>();

    public static void main(String[] args) {
        Integer n = 8;

        List<String> output = generateParanthesesCombination(n);

        System.out.println("output = " + output);
    }

    private static List<String> generateParanthesesCombination(Integer n) {

        backtrack(0,0,n);

        return result;
    }

    private static void backtrack(int openCount, int closeCount, Integer n) {
        if (openCount == closeCount && openCount == n) {
            StringBuilder combination = new StringBuilder();
            stack.forEach(combination::append);
            result.add(combination.toString());
            return;
        }

        if (openCount < n) {
            stack.push("(");
            backtrack(openCount + 1, closeCount, n);
            stack.pop();
        }

        if(closeCount < openCount) {
            stack.push(")");
            backtrack(openCount, closeCount + 1, n);
            stack.pop();
        }
    }
}
