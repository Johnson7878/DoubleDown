import java.util.Random;
import java.util.Scanner;
import java.util.Random;
import java.util.Scanner;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
//first fully functional back end build
class FirstJavaProgram {
  
  public static void main(String[] args)  throws ScriptException, FileNotFoundException, IOException{
  
    while(true){
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
		
		String name = askUserName();
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
		
        int level = askUserLevel();
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
  
  static String askUserName() {
	  Scanner nameIn = new Scanner(System.in);
	  System.out.println("Please enter your name: ");
	  String name = nameIn.nextLine();
	  return name;
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
  
}