import java.util.Stack;

public class BracketsValidation {

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        System.out.println("Testing program sadsa");
        String input = "{}{{()}}{{{[[[]]]}}}";
        int length = input.length();

        for (int i = 0; i < length; i++) {
            char c = input.charAt(i);

            if (isStartingChar(c)) {
                stack.push(c);
            } else if (isEndingChar(c)) {
                if (stack.isEmpty() || !isParMatch(stack.pop(), c)) {
                    System.out.println("Not valid!!!");
                    return;
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("Valid!!!");
        } else {
            System.out.println("Not Valid!!!");
        }

    }

    private static boolean isStartingChar(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private static boolean isEndingChar(char c) {
        return c == ')' || c == ']' || c == '}';
    }

    private static boolean isParMatch(char first, char second) {
        return (first == '(' && second == ')') ||
                (first == '[' && second == ']') ||
                (first == '{' && second == '}');
    }
}
