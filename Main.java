import java.util.*;
class Main {
  
  public static void main(String[] args){
  
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
