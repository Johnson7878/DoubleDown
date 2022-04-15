import java.util.Random;
import java.util.Scanner;
import java.util.Random;
import java.util.Scanner;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Spring;
import java.awt.Component;

import java.util.concurrent.TimeUnit;
import java.math.BigDecimal;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
//first fully functional back end build
class FirstJavaProgram implements ActionListener {
	private static JPanel logInPl;
	private static JFrame logInFm;
	private static JLabel logInLab;
	private static JLabel logInLab2;
	private static JLabel hpText;
	private static JLabel hpDisp;
	private static JLabel scText;
	private static JLabel scDisp;
	private static JLabel skText;
	private static JLabel skDisp;
	private static JLabel eqDisp;
	private static JLabel lbText;
	private static JLabel entMsg;
	private static JLabel pos1;
	private static JLabel pos2;
	private static JLabel pos3;
	private static JLabel pos4;
	private static JLabel pos5;
	private static JLabel pos1V;
	private static JLabel pos2V;
	private static JLabel pos3V;
	private static JLabel pos4V;
	private static JLabel pos5V;
	private static JTextField userText;
	private static JTextField userNum;
	private static JTextField userAns;
	private static JButton logInBut;
	private static JButton ansBut;
	private static JButton contBut;
	
	private static String input;
	private static String inputTemp;
	public static int inpuNum;
	public static boolean wait = false;
	
	public static int getNum() {
		return FirstJavaProgram.inpuNum;
	}
	
	public void setNum(int temp) {
		FirstJavaProgram.inpuNum = temp;
	}
	public static String getInput() {
		return FirstJavaProgram.input;
	}
	
	public void setInput(String temp) {
		FirstJavaProgram.input = temp;
	}
	
