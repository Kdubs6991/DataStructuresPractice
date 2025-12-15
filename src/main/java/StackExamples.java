import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;

/**
 * A stack is a LIFO (Last in First Out) data structure.
 * This allows us to store objects into a sort of "vertical tower"
 *
 * push() = add to the top of the stack
 * pop() = remove from the top of the stack
 * peek() = look at the top of the stack
 */

public class StackExamples {

    public static void chatGPTExample() {
        //Creating an empty stack using ArrayDeque
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        //Adding elements to the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack);

        //Spacer line for readability
        System.out.println();

        //Removing the top element from the stack
        stack.pop();
        System.out.println("After poping the top element, we get: " + stack);

        //peeking at the new element on top
        System.out.println("Peeking at the new element on top: " + stack.peek());

        //Spacer lines for readability
        System.out.println();
        System.out.println();

        //Creating a new stack for next example
        ArrayDeque<String> stack2 = new ArrayDeque<>();

        //pushing elements onto the stack
        stack2.push("A");
        stack2.push("B");
        stack2.push("C");
        System.out.println("Initial stack: " +stack2);

        while(!stack.isEmpty()) {
            System.out.println("Element popped: " + stack.pop());
        }

        //Spacer lines for readability
        System.out.println();
        System.out.println();
    }

    public static void reverseString() {
        //Creating a scanner to get user input for desired word
        Scanner s = new Scanner(System.in);
        System.out.print("Type in a word you want reversed: ");
        String word = s.nextLine();
        s.close();

        //Creating a stack that holds the type character to
        // reverse the word
        ArrayDeque<Character> stack = new ArrayDeque<>();

        //for loop to push each character of the word onto the stack
        for (char c : word.toCharArray()) {
            stack.push(c);
        }

        //Creating a String variable to house the new reversed word
        String reversed = "";
        while (!stack.isEmpty()) {
            //Whatever character is on top of the stack is added to the
            //reversed string.
            reversed += stack.pop();
        }

        //Print final reversed word when done
        System.out.println("Result: " + reversed);
    }

    public static boolean parenthesesMatching(String s) {
        //creating a new empty stack
        ArrayDeque<Character> stack = new ArrayDeque<>();

        /**
         * For each loop, if the character that is up is an open
         * parentheses/bracket, then we push it onto the stack, if
         * the parentheses/bracket is a closed one, then we pop the top
         * element from the stack and check if they match.
         *
         * returns false if they don't match.
         */
        for (char c : s.toCharArray()) {
            switch (c) {
                //opening brackets push to stack
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                //Closing brackets, pop and check value
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                //default ignores all other characters and continutes.
                default:
                    break;
            }
        }

        //stack must be empty at the end otherwise something was missed
        // and that is a fail
        return stack.isEmpty();
    }

    public static void broCodeExample() {
        //creating a new stack using the Stack class
        Stack<String> stack = new Stack<String>();

        //returns true since the stack is empty
        System.out.println("Is the stack empty? " + stack.empty());

        stack.push("Minecraft");
        stack.push("Fortnite");
        stack.push("Call of Duty");
        //returns false since the stack has objects in it
        System.out.println("Is the stack empty? " + stack.empty());
        System.out.println("Top value on stack: " + stack.peek());

        //Spacer lines for readability
        System.out.println();

        //Searching for a value in a stack using .search() method
        // returns the index that value is at
        System.out.println("Searching for Fortnite, it is at index: " + stack.search("Fortnite"));
        System.out.println("Searching for Skate 3, it is at index: " + stack.search("Skate 3"));
        System.out.println("When search returns -1, that means that value is not in the stack");


        //Spacer lines for readability
        System.out.println();

        System.out.println(stack);

        //pops the last inserted element
        String myFavGame = stack.pop();
        System.out.println("Stack after 1 pop: " + stack);
        System.out.println("Value that was popped: " + myFavGame + "\n");
        System.out.println("pop() returns: " + stack.pop());
        System.out.println("pop() returns: " + stack.pop());
        System.out.println("If we pop the empty stack, it returns a EmptyStackException");

    }

    public static void main (String[] args) {
        chatGPTExample();
        //commented out to test other methods, requires user input
        //reverseString();

        //Print lines for the parentheses matching
        System.out.println("Parentheses matching 1: " + parenthesesMatching("()[]{}"));
        System.out.println("Parentheses matching 2: " + parenthesesMatching("(]"));
        System.out.println("Parentheses matching 3: " + parenthesesMatching("([)]"));

        //Spacer lines for readability
        System.out.println();
        System.out.println();

        broCodeExample();
    }
}
