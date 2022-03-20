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

public class FirstJavaProgram {
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
		}
		
		//Should be at end of program. Takes all studentData and converts it back into Students.txt
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Students.txt"));
		Iterator it = studentData.entrySet().iterator();
		
		while (it.hasNext()) {
			Map.Entry mapElement = (Map.Entry)it.next();
			out.writeObject(mapElement.getValue());
		}
	}

}