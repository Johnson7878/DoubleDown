import java.util.Random;
import java.util.Scanner;
import java.util.Random;
import java.util.Scanner;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.math.BigDecimal;
class Main {
  
  public static void main(String[] args)  throws ScriptException{
  
    while(true){
        greetUser();
        int level = askUserLevel();
        game game = new game(level);
        game.start_game();
    }
    
    
  }
  private static void greetUser(){
    System.out.println("Welcome to our math game!"); 
  }

  private static int askUserLevel(){
    Scanner console_level = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Choose a difficulty level.");
    int level = console_level.nextInt();
    return level;
    
  }
    
    
  
}