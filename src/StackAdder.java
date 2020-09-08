// Challenge: You have two numbers represented by a linked list.
// Each node represents a single digit, in reverse order, such that the
// 1's digit is at the head. Write a function that adds the two numbers
// and returns the sum as a linked list.

import java.util.Stack;

public class StackAdder {

    public static void main(String[] args) {
        Stack<Integer> firstStack = new Stack<>();
        firstStack.push(8);
        firstStack.push(2);
        firstStack.push(5);

        Stack<Integer> secondStack = new Stack<>();
        secondStack.push(4);
        secondStack.push(9);
        secondStack.push(2);

        Stack result = addTwoStacks(firstStack, secondStack);
        System.out.println(result);

        while(!result.isEmpty()) {
            System.out.print(result.pop());
        }
    }

    private static Stack<Integer> addTwoStacks(Stack<Integer> s1, Stack<Integer> s2) {
        int carry = 0;
        final Stack<Integer> resultStack = new Stack<>();
        while(!s1.isEmpty() || !s2.isEmpty() || carry > 0) {
            Integer num1 = 0;
            if (!s1.isEmpty()) {
                num1 = s1.pop();
            }

            Integer num2 = 0;
            if (!s2.isEmpty()) {
                num2 = s2.pop();
            }
            int sum = num1.intValue() + num2.intValue() + carry;
            carry = sum / 10;
            resultStack.push(sum % 10);
        }
        return resultStack;
    }
}
