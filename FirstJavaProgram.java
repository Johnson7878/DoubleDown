import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.*;


public class FirstJavaProgram {
	
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
		for(Map.Entry<String, Integer> iter: sortedMap.entrySet()) {
			
			System.out.println(iter.getKey() + " " + iter.getValue());
			
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {		
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
		
		Scanner scan = new Scanner(System.in);
		String name;
		
		//If user already exists access profile in map or else create new one then add it to map data
		System.out.println("Please enter your name: ");
		name = scan.nextLine();
		if (!studentData.containsKey(name)) {
			System.out.println("Creating new profile...");
			Student curr = new Student(name);
			studentData.put(curr.name, curr);
			
		} 
		else {
			System.out.println("Welcome back " + name);
			Student curr = studentData.get(name);
			curr.setCurrScore(50);	//test
			curr.setHighScore();	//test
			
		}
		
		
		
		
		//had to read some documentation for printing the map: https://stackoverflow.com/questions/36782231/printing-a-java-map-mapstring-object-how
		// also followed this tutorial for sorting maps (though had to alter it to account for student objects)
		//https://mkyong.com/java/how-to-sort-a-map-in-java/
		Map<String, Integer> sortedMap = MapSort(studentData);
		printMap(sortedMap);
		
		
		
		
		
		///////////////////////////////////////////////////////////////////////////////////////////
		//I HAVE PORTED THE SORT FUNCTIONALITY BELOW INTO A FUNCTION (AS WELL AS THE PRINT)
		//THAT WAY, WE CAN SIMPLY CALL IT/THEM
		////////////////////////////////////////////////////////////////////////////////////////////
		
		
		/*HashMap<String, Integer> temp = new HashMap();
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
		}*/
		
		
		//this'll print the leaderboard
		/*for(Map.Entry<String, Integer> iter: srtMap.entrySet()) {
			
			System.out.println(iter.getKey() + " " + iter.getValue());
			
		}*/
		//had to read some documentation for printing the map: https://stackoverflow.com/questions/36782231/printing-a-java-map-mapstring-object-how
		// also followed this tutorial for sorting maps (though had to alter it to account for student objects)
		//https://mkyong.com/java/how-to-sort-a-map-in-java/
		
		
		///////////////////////////////////////////////////////////////////////////////////////////
		//END OF CODE RESERVE
		///////////////////////////////////////////////////////////////////////////////////////////
		
		
		
				//this'll write the leaderboard names into a txt file (database alternative)
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Students.txt"));
		Iterator it = studentData.entrySet().iterator();
		
		while (it.hasNext()) {
			Map.Entry mapElement = (Map.Entry)it.next();
			out.writeObject(mapElement.getValue());
		}
	}

}