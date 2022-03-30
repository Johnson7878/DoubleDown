import java.util.*;

public class solver {
  public static int get_answer(String equation) {
        Stack<Integer> stack = new Stack<Integer>();
    
     
        int currNum = 0;
        char operation = '+';

    
        for (int i = 0; i < equation.length(); i++) {
            char currChar = equation.charAt(i);

            //This gets the integer value of a number in char format
            if (Character.isDigit(currChar)) {
                currNum = char_to_int(currNum, currChar);
            }
          
            if (!Character.isDigit(currChar) && !Character.isWhitespace(currChar) || i == equation.length() - 1) {
                switch (operation){
                  case '-': stack.push(-currNum); break;
                  case '+': stack.push(currNum); break;
                  case '*': stack.push(stack.pop() * currNum); break;
                }
                operation = currChar;
                currNum = 0;
            }
        }
        
     
        int result = add_result(stack);
        System.out.println("\nThe Correct Answer Is: " + result);
        return result;
    }

  //This gets the integer value of a number in char format
  private static int char_to_int(int currNum, char currChar){
    return (currNum * 10) + (currChar - '0');
  }
  
  private static int add_result(Stack<Integer> stack){
    int result = 0;
    while (!stack.isEmpty()) {
            result += stack.pop();
        }
    return result;
  }
}
