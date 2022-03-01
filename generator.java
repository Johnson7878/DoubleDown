import java.util.Random;

public class generator {

    private static Random randomGenerator = new Random();
    private static String operators = "+-*";
    private static int opeatorStringLength = operators.length();
    private static int answer;
  
    public static char getRandomOperator() {
        return operators.charAt(randomGenerator.nextInt(opeatorStringLength));
    }

    public static int getRandomNumber() {
        return randomGenerator.nextInt(100);
    }

    private static String appendToEquation(String equation, String value1, String value2) {
        String newEquation = equation;
        newEquation += value1;
        newEquation += value2;
        return newEquation;
    }

    public static String createEquation(int numOfOperators) {
        String equation = "";
        char operator;
        int operand;
        int openParenCounter = 0;
        for (int i = 0; i < numOfOperators; i++) {
            operator = getRandomOperator();
            operand = getRandomNumber();
            if (operator == '(') {
                openParenCounter++;
                equation = appendToEquation(equation, Character.toString(operator), Integer.toString(operand));
            } else if (operator == ')') {
                if (openParenCounter == 0) { //Can't start off with a close parenthesis
                    openParenCounter++;
                    equation = appendToEquation(equation, "(", Integer.toString(operand));
                } else {
                    openParenCounter--;
                    equation = appendToEquation(equation, Integer.toString(operand), Character.toString(operator));
                }
            } else {
                equation = appendToEquation(equation, Integer.toString(operand), Character.toString(operator));
            }
        }
        equation += getRandomNumber();
        while (openParenCounter > 0) {
            equation += ")";
            openParenCounter--;
        }

        return equation;
    }

}