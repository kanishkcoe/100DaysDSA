package day4;

import java.util.Stack;

//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
// determine if the input string is valid.
//An input string is valid if:
//Open brackets must be closed by the same type of brackets.
//Open brackets must be closed in the correct order.
//Every close bracket has a corresponding open bracket of the same type.
public class ValidParantheses {

    public static void main(String[] args) {
        String input = "[()[]{}{}]";

        Boolean output = isValidParantheses(input);

        System.out.println("output = " + output);
    }

    private static Boolean isValidParantheses(String input) {
        Stack<Character> stack = new Stack<>();

        for (Character character : input.toCharArray()) {
            if (character.equals('{') || character.equals('[') || character.equals('(')) {
                stack.push(character);
            } else {
                if(!stack.isEmpty()) {
                    Character top = stack.pop();
                    if (!closes(top, character)) return false;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean closes(Character top, Character character) {
        if (
                (top.equals('{') && character.equals('}')) ||
                (top.equals('[') && character.equals(']')) ||
                (top.equals('(') && character.equals(')'))
        ) return true;

        return false;
    }
}