  public static void main(String[] args)  throws ScriptException, FileNotFoundException, IOException{
	  logInPl = new JPanel();
	  logInFm = new JFrame();
	  logInFm.setSize(1000,700);
	  logInFm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  logInFm.setVisible(true);
	  logInFm.setResizable(false);
	  logInFm.add(logInPl);
	  
	  logInPl.setLayout(null);
	  
	  logInLab = new JLabel("Username:");
	  logInLab.setBounds(330,350,80,25);
	  logInPl.add(logInLab);
	  
	  logInLab2 = new JLabel("Difficulty Level:");
	  logInLab2.setBounds(300,380,160,25);
	  logInPl.add(logInLab2);
	  
	  userText = new JTextField();
	  userText.setBounds(400,350,165,25);
	  logInPl.add(userText);
	  
	  userNum = new JTextField();
	  userNum.setBounds(400,380,165,25);
	  logInPl.add(userNum);
	  
	  logInBut = new JButton("Submit");
	  logInBut.setBounds(430,410,105,25);
	  logInBut.addActionListener(new FirstJavaProgram());
	  logInPl.add(logInBut);
	  
	  hpText = new JLabel("HP:");
	  hpText.setBounds(390,20,165,25);
	  hpText.setFont(new Font("",Font.PLAIN,20));
	  hpText.setVisible(false);
	  logInPl.add(hpText);
	  
	  hpDisp = new JLabel("0");
	  hpDisp.setBounds(450,20,165,25);
	  hpDisp.setFont(new Font("",Font.PLAIN,20));
	  hpDisp.setVisible(false);
	  logInPl.add(hpDisp);
	  
	  scText = new JLabel("Score:");
	  scText.setBounds(690,20,165,25);
	  scText.setVisible(false);
	  scText.setFont(new Font("",Font.PLAIN,20));
	  logInPl.add(scText);
	  
	  scDisp = new JLabel("0");
	  scDisp.setBounds(750, 20, 165, 25);
	  scDisp.setVisible(false);
	  scDisp.setFont(new Font("",Font.PLAIN,20));
	  logInPl.add(scDisp);
	  
	  skText = new JLabel("Streak:");
	  skText.setBounds(85, 25, 165, 25);
	  skText.setVisible(false);
	  skText.setFont(new Font("",Font.PLAIN,20));
	  logInPl.add(skText);
	  
	  skDisp = new JLabel("0");
	  skDisp.setBounds(150,25,165,25);
	  skDisp.setFont(new Font("",Font.PLAIN,20));
	  skDisp.setVisible(false);
	  logInPl.add(skDisp);
	  
	  eqDisp = new JLabel("0");
	  eqDisp.setBounds(340, 200, 600, 200);
	  eqDisp.setAlignmentX(logInPl.CENTER_ALIGNMENT);
	  eqDisp.setAlignmentY(logInPl.CENTER_ALIGNMENT);
	  eqDisp.setVisible(false);
	  eqDisp.setFont(new Font("",Font.PLAIN,30));
	  logInPl.add(eqDisp);
	  
	  userAns = new JTextField();
	  userAns.setBounds(380,450,165,25);
	  userAns.setVisible(false);
	  logInPl.add(userAns);
	  
	  ansBut = new JButton("Submit");
	  ansBut.setBounds(570,450,165,25);
	  ansBut.setVisible(false);
	  //ansBut.addActionListener(new FirstJavaProgram());
	  logInPl.add(ansBut);
	  
	  lbText = new JLabel("Leaderboard:");
	  lbText.setBounds(370,-20,200,200);
	  lbText.setFont(new Font("",Font.PLAIN,30));
	  lbText.setVisible(false);
	  logInPl.add(lbText);
	  
	  pos1 = new JLabel("x");
	  pos1.setBounds(360,20,200,200);
	  pos1.setFont(new Font("",Font.PLAIN,20));
	  pos1.setVisible(false);
	  logInPl.add(pos1);
	  
	  pos1V = new JLabel("x");
	  pos1V.setBounds(570,20,200,200);
	  pos1V.setFont(new Font("",Font.PLAIN,20));
	  pos1V.setVisible(false);
	  logInPl.add(pos1V);
	  
	  pos2 = new JLabel("x");
	  pos2.setBounds(360,50,200,200);
	  pos2.setFont(new Font("",Font.PLAIN,20));
	  pos2.setVisible(false);
	  logInPl.add(pos2);
	  
	  pos2V = new JLabel("x");
	  pos2V.setBounds(570,50,200,200);
	  pos2V.setFont(new Font("",Font.PLAIN,20));
	  pos2V.setVisible(false);
	  logInPl.add(pos2V);
	  
	  pos3 = new JLabel("x");
	  pos3.setBounds(360,80,200,200);
	  pos3.setFont(new Font("",Font.PLAIN,20));
	  pos3.setVisible(false);
	  logInPl.add(pos3);
	  
	  pos3V = new JLabel("x");
	  pos3V.setBounds(570,80,200,200);
	  pos3V.setFont(new Font("",Font.PLAIN,20));
	  pos3V.setVisible(false);
	  logInPl.add(pos3V);
	  
	  pos4 = new JLabel("x");
	  pos4.setBounds(360,110,200,200);
	  pos4.setFont(new Font("",Font.PLAIN,20));
	  pos4.setVisible(false);
	  logInPl.add(pos4);
	  
	  pos4V = new JLabel("x");
	  pos4V.setBounds(570,110,200,200);
	  pos4V.setFont(new Font("",Font.PLAIN,20));
	  pos4V.setVisible(false);
	  logInPl.add(pos4V);
	  
	  pos5 = new JLabel("x");
	  pos5.setBounds(360,140,200,200);
	  pos5.setFont(new Font("",Font.PLAIN,20));
	  pos5.setVisible(false);
	  logInPl.add(pos5);
	  
	  pos5V = new JLabel("x");
	  pos5V.setBounds(570,140,200,200);
	  pos5V.setFont(new Font("",Font.PLAIN,20));
	  pos5V.setVisible(false);
	  logInPl.add(pos5V);
	  
	  entMsg = new JLabel("");
	  entMsg.setBounds(410,450,200,25);
	  entMsg.setVisible(false);
	  logInPl.add(entMsg);
	  
	  contBut = new JButton("Continue");
	  contBut.setBounds(400, 300, 165, 25);
	  contBut.addActionListener(new FirstJavaProgram());
	  contBut.setVisible(false);
	  logInPl.add(contBut);
	  
	  String tempS = "";
	  int tempI = 0;
	  String lbValues[] = new String[5];
	  String lbScore[] = new String[5];
	  
	  while (true) {
	  logInLab.setVisible(true);
	  logInLab2.setVisible(true);
	  logInBut.setVisible(true);
	  userNum.setVisible(true);
	  userText.setVisible(true);
	  
	  while (wait == false) {
		  try {
		       Thread.sleep(200);
		    } catch(InterruptedException e) {
		    }
	  }
      greetUser();
        
      HashMap<String, Student> studentData = new HashMap();
		//Reading in Students.txt objects before program starts
      try {
			FileInputStream fin = new FileInputStream("Students.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);
			while (fin!=null) {
			Student temp = (Student) ois.readObject();
			studentData.put(temp.name, temp);
			}
			ois.close();
		} catch (Exception ex ) {}
		String name = getInput();
		Student curr;
		//Fetch or create new user profile
		if (!studentData.containsKey(name)) {
			System.out.println("Creating new profile...");
			entMsg.setVisible(true);
			entMsg.setText("Creating new profile...");
			wait(1000);
			entMsg.setVisible(false);
			curr = new Student(name);
			studentData.put(curr.name, curr);
			
		} 
		else {
			System.out.println("Welcome back " + name);
			curr = studentData.get(name);
			entMsg.setVisible(true);
			entMsg.setText("Welcome back " + name);
			wait(1000);
			entMsg.setVisible(false);
			curr.currScore = 0;
		}
		
        int level = getNum();
        
        logInLab.setVisible(false);
        logInLab2.setVisible(false);
        logInBut.setVisible(false);
        userNum.setVisible(false);
        userText.setVisible(false);
        
        
        game game = new game(level);
        game.start_game(curr, logInFm, logInPl, hpText, hpDisp, scText, scDisp, skText, skDisp, eqDisp, userAns, ansBut);
       
        wait = false;
        Map<String, Integer> sortedMap = MapSort(studentData);
		//printMap(sortedMap);
        for(Map.Entry<String, Integer> iter: sortedMap.entrySet()) {
			
			System.out.println(iter.getKey() + " " + iter.getValue());
			if(tempI < 5) {
				tempS = Integer.toString((tempI + 1)) + ". " + iter.getKey();
				lbValues[tempI] = tempS;
				lbScore[tempI] = Integer.toString(iter.getValue());
			}
			tempI++;
		}
        
		hpText.setVisible(false);
		hpDisp.setVisible(false);
		scText.setVisible(false);
		scDisp.setVisible(false);
		skText.setVisible(false);
		skDisp.setVisible(false);
		eqDisp.setVisible(false);
		userAns.setVisible(false);
		ansBut.setVisible(false);
        
        pos1.setText(lbValues[0]);
        pos1.setVisible(true);
        pos2.setText(lbValues[1]);
        pos2.setVisible(true);
        pos3.setText(lbValues[2]);
        pos3.setVisible(true);
        pos4.setText(lbValues[3]);
        pos4.setVisible(true);
        pos5.setText(lbValues[4]);
        pos5.setVisible(true);
        
        pos1V.setText(lbScore[0]);
        pos1V.setVisible(true);
        pos2V.setText(lbScore[1]);
        pos2V.setVisible(true);
        pos3V.setText(lbScore[2]);
        pos3V.setVisible(true);
        pos4V.setText(lbScore[3]);
        pos4V.setVisible(true);
        pos5V.setText(lbScore[4]);
        pos5V.setVisible(true);
  	  	lbText.setVisible(true);
  	  	contBut.setVisible(true);
  	  	
  	  while (wait == false) {
		  try {
		       Thread.sleep(200);
		    } catch(InterruptedException e) {
		    }
	  }
  	  
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Students.txt"));
		Iterator it = studentData.entrySet().iterator();
		
		while (it.hasNext()) {
			Map.Entry mapElement = (Map.Entry)it.next();
			out.writeObject(mapElement.getValue());
		}
		wait = false;
		pos1.setVisible(false);
        pos2.setVisible(false);
        pos3.setVisible(false);
        pos4.setVisible(false);
        pos5.setVisible(false);
		pos1V.setVisible(false);
        pos2V.setVisible(false);
        pos3V.setVisible(false);
        pos4V.setVisible(false);
        pos5V.setVisible(false);
  	  	lbText.setVisible(false);
  	  	contBut.setVisible(false);
        
		userText.setText("");
		userNum.setText("");
		tempI=0;
	  }
  }
  private static void greetUser(){
    System.out.println("Welcome to our math game!"); 
  }
    
	//This function takes in a map and sorts it in descending order
	static Map<String, Integer> MapSort(HashMap<String, Student> studentData){
		HashMap<String, Integer> temp = new HashMap();
		for(Map.Entry<String, Student> iter: studentData.entrySet()) {
			temp.put(iter.getKey(), iter.getValue().getHighScore());
		}
		
		//need to find a way to order the map objects before printing
		List<Map.Entry<String, Integer>> listConv = new LinkedList<Map.Entry<String, Integer>>(temp.entrySet());
		Collections.sort(listConv, new Comparator<Map.Entry<String, Integer>>(){
			
			public int compare(Map.Entry<String, Integer> compare1,
					Map.Entry<String, Integer> compare2) {
				return (compare2.getValue()).compareTo(compare1.getValue());
			}
			
		});		
		Map<String, Integer> srtMap = new LinkedHashMap<String, Integer>();
		for(Map.Entry<String, Integer> iter : listConv) {
			srtMap.put(iter.getKey(), iter.getValue());
		}
		return srtMap;
	}
	
	//this function takes in the current map, and prints it (in descending order)
	/*
	 * static void printMap(Map<String, Integer> sortedMap) { System.out.println();
	 * System.out.println("Leaderboard");
	 * System.out.println("------------------------------------------");
	 * for(Map.Entry<String, Integer> iter: sortedMap.entrySet()) {
	 * 
	 * System.out.println(iter.getKey() + " " + iter.getValue());
	 * 
	 * } System.out.println("------------------------------------------"); }
	 */
		
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
		
		public static void wait(int ms)
		{
		    try
		    {
		        Thread.sleep(ms);
		    }
		    catch(InterruptedException ex)
		    {
		        Thread.currentThread().interrupt();
		    }
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == logInBut) {
				input = userText.getText();
				setInput(input);
				inputTemp = userNum.getText();
				if(isInteger(inputTemp) == true) {
					int foo = Integer.parseInt(inputTemp);
					setNum(foo);
					wait = true;
				} else {
					entMsg.setText("ENTER INTGER VALUE");
					entMsg.setVisible(true);
				}
			} else if (e.getSource() == contBut) {
				wait = true;
			}
		}
  
}