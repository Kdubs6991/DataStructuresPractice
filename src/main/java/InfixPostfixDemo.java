import java.util.ArrayDeque;

public class InfixPostfixDemo {

    /**
     * OPERATOR PRECEDENCE METHOD
     * ---------------------------
     * This helper method tells us the precedence of an operator. We
     *  show this by the number it returns, if the number is higher,
     *  then the precedence is higher.
     *
     * We use this during infix --> postfix conversion to decide
     *  whether to POP operators from the stack.
     *
     * @param op operator to check precedence of
     * @return int of precedence (higher number higher priority)
     */
    private static int precedence(char op) {
        switch (op) {
            case '*':
            case '/':
                //Multiplication and division have higher precedence
                return 2;
            case '+':
            case '-':
                //Addition and subtraction have lower precedence
                return 1;
            default:
                // Parentheses or invalid characters
                return 0;
        }
    }

    /**
     * INFIX --> POSTFIX CONVERSION
     * -----------------------------
     * Rules of conversion:
     *  1. Operands go directly to output
     *  2. '(' goes on stack
     *  3. ')' pops until '(' is found
     *  4. Operators pop higher/equal precedence operators from stack
     *  5. At the end, pop all remaining operators from stack
     *
     * @param infix expression to be converted to postfix
     * @return postfix expression
     */
    public static String infixToPostfix(String infix) {
        //Stack to temporarily store operators and parentheses
        ArrayDeque<Character> operatorStack = new ArrayDeque<>();

        //StringBuilder is efficient for building output strings
        StringBuilder output = new StringBuilder();

        //Process the infix expression character-by-character
        for(int i = 0; i < infix.length(); i++) {
            char current = infix.charAt(i);

            //Ignore spaces to make input more flexible
            if(Character.isWhitespace(current)) {
                continue;
            }
            /**
             * CASE 1: OPERAND
             * ----------------
             * If the character is a letter or digit (not a
             *  operator), then it is an operand.
             *
             *  Operands always go directly to the output.
             */
            if(Character.isLetterOrDigit(current)) {
                output.append(current).append(' ');
            }
            /**
             * CASE 2: LEFT PARENTHESIS '('
             * ----------------------------
             * Always push '(' onto the stack. It acts as a
             *  marker that stops popping.
             */
            else if(current == '(') {
                operatorStack.push(current);
            }
            /**
             * CASE 3: RIGHT PARENTHESIS ')'
             * -----------------------------
             * Pop operators from the stack to output until
             *  '(' is found. Then discard the '('.
             */
            else if (current == ')') {
                //Pop the operator stack until the matching '(' is found
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    output.append(operatorStack.pop()).append(' ');
                }

                //Remove the '(' itself from the stack
                if( !operatorStack.isEmpty() && operatorStack.peek() == '(') {
                    operatorStack.pop();
                } else {
                    //If '(' is missing, parentheses are mismatched
                    throw new IllegalArgumentException("Mismatched parentheses");
                }
            }
            /**
             * CASE 4: OPERATOR ( + - * / )
             * -----------------------------
             * While the operator on the stack has GREATOR or
             *  EQUAL precedence, pop it to the output.
             *
             *  Then push the current operator.
             */
            else if(current == '+' || current == '-' || current == '*' || current == '/') {
                //Pop operators with higher or equal precedence and append to output string
                while(!operatorStack.isEmpty() && operatorStack.peek() != '(' &&
                        precedence(operatorStack.peek()) >= precedence(current)) {
                    output.append(operatorStack.pop()).append(' ');
                }

                //push the current operator AFTER popping
                operatorStack.push(current);
            }
            /**
             * CASE 5: INVALID CHARACTER
             */
            else {
                throw new IllegalArgumentException("Invalid character in expression: " + current);
            }
        }

        /**
         * END OF EXPRESSION
         * ------------------
         * Pop any remaining operators fromt he stack and add them
         *  to the output.
         */
        while (!operatorStack.isEmpty()) {
            char top = operatorStack.pop();

            //If '(' is still on stack, parentheses were mismatched
            if(top == '(') {
                throw new IllegalArgumentException("Mismatched Parenthesis");
            }

            output.append(top).append(' ');
        }

        //return the final postfix expression (trim trailing space)
        return output.toString().trim();
    }

    /**
     * POSTFIX EVALUATION
     * ------------------
     * Rules of evaluation:
     *  1. Read left to right
     *  2. Operand --> push
     *  3. Operator --> pop 2 operands,
     *  4. Compute and push result
     *
     * @param postfix expression to evaluate
     * @return result of evaluation
     */
    public static int evaluatePostfix(String postfix) {
        //Stack for sorting integer values
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        /** An array to split the postfix expressions
         *  into usable 'tokens'. The expression is split by
         *  any whitespace.
         *
         * \\s means any whitespace (space, tab, etc)
         * + means one or more of them
         */
        String[] tokens = postfix.split("\\s+");

        for (String token : tokens) {
            /**
             * CASE 1: OPERAND (NUMBER)
             * -------------------------
             * Push numeric values onto the stack.
             *
             *
             * -?\\d+ means any integer value
             * -? means optional negative sign
             * \\d means any digit
             * + means one or more of them
             */
            if (token.matches("-?\\d+")) {
                stack.push(Integer.parseInt(token));
            }
            /**
             * CASE 2: OPERATOR
             * -----------------
             * Pop two operands, apply the operator, and
             *  push the result.
             *
             *
             *  Checks if the token length is equal to 1, and
             *  "+ - * /" checks if the token is 1 of the 4 operators
             */
            else if(token.length() == 1 && "+-*/".contains(token)) {
                //If the stack is less than 2, then there isn't 2 operands to
                // perform the operation on.
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid postfix expression");
                }

                //IMPORTANT:
                //The FIRST popped value is the RIGHT operand
                //The SECOND popped value is the LEFT operand
                int right = stack.pop();
                int left = stack.pop();
                int result;

                switch (token.charAt(0)) {
                    case '+':
                        result = left + right;
                        break;
                    case '-':
                        result = left - right;
                        break;
                    case '*':
                        result = left * right;
                        break;
                    case '/':
                        result = left / right; //Integer division
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + token);
                }

                //Push the result back onto the stack
                stack.push(result);
            }
            /**
             * CASE 3: INVALID TOKEN
             */
            else {
                throw new IllegalArgumentException("Invalid token: " + token);
            }
        }

        //At the end, exactly ONE value should remain
        if(stack.size() != 1) {
            throw new IllegalArgumentException("Invalid postfix expression.");
        }

        //The last value should be the result of the expression
        return stack.pop();
    }


    public static void main(String[] args) {
        String infixTest1 = "(2 + 3) * 4 - 5";
        System.out.println("Infix Expression 1: " + infixTest1);
        String postfixConversion1 = infixToPostfix(infixTest1);
        System.out.println("Postfix Expression 1: " + postfixConversion1);
        int resultTest1 = evaluatePostfix(postfixConversion1);
        System.out.println("Expression 1 result: " + resultTest1);

        //Spacer Lines for readability
        System.out.println();
        System.out.println();

        String infixTest2 = "10 + 3 * (2 * 7)";
        System.out.println("Infix Expression 2: " + infixTest1);
        String postfixConversion2 = infixToPostfix(infixTest1);
        System.out.println("Postfix Expression 2: " + postfixConversion2);
        int resultTest2 = evaluatePostfix(postfixConversion2);
        System.out.println("Expression 2 result: " + resultTest2);
    }


}
