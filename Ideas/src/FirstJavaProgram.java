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
import java.util.concurrent.TimeUnit;
import java.math.BigDecimal;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
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
	private static JTextField userText;
	private static JTextField userNum;
	private static JButton logInBut;
	
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
	  while (true) {
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
			curr = new Student(name);
			studentData.put(curr.name, curr);
			
		} 
		else {
			System.out.println("Welcome back " + name);
			curr = studentData.get(name);
			curr.currScore = 0;
		}
		
        int level = getNum();
        game game = new game(level);
        game.start_game(curr);
        
        Map<String, Integer> sortedMap = MapSort(studentData);
		printMap(sortedMap);
        
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Students.txt"));
		Iterator it = studentData.entrySet().iterator();
		
		while (it.hasNext()) {
			Map.Entry mapElement = (Map.Entry)it.next();
			out.writeObject(mapElement.getValue());
		}
		wait = false;
	  }
  }
  private static void greetUser(){
    System.out.println("Welcome to our math game!"); 
  }

  static int askUserLevel(){
    Scanner console_level = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Choose a difficulty level.");
    int level = console_level.nextInt();
    return level;
    
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
		static void printMap(Map<String, Integer> sortedMap) {
			System.out.println();
			System.out.println("Leaderboard");
			System.out.println("------------------------------------------");
			for(Map.Entry<String, Integer> iter: sortedMap.entrySet()) {
				
				System.out.println(iter.getKey() + " " + iter.getValue());
				
			}
			System.out.println("------------------------------------------");
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
			if (e.getSource() == logInBut) {
				input = userText.getText();
				setInput(input);
				inputTemp = userNum.getText();
				if(isInteger(inputTemp) == true) {
					int foo = Integer.parseInt(inputTemp);
					setNum(foo);
					wait = true;
				}
			}
		}
  
}