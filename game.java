import java.util.Scanner;


public class game {
  private static int hp;
  private static int score = 0;
  private static int streak = 0;
  public static int level = 1;

  //constructor
  public game(int level1){
    level = level1;
  }

  
  public static void start_game(){
    hp = 3;

    //Continue playing the game
    while(hp>0){
      //levelup
      if (streak%3==0){
        levelup();
      }
      
      //generate and print equation
      String equation = generator.createEquation(level);
      System.out.println("\nSolve this!: " + equation);

      //ask for equation answer
      int user_answer = get_user_answer();
      int actual_answer = solver.get_answer(equation);

      //is user answer correct?
      if(user_answer == actual_answer){
        streak++;
        score++;
        System.out.println("Congragulation thats correct! \nStreak: " + streak + " Score: " + score + " HP: " +hp);
        continue;
      }
      
      hp--;
      score--;
      streak=0;
      System.out.println("Sorry that's not correct! \nStreak: " + streak + " Score: " + score + " HP: " + hp);
      
    }
  }
  
public static int get_user_answer(){
  Scanner console_answer = new Scanner(System.in);  // Create a Scanner object
  System.out.println("What is your answer?  ");
  return console_answer.nextInt();
}

  public static void levelup(){
    System.out.println("Congragulations! That's a winning streak. Levelup!! Resetting health!\n");
    level++;
    hp=3;
    
  }
}
