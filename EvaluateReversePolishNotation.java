import java.util.Stack;

/*
 * Problem: Evaluate Reverse Polish Notation
 *
 * Description:
 * Given an array of strings representing an arithmetic expression
 * in Reverse Polish Notation (RPN), evaluate the expression
 * and return its integer result.
 *
 * Valid operators are +, -, *, and /.
 * Division between two integers truncates toward zero.
 *
 * Approach: Stack
 *
 * 1. Create a stack to store integer operands and intermediate results.
 * 2. Traverse every token in the input array.
 * 3. If the token is an operand, convert it into an integer
 *    and push it onto the stack.
 * 4. If the token is an operator:
 *    - Pop the second operand (b).
 *    - Pop the first operand (a).
 *    - Perform the operation a operator b.
 *    - Push the result back onto the stack.
 * 5. After processing all tokens, the stack contains the
 *    final result. Return it.
 *
 * Important:
 * Operand order matters for subtraction and division.
 */
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {

            String token = tokens[i];

            if (token.equals("+") || token.equals("-") ||
                token.equals("*") || token.equals("/")) {

                int b = stack.pop();
                int a = stack.pop();

                int result = 0;

                if (token.equals("+")) {
                    result = a + b;
                }
                else if (token.equals("-")) {
                    result = a - b;
                }
                else if (token.equals("*")) {
                    result = a * b;
                }
                else if (token.equals("/")) {
                    result = a / b;
                }

                stack.push(result);

            } else {

                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {

        EvaluateReversePolishNotation solution =
                new EvaluateReversePolishNotation();

        String[] tokens1 = {"2", "1", "+", "3", "*"};
        String[] tokens2 = {"4", "13", "5", "/", "+"};

        String[] tokens3 = {
            "10", "6", "9", "3", "+", "-11",
            "*", "/", "*", "17", "+", "5", "+"
        };

        System.out.println(solution.evalRPN(tokens1));
        System.out.println(solution.evalRPN(tokens2));
        System.out.println(solution.evalRPN(tokens3));
    }
}