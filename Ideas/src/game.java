import java.util.Random;
import java.util.Scanner;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.math.BigDecimal;
public class game {
  private static int hp;
  private static int score = 0;
  private static int streak = 0;
  public static int level = 1;

  public game(int level1){
    level = level1;
  }
  public static void start_game(Student st) throws ScriptException{
    hp = 3;
    while(hp>0){
      if (streak > 3){
        levelup();
      }
      //generate and print equation
      String equation = generator.createEquation(level);
      System.out.println(equation);

      //ask for equation answer
      int user_answer = get_user_answer();
      int actual_answer = solver.get_answer(equation);

      //is user answer correct?
      if(user_answer == actual_answer){
        streak++;
        score++;
        st.currScore = score;
        
        System.out.println("Congragulation thats correct! \nStreak: " + streak + " Score: " + score + " HP: " +hp);
        continue;
      }
      hp--;
      score--;
      streak=0;
      st.currScore = score;
      
      System.out.println("Sorry that's not correct! \nStreak: " + streak + " Score: " + score + " HP: " + hp);
    }
    st.setHighScore();
  }
  
public static int get_user_answer(){
  Scanner console_answer = new Scanner(System.in);  // Create a Scanner object
  System.out.println("What is your answer?  ");
  return console_answer.nextInt();
}

  public static void levelup(){
    level++;
    hp=3;
  }
}