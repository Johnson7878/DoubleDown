import java.util.Random;

public class generator {

    private static Random randomGenerator = new Random();
    private static String operators = "+-*";
    private static int opeatorStringLength = operators.length();
  


    public static int getRandomNumber() {
        return randomGenerator.nextInt(100);
    }

    private static String appendToEquation(String equation, String value1, String value2) {
        String newEquation = equation;
        newEquation += value1;
        newEquation += value2;
        return newEquation;
    }

    public static String createEquation(int level) {
        String equation = "";
        char operator;
        int operand;
        for (int i = 0; i < level; i++) {
            operator = operators.charAt(randomGenerator.nextInt(opeatorStringLength));
            operand = randomGenerator.nextInt(100);
            equation = appendToEquation(equation, Integer.toString(operand), Character.toString(operator));
        }
        equation += randomGenerator.nextInt(100);


        return equation;
    }
}