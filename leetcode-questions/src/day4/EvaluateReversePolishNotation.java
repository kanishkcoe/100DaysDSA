package day4;

//You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
//Evaluate the expression. Return an integer that represents the value of the expression.
import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        String [] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        
        Integer output = evaluate(tokens);

        System.out.println("output = " + output);
    }

    private static Integer evaluate(String[] tokens) {
        Stack<String> stack = new Stack<>();

        Integer result = 0;

        for(String token : tokens) {
            if(isNumber(token)) {
                stack.push(token);
            } else {
                Integer second = Integer.parseInt(stack.pop());
                Integer first = Integer.parseInt(stack.pop());

                result = solve(first, second, token);
                stack.push(String.valueOf(result));
            }
        }

        return Integer.parseInt(stack.pop());
    }

    private static Integer solve(Integer first, Integer second, String operator) {
        if(operator.equals("+")) {
            return first + second;
        }
        if(operator.equals("-")) {
            return first - second;
        }
        if(operator.equals("*")) {
            return first * second;
        }
        if(operator.equals("/")) {
            return first / second;
        }
        return null;
    }

    private static boolean isNumber(String token) {
        return token.matches("[+-]?[0-9]+");
    }
}
