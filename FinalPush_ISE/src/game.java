import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class game implements ActionListener {
  public int statusFlag = 0;
  private static int hp;
  private static int score = 0;
  private static int streak = 0;
  public static int level = 1;

  //constructor
  public game(int level1){
    level = level1;
  }

  
  public void start_game(Student st, JFrame frame, JPanel panel, JLabel hpText, JLabel hpDisp, JLabel scText, JLabel scDisp, JLabel skText, JLabel skDisp, JLabel eqDisp, JTextField userAns, JButton ansBut, JLabel inputWin, JLabel inputLose){
    hp = 3;
    st.currScore = 0;
    Boolean delay = true;
    int ans = 0;
    //hpText.add("HP:");
    hpText.setVisible(true);
    hpDisp.setVisible(true);
    scText.setVisible(true);
    scDisp.setVisible(true);
    skText.setVisible(true);
    skDisp.setVisible(true);
    eqDisp.setVisible(true);
    userAns.setVisible(true);
    ansBut.setVisible(true);
    ansBut.addActionListener(new game(level));
    skDisp.setText(Integer.toString(streak));
    hpDisp.setText(Integer.toString(hp));
    scDisp.setText(Integer.toString(score));
    
    hp++;
    score++;
    
    //Continue playing the game
    while(hp>0){
      //levelup
      if (streak > 3){
        levelup();
        hpDisp.setText("3");
      }
      
      //generate and print equation
      String equation = generator.createEquation(level);
      System.out.println("\nSolve this!: " + equation);
      eqDisp.setText(equation);
      while(delay == false) {
    	  try {
		       Thread.sleep(200);
		    	  if (ansBut.getModel().isPressed()) {
		    		  if (isInteger(userAns.getText())) {
		    			  ans = Integer.parseInt(userAns.getText());
		    			  delay = true;
		    		  }
		    	  }
		    } catch(InterruptedException e) {
		    }
      }
      //ask for equation answer
      int user_answer = ans;
      int actual_answer = solver.get_answer(equation);

      //is user answer correct?
      if(user_answer == actual_answer){
    	inputWin.setVisible(true);
    	inputLose.setVisible(false);
        streak++;
        score++;
        scDisp.setText(Integer.toString(score));
        skDisp.setText(Integer.toString(streak));
        st.currScore = score;
        delay = false;
        userAns.setText("");
        System.out.println("Congragulation thats correct! \nStreak: " + streak + " Score: " + score + " HP: " +hp);
        continue;
      }
      
      hp--;
      hpDisp.setText(Integer.toString(hp));
      score--;
      scDisp.setText(Integer.toString(score));
      streak=0;
      skDisp.setText(Integer.toString(streak));
      st.currScore = score;
      delay = false;
      userAns.setText("");
      inputWin.setVisible(false);
  	  inputLose.setVisible(true);
      System.out.println("Sorry that's not correct! \nStreak: " + streak + " Score: " + score + " HP: " + hp);
      
    }
    st.setHighScore();
    st.setCurrScore(0);
    score = 0;
    streak = 0;
    //@Override
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
  
	public static boolean isInteger(String str) {
	    if (str == null) {
	        return false;
	    }
	    int length = str.length();
	    if (length == 0) {
	        return false;
	    }
	    int i = 0;
	    if (str.charAt(0) == '-') {
	        if (length == 1) {
	            return false;
	        }
	        i = 1;
	    }
	    for (; i < length; i++) {
	        char c = str.charAt(i);
	        if (c < '0' || c > '9') {
	            return false;
	        }
	    }
	    return true;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
  
  
}
