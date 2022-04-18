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

        return generate(level);
        // return generate((level-1)/3+2,10, level%3 );
    
    }

  public static String generate(int level){
        String equation = "";
        char operator;
        int operand;
        int n = level +2;
        int range = (level/5 +1 *10);
         for (int i = 0; i < n; i++) {
           if(i!=n-1){
             operator = operators.charAt(randomGenerator.nextInt(3));
           }
           else{
             operator = ' ';
           }
            
      
            
            operand = randomGenerator.nextInt(range);
            equation = appendToEquation(equation, Integer.toString(operand), Character.toString(operator));
        }
     
    return equation;
  }
}
