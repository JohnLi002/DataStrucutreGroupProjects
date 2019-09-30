package lab2Stacks;

public class PostfixEvaluator {
	public static double eval(String a) {
        LinkedStack<Double> valueStack = new LinkedStack<>();
        while (!a.isEmpty()) { //Searches through the whole string.
            char nextChar = a.charAt(0);
            a = a.substring(1, a.length());
            if('0' <= nextChar && nextChar <= '9') {
                valueStack.push((double) nextChar); //Turns the character into double.
            }else if(nextChar == '+'  || nextChar == '-' || nextChar == '*' || nextChar == '/' || nextChar == '^') {
                double operandTwo = valueStack.pop();
                double operandOne = valueStack.pop();
                double result;
                if(nextChar == '+') {
                    result = operandOne + operandTwo;
                }else if(nextChar == '-') {
                    result = operandOne - operandTwo;
                }else if(nextChar == '*') {
                    result = operandOne * operandTwo;
                }else if(nextChar == '/') {
                    result = operandOne / operandTwo;
                }else{ //This is for the exponent.
                    result = Math.pow(operandOne, operandTwo);
                }
                    valueStack.push(result);
            }
        }
        return valueStack.pop();
    }
}
